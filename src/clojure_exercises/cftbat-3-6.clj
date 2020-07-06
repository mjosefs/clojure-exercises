(ns clojure-exercises.core
  (:gen-class))

(defn generate-directions
  "Generate a list of no-parts - 1 variants of the body part 'directions', generically named"
  [no-parts]
  (map #(str "direction" % "-") (range 2 (+ no-parts 1))))

(defn alien-add-parts
  "Works like symmetrize-body-parts but for stranger bodies (assuming the 'asymmetric parts' are still 'left' parts)"
  [part no-parts]
  (map (fn [part-orientation] {:name (clojure.string/replace (:name part) #"^left-" part-orientation)
                               :size (:size part)}) (generate-directions no-parts)))

(defn symmetrize-body-parts
  "Expands an abbreviated, asymmetrical sequence of body parts to contain all actual body parts"
  [asymmetric-body-parts no-parts]
  (reduce (fn [final-parts part]
            (into final-parts
                  (set (into [part] (alien-add-parts part no-parts))))) ; Using into as otherwise a vector of a map and list
          []
          asymmetric-body-parts))

; Just some body parts
(def asymmetric-body-parts
  [{:name "left-hand" :size 1}
   {:name "head" :size 3}
   {:name "left-leg" :size 4}])

(symmetrize-body-parts asymmetric-body-parts 3)
