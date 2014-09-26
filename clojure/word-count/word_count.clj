(ns phrase
  (:require [clojure.string :as string])
  (:import org.apache.commons.lang3.StringUtils))

(defn sanitize [sentence]
  (string/replace sentence #"[^a-zA-Z\d\s]" ""))

(defn words [sentence]
  (string/split (string/lower-case (sanitize sentence)) #"\s+"))

(defn count-words [counter word]
  (assoc counter word (inc (counter word 0))))

(defn word-count [sentence]
  (reduce count-words {} (words sentence)))
