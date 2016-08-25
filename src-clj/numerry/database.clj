(ns numerry.database
  (:require [rethinkdb.query :as r]
            [environ.core :refer [env]]
            [clojure.core.async :refer [<!!]]))

(def url
  (if-let [url (env :numerry-database-url)]
    url
    "127.0.0.1"))

(def port
  (if-let [port (env :numerry-database-port)]
    (read-string port)
    28015))

(def numerry
  "numerry")

(defn connect-to [db-name]
  (r/connect :host url :port port :db db-name :async? true))

(defn plot [db id]
  (with-open [conn (connect-to db)]
    (<!!
     (-> (r/table "plots")
         (r/get id)
         (r/run conn)))))

