//
//  ResultTableViewCell.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 27/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
// class to hold outlets for each cell in table view
class ResultTableViewCell: UITableViewCell {
    // MARK: Properties
    @IBOutlet var idLabel: UILabel!
    @IBOutlet var dateOfBirthLabel: UILabel!
    @IBOutlet var locationLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
