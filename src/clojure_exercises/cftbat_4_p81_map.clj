(ns clojure-exercises.core)

(defn reduce-based-map
  "Implementing map using reduce"
  [f seq] ; only one argument allowed...
  (apply list
         (reduce (fn [mapped-list arg] (conj mapped-list (f arg)))
                 []
                 seq)))

; Quick comparison
(def test-seq-1 '(1 2 3 4))
(map #(* % %) test-seq-1)
(reduce-based-map #(* % %) test-seq-1)
