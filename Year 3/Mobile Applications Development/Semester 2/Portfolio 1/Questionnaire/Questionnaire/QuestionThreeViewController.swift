//
//  QuestionThreeViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 13/02/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class QuestionThreeViewController: UIViewController {
    var questionnaire: Questionnaire!
    var question: Answer!
    @IBOutlet var buttonsCollection: [UIButton]!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        question = Answer(questionTitle: "question_3")
    }
    
    @IBAction func buttonPressed(_ sender: UIButton) {
        for button in buttonsCollection {
            button.isSelected = (sender.accessibilityIdentifier != button.accessibilityIdentifier) ? false : true
        }
    }
    
    @IBAction func nextQuestionButtonPressed(_ sender: UIButton) {
        var buttonSelected = false
        var buttonId: String?
        for button in buttonsCollection {
            buttonSelected = (button.isSelected) ? !buttonSelected : buttonSelected
            if button.isSelected {
                buttonId = button.accessibilityIdentifier
            }
        }
        print("Button ID: \(buttonId ?? "no button id")")
        question.answer = buttonId
        questionnaire.answers.removeAll(where: {question!.questionTitle == $0.questionTitle})
        questionnaire.answers.append(question!)
        // do segue
        if buttonSelected {
            performSegue(withIdentifier: "finishQuestionnaire", sender: self)
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "finishQuestionnaire" {
            if segue.destination is SubmitAnswersViewController {
                let vc = segue.destination as? SubmitAnswersViewController
                print("Question: \(question!.answer!)")
                vc?.questionnaire = questionnaire
            }
        }
    }
}
