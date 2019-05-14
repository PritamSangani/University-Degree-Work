//
//  ViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 04/02/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

/*
    ViewController to control the UI for the Login/Start Screen
 
 */
import UIKit
import Foundation
import CoreLocation

class ViewController: UIViewController, CLLocationManagerDelegate {

    //MARK: Outlets
    @IBOutlet var dateTextField: UITextField!
    @IBOutlet var idTextField: UITextField!
    @IBOutlet var locationTextField: UITextField!
    @IBOutlet var idStatusLabel: UILabel!
    @IBOutlet var dateStatusLabel: UILabel!
    @IBOutlet var locationStatusLabel: UILabel!
    
    //MARK: Properties
    private var datePicker: UIDatePicker?
    var id: String?
    var date: String?
    var location: String?
    var locationManager: CLLocationManager!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // generate UUID when ViewController loads and assign to the TextField for the id
        idTextField.text = generateUniqueQuestionnaireId()
        
        // set up DatePicker
        setUpDatePicker()
        
        // set up location service
        locationManager = CLLocationManager()
        getLocation()
    }
    
    func setUpDatePicker() {
        datePicker = UIDatePicker()
        datePicker?.datePickerMode = .date
        // format date picker to fit GB date format
        datePicker?.locale = Locale(identifier: "en_GB")
        // set maximum date of date picker - as per assignment spec (questionnaire for > 65 yrs)
        let currentDate = Calendar.current
        let maxDate = currentDate.date(byAdding: .year, value: -65, to: Date())
        datePicker?.maximumDate = maxDate
        datePicker?.addTarget(self, action: #selector(self.dateSelected(datePicker:)), for: .valueChanged)
        
        dateTextField.inputView = datePicker
        
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(self.tapGestureMade(gestureRecogniser: )))
        
        view.addGestureRecognizer(tapGesture)
    }
    
    @objc func dateSelected(datePicker: UIDatePicker) {
        // when date is selected using date picker assign it to the TextField for date in GB format
        let dateFormat = DateFormatter()
        dateFormat.locale = Locale(identifier: "en_GB")
        dateFormat.setLocalizedDateFormatFromTemplate("dd/MM/yyyy")
        
        dateTextField.text = dateFormat.string(from: datePicker.date)
    }
    
    @objc func tapGestureMade(gestureRecogniser: UITapGestureRecognizer) {
        // when a tap gesture is made outside of DatePicker view, close DatePicker
        view.endEditing(true)
    }
    
    func generateUniqueQuestionnaireId() -> String {
        // use built-in Swift UUID api to generate UUID for questionnaire id
        return UUID().uuidString
    }

    @IBAction func startButtonPressed(_ sender: Any) {
        /* TODO: validate id input
                    if (valid) alert "Are details correct"
                    else label next to field in red text saying why input is invalid
         */
        // assign text values of TextField's to corresponding global properties
        id = idTextField.text
        date = dateTextField.text
        location = locationTextField.text
        
        // check details for validity
        let status = checkDetailsForValidity(id: id ?? "", date: date ?? "", location: location ?? "")
        if status {
            let validIdAlert = UIAlertController(title: "Valid Details", message: "Are all your details correct?", preferredStyle: .alert)
            
            validIdAlert.addAction(UIAlertAction(title: "Yes", style: .default, handler: { (action: UIAlertAction!) in
                self.performSegue(withIdentifier: "questionOne", sender: self)
            }))
            
            validIdAlert.addAction(UIAlertAction(title: "No", style: .cancel, handler: nil))
            
            self.present(validIdAlert, animated: true, completion: nil)
        }
    }
    
    
    
    func checkDetailsForValidity(id: String, date: String, location: String) -> Bool {
        
        let idStatus = checkIdFieldForValidity(id: id)
        let dateStatus = checkDateFieldForValidity(date: date)
        let locationStatus = checkLocationFieldForValidity(location: location)

        if idStatus && dateStatus && locationStatus {
            return true
        } else {
            idStatusLabel.text = idStatus ? "" : "* ID is invalid"
            dateStatusLabel.text = dateStatus ? "" : "* Date is invalid"
            locationStatusLabel.text = locationStatus ? "" : "* Location needs to be granted"
            
            return false
        }
    }
    
    func checkIdFieldForValidity(id: String) -> Bool {
        return (id == "") ? false : true
    }
    
    func checkDateFieldForValidity(date: String) -> Bool {
        let dateFormat = DateFormatter()
        dateFormat.locale = Locale(identifier: "en_GB")
        dateFormat.setLocalizedDateFormatFromTemplate("dd/MM/yyyy")
        
        return (dateFormat.date(from: date) != nil) ? true : false
    }
    
    func checkLocationFieldForValidity(location: String) -> Bool {
        return (location=="") ? false : true
    }
    
    func getLocation() {
        // get current authorisation status for LocationServices
        let status = CLLocationManager.authorizationStatus()
        
        switch status {
        case .notDetermined:
            locationManager.requestWhenInUseAuthorization()
            break
        case .denied, .restricted:
            // if permission for location use is denied - alert user to accept in Settings app
            let alertController = UIAlertController(title: "Location Services disabled", message: "Please enable Location Services in the Settings app.", preferredStyle: .alert)
            let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
            alertController.addAction(okAction)
            
            present(alertController, animated: true, completion: nil)
            
            return
        case .authorizedAlways, .authorizedWhenInUse:
            break
        }
        
        locationManager.delegate = self
        locationManager.startUpdatingLocation()
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        if let currentLocation = locations.last {
            self.locationTextField.text = "\(currentLocation.coordinate.latitude),\(currentLocation.coordinate.longitude)"
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print(error)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // perform segue and pass current participant object if identifier == "questionOne"
        if segue.identifier == "questionOne" {
            if segue.destination is QuestionOneViewController {
                // create instance of next viewcontroller
                let vc = segue.destination as? QuestionOneViewController
                let participant = Participant(id: id ?? "", dateOfBirth: date ?? "", location: location ?? "")
                vc?.participant = participant
            }
        }
    }
    // function that deals with unwind call in final viewcontroller
    @IBAction func unwindBackToStart(segue: UIStoryboardSegue) {
        getLocation()
        dateTextField.text = ""
        idTextField.text = generateUniqueQuestionnaireId()
    }
    
}

