//
//  Questionnaire.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 28/02/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import Foundation


// Structures to hold all data about questionnaire
struct Questionnaire {
    var participant: Participant!
    var answers = [Answer]()
    
    init(participant: Participant) {
        self.participant = participant
    }
}

struct Participant {
    var id : String
    var dateOfBirth : String
    var location : String
    
    init(id: String, dateOfBirth: String, location: String) {
        self.id = id
        self.dateOfBirth = dateOfBirth
        self.location = location
    }
}

struct Answer {
    var questionTitle: String
    var answer: String!
    
    init(questionTitle: String) {
        self.questionTitle = questionTitle
    }
    
    public var description: String {
        return "\(questionTitle): \(String(describing: answer))"
    }
    
}

// structure to hold list of all questions
struct Questions {
    let questions: [String] = ["Question 1: Have you used an iPad before?",
                               "Question 2a: What is your main use of the iPad?",
                               "Question 2b: After using the iPad today, how would you rate its usability?",
                               "Question 3: Would you consider using an iPad again in the future?"]
}
