(ns numerry.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.handler :refer [site]]
            [numerry.routes :refer [main-routes]]))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8140"))]
    (run-jetty (site main-routes) {:port port :join? false})))

