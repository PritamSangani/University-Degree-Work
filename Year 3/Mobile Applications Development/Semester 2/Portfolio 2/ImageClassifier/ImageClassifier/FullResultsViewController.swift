//
//  FullResultsViewController.swift
//  ImageClassifier
//
//  Created by Pritam Sangani on 21/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

class FullResultsViewController: UIViewController {
    // MARK: Properties
    @IBOutlet var photoImageView: UIImageView!
    @IBOutlet var shortLocationLabel: UILabel!
    @IBOutlet var fullLocationLabel: UILabel!
    @IBOutlet var accuracyLabel: UILabel!
    
    var result: Result!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        photoImageView.image = result.photo
        shortLocationLabel.text = result.shortLocation
        fullLocationLabel.text = result.fullLocation
        accuracyLabel.text = "\(result.accuracy)%"
        // Do any additional setup after loading the view.
        // change size of label to fit the text in the label
        fullLocationLabel.sizeToFit()
    }

}
