(ns clojure-exercises.core)

(defn reduce-based-some
  "Implementing some using reduce"
  [pred seq]
  (pred (reduce #(if (pred %1) %1 %2) seq)))

; Test
(def test-pred #(< % 4))
(def test-seq '(6 5 7 4 3 2 1 6))

(some test-pred test-seq)
(reduce-based-some test-pred test-seq)
(some #(and (< % 4) %) test-seq)
(reduce-based-some #(and (< % 4) %) test-seq)
