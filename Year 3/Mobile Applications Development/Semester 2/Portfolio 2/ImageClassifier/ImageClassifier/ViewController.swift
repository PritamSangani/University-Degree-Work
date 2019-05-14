//
//  ViewController.swift
//  ImageClassifier
//
//  Created by Pritam Sangani on 20/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import CoreML
import Vision
import CoreLocation
import CoreData

class ViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {

    @IBOutlet var statusLabel: UILabel!
    @IBOutlet var displayImageView: UIImageView!
    @IBOutlet var classifyImageButton: UIButton!
    
    private var accuracy: Float!
    private var fullLocation: String!
    private var shortLocation: String!
    private var photo: NSData!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    // function that deals with actions when camera button is pressed
    @IBAction func cameraButtonPressed(_ sender: UIBarButtonItem) {
        // create an instance of an image picker controller
        let imagePicker = UIImagePickerController()
        imagePicker.delegate = self
        
        // create an action sheet alert controller that will alert the user if camera is not available
        let alertController = UIAlertController(title:nil, message: nil, preferredStyle:.actionSheet)
        let cancelAction = UIAlertAction(title: "Camera not available", style: .cancel, handler:nil)
        alertController.addAction(cancelAction)
        
        // if camera is available add action to allow user to take photo using source type of image picker as camera
        if UIImagePickerController.isSourceTypeAvailable(.camera) {
            let cameraAction = UIAlertAction(title:"Take Photo", style:.default, handler:{(_) in imagePicker.sourceType = .camera
                self.present(imagePicker,animated: true,completion:nil)
            })
            alertController.addAction(cameraAction)
        }
        
        present(alertController, animated: true, completion:nil)
    }
    
    @IBAction func galleryButtonPressed(_ sender: UIBarButtonItem) {
        getPhoto()
    }
    
    func getPhoto() {
        let imagePicker = UIImagePickerController()
        imagePicker.delegate = self
        // bring up photo library to allow user to select an image
        imagePicker.sourceType = .photoLibrary
        present(imagePicker, animated: true, completion: nil)
    }
    
    // handler function that deals with what happens when an image is selected
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        guard let selectedImage = info[.originalImage] as? UIImage
            else { return }
        // display image in image view
        displayImageView.image = selectedImage
        // convert photo to NsData type to allow storage in CoreData
        self.photo = selectedImage.pngData() as NSData?
        dismiss(animated: true, completion: nil)
        // show classify button
        classifyImageButton.isHidden = false
    }
    
    @IBAction func classifyImageButtonPressed(_ sender: UIButton) {
        // create instance of mlmodel
        let modelFile = RN1015k500()
        let model = try! VNCoreMLModel(for: modelFile.model)
        
        let handler = VNImageRequestHandler(cgImage: displayImageView.image!.cgImage!, options: [ : ])
        // attach handler function which will execute when classification is complete
        let request = VNCoreMLRequest(model: model, completionHandler: classifyImage)
        
        // perform classification
        try! handler.perform([request])
    }
    
    func classifyImage(request: VNRequest, error: Error?) {
        guard let results = request.results as? [VNClassificationObservation] else {
            fatalError("Unable to get results")
        }
        
        var bestGuess = ""
        var bestConfidence: VNConfidence = 0
        // got through all results (as multiple results can be generated) and get best guess and corresponding accuracy
        for classification in results {
            if (classification.confidence > bestConfidence) {
                bestConfidence = classification.confidence
                bestGuess = classification.identifier
                
            }
        }
        let identifierSplit = bestGuess.components(separatedBy: CharacterSet.whitespacesAndNewlines)
        getLocation(result: identifierSplit, confidence: bestConfidence)
        
    }
    
    func getLocation(result: [String], confidence: VNConfidence) {
        
        let coordinates = "\(result[1]),\(result[2])"
        let locationObject = getLocationFromCoordinatesInString(coordinates: coordinates)
        getPlaceFromCoordinates(location: locationObject, confidence: confidence)
    }
    
    func getLocationFromCoordinatesInString(coordinates: String) -> CLLocation {
        let splitCoordinates = coordinates.split(separator: ",")
        
        return CLLocation(latitude: Double(splitCoordinates[0])!, longitude: Double(splitCoordinates[1])!)
    }
    
    func getPlaceFromCoordinates(location: CLLocation, confidence: VNConfidence) {
        let reverseGeoCoder = CLGeocoder()
        
        reverseGeoCoder.reverseGeocodeLocation(location, completionHandler: { placemarks, error -> Void in
            var place: String?
            var country: String = ""
            var state: String?
            
            guard let placemark = placemarks?.first else {return}
            // get locality and administartive area as one of these could be empty for some countries
            if let name = placemark.locality {
                place = name
            }
            if let nation = placemark.country {
                country = nation
            }
            if let adminArea = placemark.administrativeArea {
                state = adminArea
            }
            
            self.accuracy = confidence*100
            //clean up full location as we don't want text after "@" symbol
            self.fullLocation = placemark.description.components(separatedBy: "@")[0]
            self.shortLocation = "\(place ?? state ?? "a place") in \(country)"
            self.statusLabel.text = "Image is from \(place ?? state ?? "a place") in \(country) with \(confidence*100)% confidence."
            
            // send results to CoreData after location has been found as location function completed last as it is an asynchronous function
            self.sendResultToCoreData()
        })
        
    }
    
    func sendResultToCoreData() {
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return }
        
        //We need to create a context from this container
        let managedContext = appDelegate.persistentContainer.viewContext
        
        //Now let’s create an entity and new user records.
        let entity = NSEntityDescription.entity(forEntityName: "Results", in: managedContext)!
        
        let resultsEntity = NSManagedObject(entity: entity, insertInto: managedContext)
        resultsEntity.setValue(accuracy, forKey: "accuracy")
        resultsEntity.setValue(fullLocation, forKey: "fullLocation")
        resultsEntity.setValue(shortLocation, forKey: "shortLocation")
        resultsEntity.setValue(photo, forKey: "photo")
        
        
        //The next step is to save them inside the Core Data
        
        do {
            try managedContext.save()
            print("Data saved to CoreData")
            
        } catch let error as NSError {
            print("Could not save. \(error), \(error.userInfo)")
            // maybe send user an alert
        }
        
    }
}

