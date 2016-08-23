(ns numerry.websockets
  (:require [clojure.string :as str]
            [ring.adapter.jetty9 :as jetty]
            [cheshire.core :refer :all]
            [numerry.database :as db]))

(defn on-text [ws pathname]
  (let [id (last (str/split (:uri (parse-string pathname true)) #"/"))
        json (generate-string (:data (db/plot db/numerry id)))]
    (jetty/send! ws json)))

(defn data-handler [req]
  {:on-text (fn [ws text] (on-text ws text))})

(def websockets {"/data" data-handler})

