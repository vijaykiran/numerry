(ns numerry.views.plot.json
  (:require [cheshire.core :refer :all]))

(defn plot [data]
  [:div {:id "data"} (generate-string data)])

