(ns clojure-exercises.core)

; Output from filter run
(def glitter-filter-res
  '({:name "Edward Cullen", :glitter-index 10}
    {:name "Jacob Black", :glitter-index 3}
    {:name "Carlisle Cullen", :glitter-index 6}))

(defn glitter-filter-names
  [glitter-filter-res]
  (map :name glitter-filter-res))

(glitter-filter-names glitter-filter-res)
