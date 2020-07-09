(ns clojure-exercises.cftbat-3-3
  (:gen-class))

(defn dec-maker
  "Returns function that subtracts the specified number"
  [subtr]
  (fn [number] (- number subtr)))

(def dec9 (dec-maker 9))
(dec9 10)
