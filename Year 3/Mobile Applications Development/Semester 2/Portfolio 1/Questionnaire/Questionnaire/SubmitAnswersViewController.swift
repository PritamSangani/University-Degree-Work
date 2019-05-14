//
//  SubmitAnswersViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 13/02/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import CoreData

class SubmitAnswersViewController: UIViewController {
    var questionnaire: Questionnaire!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func finishQuestionnaireButtonPressed(_ sender: UIButton) {
        // Core Data Goes here
        for question in questionnaire.answers {
            print(question)
        }
        
        let validIdAlert = UIAlertController(title: "Submit Questionnaire", message: "Are you happy with all the answers to the questionnaire?", preferredStyle: .alert)
        
        validIdAlert.addAction(UIAlertAction(title: "Yes", style: .default, handler: { (action: UIAlertAction!) in
            self.sendDataToCoreData()
            self.performSegue(withIdentifier: "finalSegue", sender: self)
        }))
        
        validIdAlert.addAction(UIAlertAction(title: "No", style: .cancel, handler: { (action: UIAlertAction!) in }))
        
        self.present(validIdAlert, animated: true, completion: nil)
        
        
    }
    
    func sendDataToCoreData() {
        // create instance of AppDelegate to get access to coreData related functions
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return }
        
        //We need to create a context from this container
        let managedContext = appDelegate.persistentContainer.viewContext
        
        //Now let’s create an entity.
        let userEntity = NSEntityDescription.entity(forEntityName: "QuestionnaireData", in: managedContext)!
        
        let questionnaireEntity = NSManagedObject(entity: userEntity, insertInto: managedContext)
        questionnaireEntity.setValue(questionnaire.participant!.id, forKeyPath: "id")
        questionnaireEntity.setValue(questionnaire.participant!.dateOfBirth, forKey: "dob")
        questionnaireEntity.setValue(questionnaire.participant!.location, forKey: "location")
        
        // go through array of answers and set value using the answer as the value and the key as the question title, set in each ViewController and are the same as
        // keys in CoreData Entity
        for question in questionnaire!.answers {
            questionnaireEntity.setValue(question.answer, forKey: question.questionTitle)
        }
        
        //The next step is to save them inside the Core Data
        
        do {
            try managedContext.save()
            
        } catch let error as NSError {
            print("Could not save. \(error), \(error.userInfo)")
            // maybe send user an alert
        }
        
    }
    
}
