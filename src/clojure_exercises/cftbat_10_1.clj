(ns clojure-exercises.cftbat-10-1)

(def my-atom (atom 0))

(swap! my-atom inc)
(swap! my-atom inc)

; Test

; (println @my-atom)
