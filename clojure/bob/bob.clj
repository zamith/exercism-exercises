(ns bob
  (:require [clojure.string :as string])
  (:import org.apache.commons.lang3.StringUtils))

(defn silence? [statement]
  (StringUtils/isBlank statement))

(defn shouting? [statement]
  (and (= (string/upper-case statement) statement) (re-find #"[a-zA-Z]" statement)))

(defn question? [statement]
  (.endsWith statement "?"))

(defn understand [statement]
  (cond
    (silence? statement) :silence
    (shouting? statement) :shouting
    (question? statement) :question
    :else :default))

(defmulti response-for
  (fn[statement] (understand statement)))

(defmethod response-for :silence [params]
  "Fine. Be that way!")

(defmethod response-for :shouting [params]
  "Woah, chill out!")

(defmethod response-for :question [params]
  "Sure.")

(defmethod response-for :default [params]
  "Whatever.")
