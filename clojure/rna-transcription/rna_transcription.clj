(ns dna)

(defn to-rna [dna-sequence]
  (clojure.string/replace dna-sequence #"T" "U"))
