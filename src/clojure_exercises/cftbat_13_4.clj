(ns clojure-exercises.cftbat-13-4)

(defmulti rpg (fn [x y] [(:attr1 x) (:attr2 y)]))

(defmethod rpg [:a :b]
  [x y]
  (str "This one did " (y :skill)))

(defmethod rpg [:a :c]
  [x y]
  (str "This could do " (y :skill)))

(defmethod rpg [:d :b]
  [x y]
  (str "Wow, " (y :skill)))

(defmethod rpg [:d :c]
  [x y]
  (str "This only did " (y :skill)))

;Test

;(println (rpg {:attr1 :a} {:attr2 :b :skill "Flames"}))
;(println (rpg {:attr1 :a} {:attr2 :c :skill "Flying swords"}))
;(println (rpg {:attr1 :d} {:attr2 :b :skill "Ice cannon"}))
;(println (rpg {:attr1 :d} {:attr2 :c :skill "Black hole"}))
