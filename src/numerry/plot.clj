;; Convert data into SVG
(ns numerry.plot)

(defn point? [data]
  (and (contains? data :x) (contains? data :y)))

(defn points? [data]
  (map point? data))

(def defaults
  {:r 3 :fill "black" :stroke "black" :stroke-width 1})

(def xmlns  ;; skip viewBox for now
  {:xmlns "http://www.w3.org/2000/svg" :version "1.1"})

(defn to-circle [data]
  [:circle (merge {:cx (:x data) :cy (:y data)} defaults)])

(defn circle [data]
  [:svg xmlns (to-circle data)])
  
(defn circles [data]
  [:svg xmlns (map to-circle data)])

;; ;; dispatch it
(defn plot [data]
  (if (point? data)
    (circle data)
    (if (points? data)
      (circles data)
      [:svg xmlns])))

