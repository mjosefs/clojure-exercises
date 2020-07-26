(ns clojure-exercises.cftbat-10-2)

(def word-count (atom {}))

(defn process-quote
  "Converts the quote into a list of words"
  [full-text]
  (filter
   not-empty
   (clojure.string/split
    (first (clojure.string/split
            (clojure.string/lower-case full-text)
            #"--"))
    #"[\s,.:;?!\"]")))

(defn count-words
  "Converts a word list into a map counting the words"
  [text]
  (let [words-vec (process-quote text)
        words-set (set words-vec)]
    (zipmap
     words-set
     (map
      (fn [outer-arg]
        (count (filter
                (fn [inner-arg] (= inner-arg outer-arg))
                words-vec)))
      words-set))))

(defn quote-word-count
  [n]
  (doall (map deref
              (reduce
               (fn [into-coll unused-run-again]
                 (conj into-coll
                       (let [f (future
                                 (let [quote-text (slurp "https://www.braveclojure.com/random-quote")]
                                   (swap! word-count (partial merge-with +)
                                          (count-words quote-text))))]
                         f)))
               '()
               (range n))))
  @word-count)

(defn quote-word-count2
  "Inspired by bendyworks' solution"
  [n]
  (doall (pmap
          (fn [_]
            (let [quote-text (slurp "https://www.braveclojure.com/random-quote")]
              (swap! word-count (partial merge-with +)
                     (count-words quote-text))))
          (range n)))
  @word-count)

; Test
;(reset! word-count {})

;(println (time (sort-by val > (quote-word-count 20))))

;(reset! word-count {})

;(println (time (sort-by val > (quote-word-count2 20))))
