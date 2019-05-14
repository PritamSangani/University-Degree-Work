;; Ex. 1a - Hello World
(println "Hello World!")

;; Ex. 1b - Display "12 squared is 144"
(str "12 squared is " (* 12 12))

;; Ex. 1c - write function called square
(defn square [number] 
	(* number number)
)
(square 4)

;; Ex. 2 - write function called fact
(defn fact [x]
	(reduce * (range 2 (inc x)))
)
(fact 6)

;; Ex. 3 - bank account
;; a) - method called predict-balance
;; b) - method called years-to-target
;; c) - method called target-years
;; d) - method called print-target

(defn predict-balance [initial interestRate years]
	(* initial (Math/pow (inc interestRate) years))
)
(predict-balance 300 0.005 10)

(defn years-to-target [initial target interestRate]
	(Math/ceil 
		(/ (- (Math/log target) (Math/log initial)) 
			(Math/log (inc interestRate))
		)
	)
)
(years-to-target 300 400 0.005)

(defn target-years [initial target interestRate]
	(range (inc (years-to-target initial target interestRate)))
)
(target-years 100 105 0.005)

(defn print-target [initial target interestRate]
	(doseq
		[year (target-years initial target interestRate)]
		(println (str "Year " year ": " (predict-balance initial interestRate year)) )
	)
)
(print-target 100 105 0.005)