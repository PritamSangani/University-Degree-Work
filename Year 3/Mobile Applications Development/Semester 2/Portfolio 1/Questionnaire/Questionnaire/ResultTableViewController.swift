//
//  ResultTableViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 27/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import CoreData
import CoreLocation
import MessageUI

class ResultTableViewController: UITableViewController, MFMailComposeViewControllerDelegate {
    
    var results = [Questionnaire]()
    var locations = [Location]()
    var selectedResult: Questionnaire!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // load all questionnaire data into TableView
        loadResultsIntoTable()
        
        // add buttons to nav bar in the right hand side and attach corresponding handlers
        let export = UIBarButtonItem(title: "Export to CSV", style: .plain, target: self, action: #selector(exportCsvButtonPressed))
        let map = UIBarButtonItem(title: "View Locations on Map", style: .plain, target: self, action: #selector(mapButtonPressed))
        let statistics = UIBarButtonItem(title: "View Statistics", style: .plain, target: self, action: #selector(statisticsButtonPressed))
        navigationItem.rightBarButtonItems = [export, map, statistics]
    }
    
    @objc func exportCsvButtonPressed() {
        exportCsvFile()
    }
    
    @objc func mapButtonPressed() {
        performSegue(withIdentifier: "showMap", sender: self)
    }
    
    @objc func statisticsButtonPressed() {
        performSegue(withIdentifier: "statisticsPageView", sender: self)
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return results.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cellIdentifier = "ResultTableViewCell"
        guard let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath) as? ResultTableViewCell else {
            fatalError("The dequeued cell is not an instance of ResultTableViewCell")
        }
        
        // set outlets defined in ResultTableViewCell.swift for corresponding row of table view from results array
        let result = results[indexPath.row]
        // if locations array contains the index of the row set that location otherwise set using coordinates from participant object.
        // this is because reverse geocoding is a asynchronous function so placemark is only available after parent function has returned
        let location = (locations.indices.contains(indexPath.row)) ? locations[indexPath.row].city : result.participant.location
        cell.idLabel.text = result.participant.id
        cell.locationLabel.text = location
        cell.dateOfBirthLabel.text = result.participant.dateOfBirth
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        // get result object for corresponding index of row in tableview
        self.selectedResult = results[indexPath.row]
        performSegue(withIdentifier: "fullResult", sender: self)
    }
    
    func loadResultsIntoTable() {
        results = retrieveResultsFromCoreData()
    }
    
    func retrieveResultsFromCoreData() -> [Questionnaire] {
        // create an emoty array of Questionnaire objects
        var returnedResults = [Questionnaire]()
        //As we know that container is set up in the AppDelegates so we need to refer that container.
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return returnedResults}
        
        //We need to create a context from this container
        let managedContext = appDelegate.persistentContainer.viewContext
        
        //Prepare the request of type NSFetchRequest  for the entity
        let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "QuestionnaireData")
        //sort by id
        fetchRequest.sortDescriptors = [NSSortDescriptor.init(key: "id", ascending: false)]
        
