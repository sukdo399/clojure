(ns test.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(println (nth [1 2 3] 0))

(foo "11")

(get {:jam1 "strawberry" :jam2 "blackberry"} :jam3 "not found")

(assoc {:jam1 "red" :jam2 "black"} :jam1 "orange")


(clojure.set/union #{:r :b :w} #{:w :p :y})

(+ 1 1)

'(+ 1 1)

(first '(+ 1 1))

(def developer "Alice")

developer

(let [developer "Alice in Wonderland"] developer)

(defn follow-the-rabbit [] "Off we go!")

(defn shop-for-jams [jam1 jam2]
  {:name "jam-basket"
   :jam1 jam1
   :jam2 jam2})


(shop-for-jams "dd" "tt")



(fn [] (str "Off we go" "!"))

((fn [] (str "Off we go" "!")))



(def follow-again (fn [] (str "Off we go" "!")))


(#(str "Off we go" "!" " - " %) "again")




(#(str "Off we go" "!" " - " %1 %2) "again" "?")




(ns alice.favfoods)



*ns*

(def fav-food "strawberry jam")
fav-food
alice.favfoods/fav-food


(ns rabbit.favfoods)

(def fav-food "lettuce soup")
fav-food
alice.favfoods/fav-food
rabbit.favfoods/fav-food




(require 'clojure.set)

(ns wonderland)

(require '[alice.favfoods :as af])

af/fav-food


(ns wonderland
  (:require [alice.favfoods :as af]))

af/fav-food






(ns wonderland
  (:require [clojure.set :as s]))                           ;

(defn common-fav-foods [foods1 foods2]
  (let [food-set1 (set foods1)                              ;
        food-set2 (set foods2)
        common-foods (s/intersection food-set1 food-set2)]  ;
    (str "Common Foods: " common-foods)))

(common-fav-foods [:jam :toast :egg] [:test :jam :test2])













(class common-fav-foods)

(class true)


(true? true)
(false? true)


(nil? nil)

(not true)
(not nil)

(not "hi")
(not '("dd", "kk"))





(= :drinkme :drinkme)

(not= :drinkme :drinkme)


(empty? [:table :door :key])

(empty? ())
(empty? '())


(seq [1 2 3])
(class [1 2 3])
(class (seq [1 2 3]))
(seq [])

(first [1 2 3])

(empty? [])

(seq [])

(every? odd? [1 2 3])
(every? odd? [1 3 5])

(every? odd? [])


(defn drinkable? [x]
  (= x :drinkeme))

(every? drinkable? [:drinkme :poison])

(not-any? #(= % :drinkeme) [:poison :posion2])

(some #(> % 3) [1 2 3 ])

(some #(> % 3) [1 2 3 4 5])

(#{1 2 3 4 5} 3)

(#{3 4 5} 3)

(some #{3} [3 4 5])

(some #{nil} [false true])

(some #{false} [true true])

(if true "it is true" "it is false")
(if false "it is true" "it is false")


(if nil "it is true" "it is false")

(if (= :drinkme :drinkeme) "Try it" "Don't try it")

(let [need-to-grow-small (> 5 3)]
  (if need-to-grow-small
    "drink bottle"
    "don't drink bottle"
    ))

(if-let [need-to-grow-small (> 5 334)]
  "drink bottle"
  "don't drink bottle"
  )


(defn drink [need-to-grow-small]
  (when need-to-grow-small "drink bottle"))


(drink true)
(drink false)
(drink nil)

(when-let [need-to-grow-small true] "drink bottle")


(let [bottle "drinkme2"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "empty") "all gone"
    (= bottle "drinkme") "grow smaller"
    :else "unknown"
    )
  )


(let [bottle "drinkme2"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "empty") "all gone"
    (= bottle "drinkme") "grow smaller"
    "kkk" "unknown"
    )
  )

(let [bottle "drinkme2"]
  (case bottle
    "poison" "don't touch"
    "empty" "all gone"
    "drinkme" "grow smaller"
    )
  )

(let [bottle "drinkme2"]
  (case bottle
    "poison" "don't touch"
    "empty" "all gone"
    "drinkme" "grow smaller"
    "default"
    )
  )

(defn grow [name direction]
  (if (= direction :small)
    (str name " is growing smaller")
    (str name " is growing bigger")))


(grow "Alice" :small)

(partial grow "Alice")

((partial grow "Alice") :big)


(defn toggle-grow [direction]
  (if (= direction :small) :big :small))

(toggle-grow :big)


(defn oh-my [direction]
  (str "Oh My! You are growing " direction))

(oh-my (toggle-grow :small))

(defn surprise [direction]
  ((comp oh-my toggle-grow) direction))

(class surprise)


(let [[color size] ["blue" "small"]]
  (str "The " color " door is " size))

(let [x ["blue" "small"]
      color (first x)
      size (last x)]
  (str "The " color " door is " size))

(let [[color [size]] ["blue" ["small"]]]
  (str "The " color " door is " size))

(let [[color [size] :as original] ["blue" ["small"]]]
  {:color color :size size :original original})

(let [{flower1 :flower1 flower2 :flower2 or {flower2 "missing"}} {:flower1 "red"}]
  (str "The flowers are " flower1 " and " flower2))


(let [{:keys [flower1 flower2]}
      {:flower1 "red" :flower2 "blue"}]
  (str "The flowers are " flower1 " and " flower2))

(defn flower-colors [colors]
  (str "The flowers are "
       (:flower1 colors)
       " and "
       (:flower2 colors)))

(flower-colors {:flower1 "red" :flower2 "blue"})

(defn flower-colors [{:keys [flower1 flower2]}]
  (str "The flowers are " flower1 " and " flower2))

(flower-colors {:flower1 "red" :flower2 "blue"})


(take 4 (range))

(class (range))
(class (range 3))




(repeat 3 "rabbit")



(take 4 (repeat 10 "rabbit"))


(repeat 5 (rand-int 10))

(repeatedly 5 #(rand-int 10))

(take 5 (repeatedly #(rand-int 10)))



(take 10 (cycle ["big" "small"]))


(take 3 (rest (cycle ["big" "small"])))





(def adjs ["normal"
           "too small"
           "too big"
           "is swimming"])

(defn alice-is [in out]
  (if (empty? in)                                           ;
    out                                                     ;
    (alice-is                                               ;
      (rest in)                                             ;
      (conj out                                             ;
            (str "Alice is " (first in))
            )
      )
    ))

(alice-is adjs [])



(defn alice-is [input]
  (loop [in input                                           ;
         out []]
    (if (empty? in)
      out
      (recur (rest in)                                      ;
             (conj out (str "Alice is " (first in)))
             ))))

(alice-is adjs)



(defn countdown [n]
  (if (= n 0)
    n (countdown (- n 1))))

(countdown 3)


(countdown 9999)


(defn countdown [n]
  (if (= n 0)
    n
    (recur (- n 1))))

(countdown 9999)



(def animals [:mouse :duck :dodo :lory :eaglet])

(#(str %) :mouse)


(map #(str %) animals)

(class (map #(str %) animals))

(take 10 (map #(str %) (range)))


(println "Look at the mouse!")


(def animal-print (map #(println %) animals))


animal-print

(def animal-print (doall (map #(println %) animals)))

(def colors ["brown" "black" "blue" "pink" "gold"])
;(def gen-animal-string [animal color] (str color "-" animal))
;(map gen-animal-string animals colors)




(reduce + [1 2 3 4 5])

(reduce (fn [r x] (+ r (* x x))) [1 2 3])

(reduce (fn [r x] (if (nil? x) r (conj r x))) [] [:mouse nil :duck nil nil :lory])


((complement nil?) nil)
((complement nil?) 1)

(filter (complement nil?) [:mouse nil :duck nil])

(filter keyword? [:mouse nil :dock nil])



(remove nil? [:mouse nil :dock nil])


(for [animal [:mouse :duck :lory]] (str (name animal)))

(for [animal [:mouse :duck :lory]
      color [:red :blue]]
  (str (name color) "+" (name animal)))


(for [animal [:mouse :duck :lory]
      color [:red :blue]
      :let [animal-str (str "animal-" (name animal))
            color-str (str "color-" (name color))
            display-str (str animal-str "-" color-str)]]
  display-str)

(for [animal [:mouse :duck :lory]
      color [:red :blue]
      :let [animal-str (str "animal-" (name animal))
            color-str (str "color-" (name color))
            display-str (str animal-str "-" color-str)]
      :when (= color :blue)]
  display-str)

(flatten [[:duck [:mouse] [[:lory]]]])

(vec '(1 2 3))



(into [] '(1 2 3))

(+ 1 2)

(sorted-map :b 2 :a 1 :z 3)
(into (sorted-map) {:b 2 :c 3 :a 1})

(into {} [[:a 1] [:b 1] [:c 3]])


(into [] {:a 1 :b 2 :c 3})

(partition 3 [1 2 3 4 5 6 7 8 9 10])
(partition-all 3 [1 2 3 4 5 6 7 8 9 10])

(partition-by #(= 6 %) [1 2 3 4 5 6 7 8 9 10])





(def who-atom (atom :caterpillar))
who-atom
@who-atom

(reset! who-atom :chrysalis)
@who-atom

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(swap! who-atom change)

(def counter (atom 0))

(dotimes [_ 5] (swap! counter inc))


(let [n 5]
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc))))

(defn inc-print [val]
  (println val)
  (inc val))

(swap! counter inc-print)


(let [n 5]
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print))))




(def alice-height (ref 3))
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (when (pos? @right-hand-bites)
    (alter right-hand-bites dec)
    (alter alice-height #(+ % 24))))


;(eat-from-right-hand)

(dosync (eat-from-right-hand))

@alice-height
@right-hand-bites



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def alice-height (ref 3))
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (dosync (when (pos? @right-hand-bites)
            (alter right-hand-bites dec)
            (alter alice-height #(+ % 24)))))

(let [n 2]
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand))))

@alice-height
@right-hand-bites
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;





;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def alice-height (ref 3))
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (dosync (when (pos? @right-hand-bites)
            (commute right-hand-bites dec)
            (commute alice-height #(+ % 24)))))

(let [n 2]
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand))))

@alice-height
@right-hand-bites
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def x (ref 1))
(def y (ref 1))

(defn new-values []
  (dosync
    (alter x inc)
    (ref-set y (+ 2 @x))))

(let [n 2]
  (future (dotimes [_ n] (new-values)))
  (future (dotimes [_ n] (new-values))))

@x
@y
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;





;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def who-agent (agent :caterpillar))

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(send who-agent change)

@who-agent
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def who-agent (agent :caterpillar))

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(defn change-error [state]
  (throw (Exception, "Boom!")))

(send who-agent change-error)

@who-agent

(send-off who-agent change)

(agent-errors who-agent)

(restart-agent who-agent :caterpillar)
(send who-agent change)
@who-agent

(set-error-mode! who-agent :continue)
(defn err-handler-fn [a ex]
  (println "error " ex " value is " @a))
(set-error-handler! who-agent err-handler-fn)


(def who-agent (agent :caterpillar))


(send who-agent change-error)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(class "caterpillar")

(. "caterpillar" toUpperCase)
(.toUpperCase "caterpillar")

(.indexOf "caterpillar" "pillar")

(new String "Hi!!")
(String. "Hi!!")


(ns caterpillar.network
  (:import (java.net InetAddress)
           (caterpillar.network BigMushroom Edible)))
(InetAddress/getByName "localhost")
(.getHostName (InetAddress/getByName "localhost"))

(java.net.InetAddress/getByName "localhost")


(def sb (doto (StringBuffer. "Who ")
          (.append "are ")
          (.append "you?")))

(.toString sb)

(import 'java.util.UUID)
(UUID/randomUUID)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defmulti who-are-you class)
(defmethod who-are-you java.lang.String [input]
  (str "String - who are you? " input))
(defmethod who-are-you clojure.lang.Keyword [input]
  (str "Keyword - who are you? " input))
(defmethod who-are-you java.lang.Long [input]
  (str "Number - who are you? " input))
(defmethod who-are-you :default [input]
  (str "I don't know - who are you? " input))

(who-are-you :alice)
(who-are-you "Alice")
(who-are-you 123)
(who-are-you true)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defmulti eat-mushroom (fn [height]
                         (if (< height 3)
                           :grow
                           :shrink)))

(defmethod eat-mushroom :grow [_]
  "Eat the right side to grow.")
(defmethod eat-mushroom :shrink [_]
  "Eat the left side to shrink.")


(eat-mushroom 1)
(eat-mushroom 9)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defprotocol BigMushroom
  (eat-mushroom [this]))
(extend-protocol BigMushroom
  java.lang.String
  (eat-mushroom [this]
    (str (.toUpperCase this) " mmm tasty!"))
  clojure.lang.Keyword
  (eat-mushroom [this]
    (case this
      :grow "Eat the right side!"
      :shrink "Eat the left side!"))
  java.lang.Long
  (eat-mushroom [this]
    (if (< this 3)
           "Eat the right side to grow"
           "Eat the left side to shrink")))
(eat-mushroom "Big Mushroom")
(eat-mushroom :grow)
(eat-mushroom 1)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defrecord Mushroom [color height])
(def regular-mushroom (Mushroom. "white and blue polka dots" "2 inches"))
(class regular-mushroom)

(.-color regular-mushroom)
(.-height regular-mushroom)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))

(defrecord Wonderlandmushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bite makes you grow bigger"))
  (bite-left-side [this]
    (str "The " color " bite makes you grow smaller")))


(defrecord RegularMushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bite tastes bad"))
  (bite-left-side [this]
    (str "The " color " bite tastes bad too")))

(def alice-mushroom (Wonderlandmushroom. "blue dots" "3 inches"))
(def reg-mushroom (RegularMushroom. "brown" "1 inches"))

(bite-right-side alice-mushroom)
(bite-left-side alice-mushroom)

(bite-right-side reg-mushroom)
(bite-left-side reg-mushroom)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))

(deftype WonderlandMushroom []
  Edible
  (bite-right-side [this]
    (str "The bite makes you grow bigger"))
  (bite-left-side [this]
    (str "The bite makes you grow smaller")))

(deftype RegularMushroom []
  Edible
  (bite-right-side [this]
    (str "The bite tastes bad"))
  (bite-left-side [this]
    (str "The bite tastes bad too")))


(def alice-mushroom (WonderlandMushroom.))
(def reg-mushroom (RegularMushroom.))

(bite-right-side alice-mushroom)
(bite-right-side reg-mushroom)



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn bite-right-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow bigger"
    "The bite tastes bad"))
(defn bite-left-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow smaller"
    "The bite tastes bad too"))

(bite-right-side {:type "wonderland"})
(bite-left-side {:type "wonderland"})

(bite-right-side {:type "regular"})
(bite-left-side {:type "regular"})

















































































