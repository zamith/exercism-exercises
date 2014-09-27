(ns nucleotide-count)

(def valid-nucleotides #{\A \T \G \C})
(def acceptable-nucleotides (merge valid-nucleotides \U))

(defn count [nucleotide strand]
  (if (contains? acceptable-nucleotides nucleotide)
    (clojure.core/count (filter #(= % nucleotide) (char-array strand)))
    (throw (Exception. "invalid nucleotide"))))

(defn nucleotide-counts [strand]
  (apply merge (map #(sorted-map % (count % strand)) valid-nucleotides)))
