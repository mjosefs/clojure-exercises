(ns clojure-exercises.cftbat-10-3)

(defn val-max-hit-points
  [{:keys [hit-points]}]
  (<= hit-points 40))

(def healing-pot-strength 10)

(defn use-healing-potion
  [giving-character receiving-character]
  (dosync
   (if (> (get-in @giving-character
                  [:inventory :healing-potions])
          0)
     (do
       (alter receiving-character
              update-in [:hit-points]
              #(- % (min healing-pot-strength
                         (get-in @receiving-character [:hit-points]))))
       (alter giving-character
              update-in [:inventory :healing-potions]
              - 1))
     (println "No potion available!"))))

; Test

(def character-1 (ref {:name "Character 1"
                       :hit-points 15
                       :inventory {:healing-potions 0}}
                      :validator val-max-hit-points))

(def character-2 (ref {:name "Character 2"
                       :hit-points 5
                       :inventory {:healing-potions 2}}
                      :validator val-max-hit-points))

;(println "Before potion:")
;(println @character-1)
;(println @character-2)

(use-healing-potion character-2 character-1)

;(println "\nAfter potion:")
;(println @character-1)
;(println @character-2)

(use-healing-potion character-2 character-1)

;(println "\nAfter another potion:")
;(println @character-1)
;(println @character-2)
