(ns clojure-exercises.core
  (:gen-class))

(defn mapset
  "Works like map but returns a set"
  [in-function in-sequence]
  (set (map in-function in-sequence)))

(mapset inc [1 1 2 2])
