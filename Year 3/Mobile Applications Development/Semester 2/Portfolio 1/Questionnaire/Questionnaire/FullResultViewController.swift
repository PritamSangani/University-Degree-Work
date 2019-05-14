//
//  FullResultViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 27/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class FullResultViewController: UIViewController {
    var result: Questionnaire!
    
    @IBOutlet var questionsLabelCollection: [UILabel]!
    @IBOutlet var answersLabelCollection: [UILabel]!
    @IBOutlet var idLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        assignLabels()
        // Do any additional setup after loading the view.
        
    }
    
    func assignLabels() {
        idLabel.text = result.participant.id
        assignQuestionsLabels()
        assignAnswersLabels()
    }
    
    func assignQuestionsLabels() {
        for (i, label) in questionsLabelCollection.enumerated() {
            label.text = result.answers[i].questionTitle
        }
    }
    
    func assignAnswersLabels() {
        for (i, label) in answersLabelCollection.enumerated() {
            label.text = result.answers[i].answer
        }
    }
}
