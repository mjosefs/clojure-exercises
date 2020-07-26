(ns clojure-exercises.cftbat-7-2)

(defn adj-list
  "Makes negative terms appear as -1 * abs(term)"
  [[curr-item & infixmath]]
  (if (empty? infixmath)
    (list curr-item)
    (if (= curr-item '-)
      (let [neg-term (list '+ -1 '* (first infixmath))]
        (if (empty? (drop 1 infixmath))
          neg-term
          (concat
           neg-term
           (adj-list (drop 1 infixmath)))))
      (cons curr-item (adj-list infixmath)))))

(defn infix-reshape
  "Does the reshaping to Clojure-readable forms"
  [[arg operator & im-unisign]]
  (if (= (count im-unisign) 1)
    (list operator arg (first im-unisign))
    (if (contains? #{'* '/} operator)
      (let [next-arg (first im-unisign)
            op-prec-arg (list operator arg next-arg)
            rest-infixmath (drop 1 im-unisign)]
        (infix-reshape (cons op-prec-arg rest-infixmath)))
      (list '+ arg (infix-reshape im-unisign)))))

(defn infix
  "Calls the reshaping function with an adjusted list"
  [infixmath]
  (infix-reshape (adj-list infixmath)))

(def test-list1 '(1 + 3 * 4 - 5))
(def test-list2 '(1 + 2 * 3 / 4 + 5))
(def test-list3 '(1 - 2 * 3 / 4 + 5 * 6 - 7))

; Tests

; (println (str "Generated lists:\n"
;              (infix test-list1) "\n"
;              (infix test-list2) "\n"
;              (infix test-list3))

;(println (str "Diff in evaluation:\n"
;              "List 1: " (- 8 (eval (infix test-list1))) "\n"
;              "List 2: " (- 7.5 (eval (infix test-list2))) "\n"
;              "List 3: " (- 22.5 (eval (infix test-list3))))
