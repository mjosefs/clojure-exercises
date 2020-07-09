(ns clojure-exercises.cftbat-4-2)

; Output from filter run
(def glitter-filter-res
  '({:name "Edward Cullen", :glitter-index 10}
    {:name "Jacob Black", :glitter-index 3}
    {:name "Carlisle Cullen", :glitter-index 6}))

(defn append
  "Adds a new suspect into the suspect list"
  [new-suspect]
  (conj glitter-filter-res new-suspect))

(def test-suspect {:name "Rando Name", :glitter-index 7})

(append test-suspect)
