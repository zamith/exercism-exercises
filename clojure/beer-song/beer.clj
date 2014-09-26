(ns beer-song
  (require [clojure.string :as str]))

(defn- first-half-verse [number]
  (case number
    0 "No more bottles of beer on the wall, no more bottles of beer.\n"
    1 (str number " bottle of beer on the wall, " number " bottle of beer.\n")
    (str number " bottles of beer on the wall, " number " bottles of beer.\n")))

(defn- second-half-verse [number]
  (case number
    -1 "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    0 "Take it down and pass it around, no more bottles of beer on the wall.\n"
    1 "Take one down and pass it around, 1 bottle of beer on the wall.\n"
    (str "Take one down and pass it around, " number " bottles of beer on the wall.\n")))

(defn verse [number]
  (str (first-half-verse number) (second-half-verse (dec number))))

(defn sing
  ([start end] (str/join "\n" (map verse (range start (dec end) -1))))
  ([number] (sing number 0)))
