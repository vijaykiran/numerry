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

(defn field [table plot-id field-keyword]
  "Extract a top level field from a document."
  (field-keyword
   (-> (r/table table)
       (r/get plot-id)
       (r/pluck [field-keyword])
       (r/run conn))))


