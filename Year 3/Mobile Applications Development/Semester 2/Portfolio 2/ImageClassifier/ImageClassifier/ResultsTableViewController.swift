//
//  ResultsTableViewController.swift
//  ImageClassifier
//
//  Created by Pritam Sangani on 21/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import CoreData

class ResultsTableViewController: UITableViewController {
    // MARK: Properties
    var results =  [Result]()
    var selectedResult: Result!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadResultsIntoTable()
    }

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
        
        let result = results[indexPath.row]
        
        cell.accuracyLabel.text = String(result.accuracy)
        cell.locationLabel.text = result.shortLocation
        cell.photoImageView.image = result.photo
        
        return cell
    }
    
    private func loadResultsIntoTable() {
        results += retrieveResultsFromCoreData()
    }
    
    private func retrieveResultsFromCoreData() -> [Result] {
        var returnedResults = [Result]()
        //As we know that container is set up in the AppDelegates so we need to refer that container.
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return returnedResults}
        
        //We need to create a context from this container
        let managedContext = appDelegate.persistentContainer.viewContext
        
        //Prepare the request of type NSFetchRequest  for the entity
        let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: "Results")
        
        fetchRequest.sortDescriptors = [NSSortDescriptor.init(key: "id", ascending: false)]
        
        do {
            let result = try managedContext.fetch(fetchRequest)
            
            if result.count == 0 { return returnedResults}
            
            for data in result as! [NSManagedObject] {
                var accuracy: Float!
                var shortLocation: String!
                var fullLocation: String!
                var photo: UIImage?
                
                accuracy = data.value(forKey: "accuracy") as? Float
                shortLocation = data.value(forKey: "shortLocation") as? String
                fullLocation = data.value(forKey: "fullLocation") as? String
                photo = UIImage(data: (data.value(forKey: "photo") as? Data)!)
                
                let thisResult = Result(accuracy: accuracy, fullLocation: fullLocation, shortLocation: shortLocation, photo: photo)!
                returnedResults.append(thisResult)
            }
            
        } catch {
            print("Failed")
        }
        return returnedResults
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        // perform segue and pass over data : result object
        self.selectedResult = results[indexPath.row]
        performSegue(withIdentifier: "fullResults", sender: self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "fullResults" {
            if segue.destination is FullResultsViewController {
                let vc = segue.destination as? FullResultsViewController
                vc?.result = selectedResult
            }
        }
    }

}
