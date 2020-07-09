(ns clojure-exercises.cftbat-3-1
  (:gen-class))

(vector (str "This " "is " 1 " sentence")
        (list 2 (hash-set 1 2 2) "third element in the list")
        (:a (hash-map :a "and the last in the vector" :b 4)))
