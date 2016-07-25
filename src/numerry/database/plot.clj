(ns numerry.database.plot
  (:require [rethinkdb.query :as r]
            [numerry.database.core :as db]))

(defn save [doc]
  "Persist to database."
  (-> (r/table "plots")
      (r/insert doc)
      (r/run db/conn)))

(defn plots []
  "List the available plots."
  (-> (r/table "plots")
      (r/run db/conn)))

(defn data [plot-id]
  "Extract the data from a specific plot."
  (db/field "plots" plot-id :data))

