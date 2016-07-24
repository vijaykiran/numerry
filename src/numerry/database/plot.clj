(ns numerry.database.plot
  (:require [rethinkdb.query :as r]
            [numerry.database.core :as db]))

(defn save [doc]
  (-> (r/table "plots")
      (r/insert doc)
      (r/run db/conn)))

(defn plots []
  (-> (r/table "plots")
      (r/run db/conn)))

(defn data [plot-id]
  (-> (r/table "plots")
      (r/get plot-id)
      (r/pluck [:x :y])
      (r/run db/conn)))

