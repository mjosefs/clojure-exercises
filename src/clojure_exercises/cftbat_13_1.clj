(ns clojure-exercises.cftbat-13-1)

; From book

(defmulti full-moon-behavior (fn [were-creature] (:were-type were-creature)))

; Exercise

(defmethod full-moon-behavior :no-were
  [were-creature]
  (str (:name were-creature) " is lost in time and space"))

; Test
;(def test-creature {:name "Test-person" :were-type :no-were})

;(full-moon-behavior test-creature)
