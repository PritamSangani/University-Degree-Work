//
//  QuestionThreeStatisticsViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 29/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import Charts

class QuestionThreeStatisticsViewController: ChartsViewController {

    var answerCount: [String : Int]!
    let CHART_TITLE = "Share of Answers for Question 3"
    
    @IBOutlet var pieChartView: PieChartView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.pieChart = pieChartView
        // Do any additional setup after loading the view.
        answerCount = countUpAnswers(forIndex: 3)
        
        renderCharts()
        // Do any additional setup after loading the view.
    }
    
    @IBAction func renderCharts() {
        pieChartUpdate(uniqueData: answerCount, chartTitle: CHART_TITLE)
    }

}
