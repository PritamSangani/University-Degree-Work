//
//  ViewStatisticsViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 28/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import Charts

class ViewLocationPieChartViewController: ChartsViewController {
    // MARK: Properties to hold chart data
    var uniqueLocations: [String : Int]!
    let CHART_TITLE = "Share of Questionnaires by Location"
    //MARK: Outlets for Charts
    @IBOutlet var pieChartView: PieChartView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.pieChart = pieChartView
        uniqueLocations = getUniqueLocations()
        // Do any additional setup after loading the view.
        renderCharts()
        
    }
    
    func getUniqueLocations() -> [String : Int]{
        var uniqueLocations = [String : Int]()
        
        for location in self.locations {
            if uniqueLocations.keys.contains(location.city) {
                let count = uniqueLocations[location.city]
                uniqueLocations.updateValue(count!+1, forKey: location.city)
            } else {
                uniqueLocations[location.city] = 1
            }
        }
        
        return uniqueLocations
    }

    @IBAction func renderCharts() {
        pieChartUpdate(uniqueData: uniqueLocations, chartTitle: CHART_TITLE)
    }

}
