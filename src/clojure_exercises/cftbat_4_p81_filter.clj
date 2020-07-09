(ns clojure-exercises.core)

(defn reduce-based-filter
  "Implementing filter using reduce"
  [condition-f seq]
  (reduce (fn [output element] (if (condition-f element)
                                 (conj output element)
                                 output))
          []
          seq))

(def test-filter-f #(> % 3))
(def test-seq [1 2 3 4 5 6 7 8])

(filter test-filter-f test-seq)
(reduce-based-filter test-filter-f test-seq)
