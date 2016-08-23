(ns numerry.core
  (:gen-class)
  (:require [ring.adapter.jetty9 :as jetty]
            [compojure.handler :refer [site]]
            [numerry.routes :refer [main-routes]]
            [numerry.websockets :refer [websockets]]))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8140"))]
    (jetty/run-jetty (site main-routes) {:port port :join? false :websockets websockets})))
      
