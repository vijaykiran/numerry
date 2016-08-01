(ns numerry.views.plot.json
  (:require [cheshire.core :refer :all]))

(defn plot [data]
  (generate-string data))

