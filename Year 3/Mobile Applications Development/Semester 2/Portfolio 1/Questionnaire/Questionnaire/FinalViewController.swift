//
//  FinalViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 07/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class FinalViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // hide back button so user cannot go back and save again
        // a unwind segue has been create using Storyboard that takes user back to start screen when button is pressed
        self.navigationItem.setHidesBackButton(true, animated: false)
        // Do any additional setup after loading the view.
    }
}
