(ns anagram
  (require [clojure.string :as str]))

(defn- anagram-for? [word candidate]
  (let [word (str/lower-case word)
        candidate (str/lower-case candidate)]
    (if (= word candidate)
      false
      (= (sort word) (sort candidate)))))

(defn anagrams-for [word candidates]
  (filter (partial anagram-for? word) candidates))
