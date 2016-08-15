(ns numerry.database
  (:require [rethinkdb.query :as r]
            [environ.core :refer [env]]
            [clojure.core.async :as a
             :refer [>! <! >!! <!! go chan buffer close! thread
                     alts! alts!! timeout]]))

(def url
  (if-let [url (env :numerry-database-url)]
    url
    "127.0.0.1"))

(def port
  (if-let [port (env :numerry-database-port)]
    (read-string port)
    28015))

(defn connect-to [db-name]
  (r/connect :host url :port port :db db-name :async? false))

(defn plots [db]
  "List the available plots."
  (with-open [conn (connect-to db)]
    (-> (r/table "plots")
        (r/run conn))))

