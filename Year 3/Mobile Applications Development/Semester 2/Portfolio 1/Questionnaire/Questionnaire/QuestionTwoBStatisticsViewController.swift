//
//  QuestionTwoBStatisticsViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 29/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import Charts

class QuestionTwoBStatisticsViewController: ChartsViewController {

    var answerCount: [String : Int]!
    let CHART_TITLE = "Share of Answers for Question 2b"
    @IBOutlet var pieChartView: PieChartView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.pieChart = pieChartView
        // Do any additional setup after loading the view.
        answerCount = countUpAnswers(forIndex: 2)
        
        renderCharts()
        // Do any additional setup after loading the view.
    }
    
    
    
    @IBAction func renderCharts() {
        pieChartUpdate(uniqueData: answerCount, chartTitle: CHART_TITLE)
    }

}
