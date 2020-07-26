(ns clojure-exercises.cftbat-13-3)

(defprotocol Testprotocol
  "Just does random stuff"
  (testfn1 [x])
  (testfn2 [x y]))

(extend-type java.lang.String
  Testprotocol
  (testfn1 [x] (str "This just adds this text to your input: " x))
  (testfn2 [x y] (str "Apart from " x " you entered " y)))

(extend-protocol Testprotocol
  java.lang.Long
  (testfn1 [x] (str "Adding 1 to it: " (inc x)))
  (testfn2 [x y] (str  "Just addition: " (+ x y))))

; Test

;(println (testfn1 "hej") "\n" (testfn2 "hej" [1 2 3]) "\n" (testfn1 2) "\n" (testfn2 2 3))
