//
//  Result.swift
//  ImageClassifier
//
//  Created by Pritam Sangani on 21/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit

// object to hold all data for Results
class Result {
    var accuracy: Float
    var fullLocation: String
    var shortLocation: String
    var photo: UIImage?
    
    init?(accuracy: Float, fullLocation: String, shortLocation: String, photo: UIImage? ) {
        self.accuracy = accuracy
        self.fullLocation = fullLocation
        self.shortLocation = shortLocation
        self.photo = photo
    }
}
