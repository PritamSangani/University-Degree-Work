//
//  QuestionTwoAStatisticsViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 28/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import Charts

class QuestionTwoAStatisticsViewController: ChartsViewController {

    var answerCount: [String : Int]!
    let CHART_TITLE = "Share of Answers for Question 2a"
    @IBOutlet var pieChartView: PieChartView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.pieChart = pieChartView
        // Do any additional setup after loading the view.
        answerCount = countUpAnswers(forIndex: 1)
        
        renderCharts()
        // Do any additional setup after loading the view.
    }
    
    @IBAction func renderCharts() {
        pieChartUpdate(uniqueData: answerCount, chartTitle: CHART_TITLE)
    }
}
