(ns clojure-exercises.cftbat-4-4)

; Output from filter run
(def glitter-filter-res
  '({:name "Edward Cullen", :glitter-index 10}
    {:name "Jacob Black", :glitter-index 3}
    {:name "Carlisle Cullen", :glitter-index 6}))

(def kwords [:name :glitter-index])

(defn map-to-csv-line
  ; Transforms a suspect record to csv line (a bit too generally...)
  [suspect]
  (let [suspect-list (map suspect kwords)]
    (str
     (reduce #(str %1 %2 ",")
             ""
             (drop-last suspect-list))
     (last suspect-list))))

(defn map->csv
  [suspect-list]
  (reduce (fn [outputcsv nextsuspect]
            (str outputcsv
                 (map-to-csv-line nextsuspect)
                 "\n"))
          ""
          suspect-list))

(map->csv glitter-filter-res)
