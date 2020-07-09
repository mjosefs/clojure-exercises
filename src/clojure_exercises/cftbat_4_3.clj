(ns clojure-exercises.cftbat-4-3
  (:require [clojure-exercises.cftbat-4-2 :as c4-2]))

(def validations
  (hash-map
   :name string?
   :glitter-index int?))

(defn validate
  "Uses c4-2/append to add suspect if validations succeed"
  [validations new-suspect]
  (and
   (every? identity (map
                     #((second %) ((first %) new-suspect))
                     validations))
   c4-2/append new-suspect))

(def test-suspect1 {:name "Rando Name", :glitter-index 7})
(def test-suspect2 {:name "Rando Name", :glitter-index "fail"})

(validate validations test-suspect1)
(validate validations test-suspect2)
