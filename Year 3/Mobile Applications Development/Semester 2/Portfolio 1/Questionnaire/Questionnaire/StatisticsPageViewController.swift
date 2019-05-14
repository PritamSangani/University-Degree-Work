//
//  StatisticsPageViewController.swift
//  Questionnaire
//
//  Created by Pritam Sangani on 28/03/2019.
//  Copyright © 2019 Pritam Sangani. All rights reserved.
//

// View controller for UIPageViewController

import UIKit

class StatisticsPageViewController: UIPageViewController, UIPageViewControllerDelegate, UIPageViewControllerDataSource {
    var results: [Questionnaire]!
    var locations: [Location]!
    var pageControl = UIPageControl()
    
    // add all instances of ViewControllers part of the PageView
    lazy var orderedViewControllers: [ChartsViewController] = {
        return [self.newVc(viewController: "locationPieChart"),
                self.newVc(viewController: "question1Stats"),
                self.newVc(viewController: "question2aStats"),
                self.newVc(viewController: "question2bStats"),
                self.newVc(viewController: "question3Stats")]
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.dataSource = self
        
        // This sets up the first view that will show up on our page control
        if let firstViewController = orderedViewControllers.first {
            firstViewController.results = results
            firstViewController.locations = locations
            
            setViewControllers([firstViewController],
                               direction: .forward,
                               animated: true,
                               completion: nil)
        }
        
        self.delegate = self
        configurePageControl()

        // Do any additional setup after loading the view.
    }
    
    func newVc(viewController: String) -> ChartsViewController {
        // create instance of storyboard as an implementation of ChartsViewController (used for all pages involving charts in page view)
        let vc =  UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: viewController) as! ChartsViewController
        // assign variables in new view controller
        vc.results = results
        vc.locations = locations
        
        return vc
    }
    
    // MARK: Data source functions.
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerBefore viewController: UIViewController) -> UIViewController? {
        guard let viewControllerIndex = orderedViewControllers.index(of: viewController as! ChartsViewController) else {
            return nil
        }
        
        let previousIndex = viewControllerIndex - 1
        
        // User is on the first view controller and swiped left to loop to
        // the last view controller.
        guard previousIndex >= 0 else {
             return orderedViewControllers.last
        }
        
        guard orderedViewControllers.count > previousIndex else {
            return nil
        }
        
        return orderedViewControllers[previousIndex]
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerAfter viewController: UIViewController) -> UIViewController? {
        guard let viewControllerIndex = orderedViewControllers.index(of: viewController as! ChartsViewController) else {
            return nil
        }
        
        let nextIndex = viewControllerIndex + 1
        let orderedViewControllersCount = orderedViewControllers.count
        
        // User is on the last view controller and swiped right to loop to
        // the first view controller.
        guard orderedViewControllersCount != nextIndex else {
             return orderedViewControllers.first
        }
        
        guard orderedViewControllersCount > nextIndex else {
            return nil
        }
        
        return orderedViewControllers[nextIndex]
    }
    
    func configurePageControl() {
        // The total number of pages that are available is based on how many available colors we have.
        pageControl = UIPageControl(frame: CGRect(x: 0,y: UIScreen.main.bounds.maxY - 50,width: UIScreen.main.bounds.width,height: 50))
        self.pageControl.numberOfPages = orderedViewControllers.count
        self.pageControl.currentPage = 0
        self.pageControl.tintColor = UIColor.red
        self.pageControl.pageIndicatorTintColor = UIColor.blue
        self.pageControl.currentPageIndicatorTintColor = UIColor.red
        self.view.addSubview(pageControl)
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, didFinishAnimating finished: Bool, previousViewControllers: [UIViewController], transitionCompleted completed: Bool) {
        let pageContentViewController = pageViewController.viewControllers![0]
        self.pageControl.currentPage = orderedViewControllers.index(of: pageContentViewController as! ChartsViewController)!
    }

}