        do {
            let result = try managedContext.fetch(fetchRequest)
            
            if result.count == 0 { return returnedResults}
            
            for data in result as! [NSManagedObject] {
                var id: String!
                var dateOfBirth: String!
                var location: String!
                
                var questionKeys = [String]()
                var answers = [String]()
                
                // get all keys in entity that has a prefix of "question"
                for key in data.entity.propertiesByName.keys {
                    if key.hasPrefix("question") {
                        questionKeys.append(key)
                    }
                }
                // sort keys alphabetically to ensure that questions are in order
                questionKeys.sort()
                
                // add all answers to answers array
                for key in questionKeys {
                    answers.append(data.value(forKey: "\(key)") as? String ?? "N/A")
                }
                
                id = data.value(forKey: "id") as? String
                dateOfBirth = data.value(forKey: "dob") as? String
                location = data.value(forKey: "location") as? String
                var coordinates = location.components(separatedBy: ",")
                // convert coordinates which are in string format to CLLocation object
                let coordinatesObject = CLLocation(latitude: Double(coordinates[0])!, longitude: Double(coordinates[1])!)
            
                // reverse geocode coordinates object to get placemark object and from there the city - this will be displayed instead of coordinates when avaialble
                coordinatesObject.geocode { placemark, error in
                    
                    if let error = error as? CLError {
                        print("CLError:", error)
                        return
                    } else if let placemark = placemark?.first {
                        // you should always update your UI in the main thread
                        DispatchQueue.main.async {
                            self.locations.append(Location(city: placemark.subAdministrativeArea ?? "no city", locationObject: coordinatesObject))
                            // refresh data in tableview to show reverse geocoded location
                            self.tableView.reloadData()
                        }
                    }
                    
                }
                
                let participant = Participant(id: id, dateOfBirth: dateOfBirth, location: location)
                var answersArray = [Answer]()
                let questions = Questions().questions
                
                for (i,question) in questions.enumerated() {
                    var answer = Answer(questionTitle: question)
                    answer.answer = answers[i]
                    answersArray.append(answer)
                }
                
                var thisResult = Questionnaire(participant: participant)
                thisResult.answers = answersArray
                returnedResults.append(thisResult)
            }
            
        } catch {
            print("Failed")
        }
        return returnedResults
    }
    
    func exportCsvFile() {
        // get data of csv file in String format
        let csvData = createCsvData()
        
        // create instance of file manager
        let fileManager = FileManager.default
        do {
            // create path to documents directory
            let path = try fileManager.url(for: .documentDirectory, in: .allDomainsMask, appropriateFor: nil, create: false)
            
            print("Path: \(path.absoluteString)")
            
            // append name of file to path to get absolute path to the actual file
            let fileURL = path.appendingPathComponent("Questionnaires.csv")
            //open the file for writing and write csv data to file
            try csvData.write(to: fileURL, atomically: true, encoding: .utf8)
            
            // get contents of csv file that we have just written to
            let fileData = NSData(contentsOfFile: fileURL.absoluteURL.relativePath)
            print("File Data: \(String(describing: fileData))")
            
            // if the file is not empty send email
            if fileData != nil {
                sendEmail(path: path.absoluteURL.relativePath, data: fileData! as Data)
            }
        } catch {
            print("error creating file")
        }
        
    }
    
    // return data that will be written to csv file in string format
    func createCsvData() -> String {
        // header/columns of csv file - \n delimitter to create end of line and next line will write to new line
        var csvData = "id,Date of Birth,Location,Question 1,Question 2a,Question 2b,Question 3\n"
        
        for result in results {
            let id = result.participant.id
            let dob = result.participant.dateOfBirth
            let location = result.participant.location
            let q1 = result.answers[0].answer ?? ""
            let q2a = result.answers[1].answer ?? ""
            let q2b = result.answers[2].answer ?? ""
            let q3 = result.answers[3].answer ?? ""
            
            // create new row for each result/questionnaire
            let newLine = "\(id),\(dob),\"\(location)\",\(q1),\(q2a),\(q2b),\(q3)\n"
            csvData.append(newLine)
        }
        
        return csvData
    }
    
    func sendEmail(path: String, data: Data) {
        //check that the device can send an email
        if MFMailComposeViewController.canSendMail() {
            let mail = MFMailComposeViewController()
            mail.mailComposeDelegate = self
            mail.setToRecipients(["pritam.sangani@gmail.com"])
            mail.setMessageBody("<p>This is the latest data from the Questionnaire in CSV format.</p>", isHTML: true)
            mail.addAttachmentData(data, mimeType: "text/csv", fileName: "Questionnaires.csv")
            present(mail, animated: true, completion: nil)
        } else {
            // show failure alert
            print("can't send email")
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "fullResult" {
            if segue.destination is FullResultViewController {
                let vc = segue.destination as? FullResultViewController
                vc?.result = selectedResult
            }
        } else if segue.identifier == "showMap" {
            if segue.destination is ParticipantLocationsOnMapViewController {
                let vc = segue.destination as? ParticipantLocationsOnMapViewController
                vc?.locations = locations
            }
        } else if segue.identifier == "statisticsPageView" {
            if segue.destination is StatisticsPageViewController {
                let vc = segue.destination as? StatisticsPageViewController
                vc?.results = results
                vc?.locations = locations
            }
        }
    }
}

extension CLLocation {
    func geocode(completion: @escaping (_ placemark: [CLPlacemark]?, _ error: Error?) -> Void)  {
        CLGeocoder().reverseGeocodeLocation(self, completionHandler: completion)
    }
}

// structure to hold location data (city name in String format and location object to pass to map so cllocation object won't have to be created again)
struct Location {
    var city: String!
    var locationObject: CLLocation!
}
