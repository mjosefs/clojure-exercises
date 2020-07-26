(ns clojure-exercises.cftbat-5-1)

(defn attr
  [attribute]
  (fn [character] ((comp attribute :attributes) character)))

(def test-character {:attributes {:intelligence 120}})

((comp :intelligence :attributes) test-character)

((attr :intelligence) test-character)
