(ns clojure-exercises.cftbat-3-4
  (:gen-class))

(defn mapset
  "Works like map but returns a set"
  [in-function in-sequence]
  (set (map in-function in-sequence)))

(mapset inc [1 1 2 2])
