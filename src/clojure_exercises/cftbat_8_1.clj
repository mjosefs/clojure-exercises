(ns clojure-exercises.cftbat-8-1)

; From book

(def order-details
  {:name "Mitchard Blimmons"
   :email "mitchard.blimmonsgmail.com"})

(def order-details-validations
  {:name
   ["Please enter a name" not-empty]

   :email
   ["Please enter an email address" not-empty

    "Your email address doesn't look like an email address"
    #(or (empty? %) (re-seq #"@" %))]})

(defn error-messages-for
  "Return a seq of error messages"
  [to-validate message-validator-pairs]
  (map first (filter #(not ((second %) to-validate))
                     (partition 2 message-validator-pairs))))

(defn validate
  "Returns a map with a vector of errors for each key"
  [to-validate validations]
  (reduce (fn [errors validation]
            (let [[fieldname validation-check-groups] validation
                  value (get to-validate fieldname)
                  error-messages (error-messages-for value validation-check-groups)]
              (if (empty? error-messages)
                errors
                (assoc errors fieldname error-messages))))
          {}
          validations))

; Exercise

(defmacro when-valid
  [order validations & what-to-do]
  `(let [errors# (validate ~order ~validations)]
     (when (empty? errors#)
       ~@what-to-do)))

; Test

(def order-details-working
  {:name "Mitchard Blimmons"
   :email "mitchard.blimmons@gmail.com"})

;(when-valid order-details order-details-validations
;            (println "It's a success!")
;            (println "And here, something would have been returned")})

;(when-valid order-details-working order-details-validations
;            (println "It's a success!")
;            (println "And here, something would have been returned")})
