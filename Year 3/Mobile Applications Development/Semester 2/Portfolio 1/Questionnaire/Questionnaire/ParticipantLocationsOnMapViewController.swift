//
//  ParticipantLocationsOnMapViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 28/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

import UIKit
import MapKit
import CoreLocation

class ParticipantLocationsOnMapViewController: UIViewController, MKMapViewDelegate {
    var locations: [Location]!
    @IBOutlet var mapView: MKMapView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        mapView.delegate = self
        mapView.showsScale = true
        setUpMap()
    }
    
    func setUpMap() {
        // add pin annotation to each location passed into view controller
        for location in locations {
            addPinToMapView(title: location.city, location: location.locationObject)
        }
    }
    
    
    func addPinToMapView(title: String?, location: CLLocation) {
        if let title = title {
            let annotation = MKPointAnnotation()
            
            annotation.coordinate = location.coordinate
            annotation.title = title
            
            mapView.addAnnotation(annotation)
        }
    }

}
