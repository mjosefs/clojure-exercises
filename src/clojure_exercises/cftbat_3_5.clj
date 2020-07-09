(ns clojure-exercises.cftbat-3-5
  (:gen-class))

(defn alien-add-parts
  "Works like symmetrize-body-parts but for stranger bodies (assuming the 'asymmetric parts' are still 'left' parts)"
  [part]
  (map (fn [part-orientation] {:name (clojure.string/replace (:name part) #"^left-" part-orientation)
                               :size (:size part)}) ["right-" "vertical-" "polar-" "azimuthal-"]))

(defn symmetrize-body-parts
  "Expands an abbreviated, asymmetrical sequence of body parts to contain all actual body parts"
  [asymmetric-body-parts]
  (reduce (fn [final-parts part]
            (into final-parts
                  (set (into [part] (alien-add-parts part))))) ; Using into as otherwise a vector of a map and list
          []
          asymmetric-body-parts))

; Just some body parts
(def asymmetric-body-parts
  [{:name "left-hand" :size 1}
   {:name "head" :size 3}
   {:name "left-leg" :size 4}])

(symmetrize-body-parts asymmetric-body-parts)
