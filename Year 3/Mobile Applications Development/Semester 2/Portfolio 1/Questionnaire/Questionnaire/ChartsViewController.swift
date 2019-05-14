//
//  ChartsViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 28/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import Charts

class ChartsViewController: UIViewController {
    @IBOutlet weak var pieChart: PieChartView?
    var results: [Questionnaire]!
    var locations: [Location]!
    let formatter = NumberFormatter()
    
    override func viewDidLoad() {
        // display results as integers and not floats
        formatter.minimumFractionDigits = 0
    }
    
    // function to generate random colour for each section of chart
    func generateRandomColour() -> UIColor {
        let hue : CGFloat = CGFloat(arc4random() % 256) / 256 // use 256 to get full range from 0.0 to 1.0
        let saturation : CGFloat = CGFloat(arc4random() % 128) / 256 + 0.5 // from 0.5 to 1.0 to stay away from white
        let brightness : CGFloat = CGFloat(arc4random() % 128) / 256 + 0.5 // from 0.5 to 1.0 to stay away from black
        
        return UIColor(hue: hue, saturation: saturation, brightness: brightness, alpha: 1)
    }
    
    // function to update pie chart which takes in data and title of chart
    func pieChartUpdate (uniqueData: [String:Int], chartTitle: String) {
        var pieChartEntries = [PieChartDataEntry]()
        var colours = [UIColor]()
        
        // for each section of pie chart
        for data in uniqueData {
            // create a entry(section) for the pie chart
            let entry = PieChartDataEntry(value: Double(data.value), label: data.key)
            let colour = self.generateRandomColour()
            
            pieChartEntries.append(entry)
            colours.append(colour)
        }
        // create a pie chart data set
        let dataSet = PieChartDataSet(entries: pieChartEntries, label: nil)
        let data = PieChartData(dataSet: dataSet)
        // assign colours to data set. The corresponding indices in each array decides which colour is used for each section
        dataSet.colors = colours
        
        // attach data to pie chart
        self.pieChart?.data = data
        self.pieChart?.chartDescription?.text = chartTitle
        self.pieChart?.chartDescription?.font = UIFont.systemFont(ofSize: 16, weight: .medium)
        self.pieChart?.legend.font = UIFont.systemFont(ofSize: 16, weight: .medium)
        
        // set formatter of data to cast to integer (otherwise would be displayed as floats)
        data.setValueFormatter(DefaultValueFormatter(formatter:self.formatter))
        //This must stay at end of function
        self.pieChart?.notifyDataSetChanged()
    }
    
    // function to tally up all the unique answers of the questionnaire data
    func countUpAnswers(forIndex: Int) -> [String : Int] {
        var uniqueAnswers = [String : Int]()
        if self.results != nil {
            for result in self.results {
                let answer = result.answers[forIndex].answer ?? ""
                if uniqueAnswers.keys.contains(answer) {
                    let count = uniqueAnswers[answer]
                    uniqueAnswers.updateValue(count!+1, forKey: answer)
                } else {
                    uniqueAnswers[answer] = 1
                }
                
            }
        }
        return uniqueAnswers
    }
}
