(ns numerry.websockets
  (:require [immutant.web.async :as async]
            [clojure.string :as str]
            [cheshire.core :refer :all]
            [numerry.database :as db]))

(defn on-message [ch pathname]
  (let [id (last (str/split (:uri (parse-string pathname true)) #"/"))
        json (generate-string (:data (db/plot db/numerry id)))]
    (async/send! ch json)))

(def websockets
  {:on-message (fn [ch msg]
                 (on-message ch msg))})
