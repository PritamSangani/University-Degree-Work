;; Portfolio - Implement set of functions to list the prime numbers within a certain range
;; a) fn get-divisors [n], where n is a number. Returns all numbers between 2 and (root n) inclusive
;; b) fn divides? [x n], where x is a divisor and n is a number. Returns true if x divides n, false otherwise.
;; c) fn no-divisors? [n]. Returns true if none of the numbers between 2 and (root n) divide n, false otherwise.
;; d) fn is-prime? [n]. Returns true if n is prime, false otherwise.
;; e) fn prime-seq [from to]. Returns all prime numbers between from and to inclusive.
;; f) fn print-top-primes [from to]. Displays 10 largest primes in range from and to, then display the sum

(defn get-divisors [n]
	(def end (Math/round (inc (Math/sqrt n))))
	(range 2 end)
)

(defn divides? [x n]
	(true?
	(= (mod n x) 0)
	)
)

(defn no-divisors? [n]
	(def divisors (get-divisors n))
	(not-any? 
		#((fn [x] (divides? x n)) %) divisors
	)
)

(defn is-prime? [n]
	(if (= n 2)
		true
		(if (= n 1)
			false
			(no-divisors? n)
		)
	)
)

(defn prime-seq [from to]
	(def end (inc to))
	(def seq (range from end))
	(filter 
	#((fn [n] (is-prime? n)) %)
	seq
	)
)

(defn reverse-compare [a b]
	(compare b a)
)

(defn print-top-primes [from to]
	(def seq (take 10 (sort reverse-compare (prime-seq from to))))
	(doseq [x seq] (println x))
	(println "Total = " (apply + seq))
)

(print-top-primes 50 100)