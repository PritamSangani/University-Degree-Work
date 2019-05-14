//
//  AdminLoginViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 12/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class AdminLoginViewController: UIViewController {
    @IBOutlet var idTextField: UITextField!
    @IBOutlet var passwordTextField: UITextField!
    @IBOutlet var statusLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func loginButtonPressed(_ sender: UIButton) {
        let id = idTextField.text
        let password = passwordTextField.text
        // check that username and password are the same and if they are go to next page otherwise populate status labels
        if id=="admin" && password=="password" {
            performSegue(withIdentifier: "adminLogin", sender: self)
        } else {
            statusLabel.text = "Wrong username and/or password"
        }
    }
}
