(ns clojure-exercises.cftbat-5-3)

(defn my-assoc-in
  "Implementing assoc-in using reduce"
  [in-map [& in-ks] spec-value]
  (let [revks (reverse in-ks)
        k (first revks)
        ks (drop 1 revks)]
    (into in-map (reduce #(hash-map %2 %1)
                         (hash-map k spec-value)
                         ks))))

(defn my-assoc-in2
  "Implementing assoc-in using assoc recursively"
  [in-map [k & ks] spec-value]
  (if (empty? ks)
    (assoc in-map k spec-value)
    (assoc in-map k (my-assoc-in2 {} ks spec-value))))

(def test-characters {:test-char1 {:attributes {:intelligence 120}}})

(assoc-in test-characters [:test-char2 :attributes :intelligence] 110)

(my-assoc-in test-characters [:test-char2 :attributes :intelligence] 110)

(my-assoc-in2 test-characters [:test-char2 :attributes :intelligence] 110)
