(ns clojure-exercises.cftbat-8-2)

(defmacro or-macro
  ([]
   nil)
  ([single-arg]
   single-arg)
  ([first & args]
   `(let [first-arg-eval# ~first]
      (if first-arg-eval#
        first-arg-eval#
        (or-macro ~@args)))))

; Test

(or (= 1 2) false "truthy string" nil)

(or-macro (= 1 2) false "truthy string" nil)
(or-macro (= 1 2) false false nil)
