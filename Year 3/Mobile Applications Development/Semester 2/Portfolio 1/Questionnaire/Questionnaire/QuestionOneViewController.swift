//
//  QuestionOneViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 13/02/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class QuestionOneViewController: UIViewController {
    //MARK: Properties
    var participant: Participant!
    var questionnaire: Questionnaire!
    var question: Answer!
    
    //MARK: Outlets
    @IBOutlet var buttonsCollection: [UIButton]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        questionnaire = Questionnaire(participant: participant!)
        question = Answer(questionTitle: "question_1")
    }
    
    @IBAction func buttonPressed(_ sender: UIButton) {
        // when button is selected, deselect all other buttons in the UIButton outlet collection
        for button in buttonsCollection {
            button.isSelected = (sender.accessibilityIdentifier != button.accessibilityIdentifier) ? false : true
        }
    }
    
    @IBAction func nextQuestionButtonPressed(_ sender: Any) {
        var buttonSelected = false
        var buttonId: String?
        // when next button is pressed work out if a button is selected and if there is a button selected assign the accessibilityId of the button to the buttonId prop
        for button in buttonsCollection {
            buttonSelected = (button.isSelected) ? !buttonSelected : buttonSelected
            if button.isSelected {
                buttonId = button.accessibilityIdentifier
            }
        }
        
        question.answer = buttonId
        // remove answers that have the same question title so there are no duplicates if user comes back to same question and changes answer
        questionnaire.answers.removeAll(where: {question!.questionTitle == $0.questionTitle})
        questionnaire.answers.append(question!)
        // perform segue if a button is selected, using button identfier to work out which segue to perform
        if buttonSelected {
            buttonId=="yes" ? performSegue(withIdentifier: "questionTwoA", sender: self) : performSegue(withIdentifier: "questionTwoB", sender: self)
        }
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        if segue.identifier == "questionTwoA" {
            if segue.destination is QuestionTwoAViewController {
                let vc = segue.destination as? QuestionTwoAViewController
                vc?.questionnaire = questionnaire
            }
        }
        if segue.identifier == "questionTwoB" {
            if segue.destination is QuestionTwoBViewController {
                let vc = segue.destination as? QuestionTwoBViewController
                vc?.questionnaire = questionnaire
            }
        }
    }
}

