(ns clojure-exercises.cftbat-8-2)

; From book

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

; Exercise

(defmacro defattrs
  [& attrs]
  (let [attrs-cpl (partition 2 attrs)]
    `(do
       ~@(map
          #(list 'def (first %) (list 'comp (second %) :attributes))
          attrs-cpl))))
; Test

(defattrs c-int :intelligence
          c-str :strength
          c-dex :dexterity)

;(println "Character: " (c-int character)
;         "\nStrength: " (c-str character)
;         "\nDexterity: " (c-dex character))
