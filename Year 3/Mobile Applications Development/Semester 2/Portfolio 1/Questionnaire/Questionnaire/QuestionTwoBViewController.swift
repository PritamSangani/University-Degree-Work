//
//  QuestionTwoBViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 13/02/2019.
//  Copyright 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class QuestionTwoBViewController: UIViewController {
    var questionnaire: Questionnaire!
    var question: Answer!
    @IBOutlet var slider: UISlider!
    @IBOutlet var labelsCollection: [UILabel]!
    var selectedLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        question = Answer(questionTitle: "question_2b")
        slider.minimumValue = 0
        slider.maximumValue = 100
        slider.value = 50
    }
    
    @IBAction func sliderValueChanged(_ sender: UISlider) {
        // work out which answer is selected using value of slider
        let sliderValue = sender.value
        var label: UILabel!
        
        switch sliderValue {
        case _ where sliderValue >= 0 && sliderValue < 12.5:
            //retrieve reference to label that corresponds to identifier passed in to function
            label = findUILabel(labelIdentifier: "very easy")
        case _ where sliderValue >= 12.5 && sliderValue < 37.5:
            label = findUILabel(labelIdentifier: "easy")
        case _ where sliderValue >= 37.5 && sliderValue < 62.5:
            label = findUILabel(labelIdentifier: "easy/difficult")
        case _ where sliderValue >= 62.5 && sliderValue < 87.5:
            label = findUILabel(labelIdentifier: "difficult")
        case _ where sliderValue >= 87.5 && sliderValue <= 100:
            label = findUILabel(labelIdentifier: "very difficult")
        default:
            print("no value: \(sliderValue)")
        }
        
        changeLabelColour(label: label)
        selectedLabel = label
    }
    
    func changeLabelColour(label: UILabel) {
        // change passed in label to a green text colour - all other UILabels get changed to black text colour
        for l in labelsCollection {
            if l.accessibilityIdentifier == label.accessibilityIdentifier {
                l.textColor = UIColor(red:0.21, green:0.69, blue:0.22, alpha:1.0)
            } else {
                l.textColor = UIColor.black
            }
        }
    }
    
    func findUILabel(labelIdentifier: String) -> UILabel {
        let errorLabel = UILabel()
        for label in labelsCollection {
            if label.accessibilityIdentifier == labelIdentifier {
                return label
            }
        }
        print("error")
        return errorLabel
    }
    
    @IBAction func nextQuestionButtonPressed(_ sender: UIButton) {
        question.answer = selectedLabel.accessibilityIdentifier
        questionnaire.answers.removeAll(where: {question!.questionTitle == $0.questionTitle})
        questionnaire.answers.append(question!)
        
        performSegue(withIdentifier: "questionThreeB", sender: self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "questionThreeB" {
            if segue.destination is QuestionThreeViewController {
                let vc = segue.destination as? QuestionThreeViewController
                print("Question: \(question!.answer!)")
                vc?.questionnaire = questionnaire
            }
        }
    }
}
