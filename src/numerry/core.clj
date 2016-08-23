(ns numerry.core
  (:gen-class)
  (:require [immutant.web :as web]
            [compojure.handler :refer [site]]
            [numerry.routes :refer [main-routes]]))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8140"))]
    (web/run (site main-routes) {:port port})))
      
