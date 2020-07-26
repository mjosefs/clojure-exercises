(ns clojure-exercises.cftbat-5-5)

(defn my-update-in
  [m ks f & args]
  (let [currval (get-in m ks)]
    (if (nil? currval)
      nil
      (assoc-in m ks (apply f (cons currval args))))))

(def test-characters {:test-char1 {:attributes {:intelligence 120}}})

(update-in test-characters [:test-char1 :attributes :intelligence] + 2 4 5)

(my-update-in test-characters [:test-char1 :attributes :intelligence] + 2 4 5)
