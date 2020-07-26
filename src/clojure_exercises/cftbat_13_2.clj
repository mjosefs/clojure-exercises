(ns clojure-exercises.cftbat-13-2)

; From book

(defprotocol WereCreature
  (full-moon-behavior [x]))

; Exercise

(defrecord WereSimmons [name other-info]
  WereCreature
  (full-moon-behavior [x] (str (:name x) " dances etc.")))

; Test

;(def test-person (WereSimmons. "Test-person Again" [1 2 3]))

;(println (full-moon-behavior test-person))
