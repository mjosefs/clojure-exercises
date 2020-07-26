(ns clojure-exercises.cftbat-5-2)

(defn my-comp
  "Implementing comp with reduce"
  [& fs]
  (fn [& args]
    (let [fsreversed (reverse fs)]
      (reduce #(%2 %1)
              (apply (first fsreversed) args)
              (drop 1 fsreversed)))))

(defn my-comp2
  "Implementing comp with recursion"
  ([f]
   (fn [& args]
     (apply f args)))
  ([f & fs]
   (fn [& args] (f (apply (apply my-comp2 fs) args)))))

((comp inc inc *) 2 3)

((my-comp inc inc *) 2 3)

((my-comp2 inc inc *) 2 3)
