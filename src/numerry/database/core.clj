(ns numerry.database.core
  (:require [rethinkdb.query :as r]
            [environ.core :refer [env]]))

(def url
  (if-let [url (env :numerry-database-url)]
    url
    "127.0.0.1"))

(def port
  (if-let [port (env :numerry-database-port)]
    (read-string port)
    28015))

(def conn (r/connect :host url
                     :port port
                     :db "numerry"))
                     ;; :async? true))


