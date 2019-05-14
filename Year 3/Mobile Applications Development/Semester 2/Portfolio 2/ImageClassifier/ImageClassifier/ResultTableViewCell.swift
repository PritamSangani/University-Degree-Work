//
//  ResultTableViewCell.swift
//  ImageClassifier
//
//  Created by Pritam Sangani on 21/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
// class holding outlets for cell in table view
class ResultTableViewCell: UITableViewCell {
    
    // MARK: Properties
    @IBOutlet var locationLabel: UILabel!
    @IBOutlet var accuracyLabel: UILabel!
    @IBOutlet var photoImageView: UIImageView!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
