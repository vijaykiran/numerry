(ns prototype.database
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]))

(defn conn
  []
  (nr/connect "http://localhost:7474/db/data/" "neo4j" "test"))

;; (defn create
;;   []
;;   (nn/create (conn) {:name "jon"}))


