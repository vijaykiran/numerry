(ns numerry.core
  (:gen-class)
  (:require [ring.adapter.jetty9 :as jetty]
            [compojure.handler :refer [site]]
            [numerry.routes :refer [main-routes]]))

(defn data-handler [req]
  {:on-text (fn [ws text] (jetty/send! ws text))
   :on-connect (fn [ws] (jetty/send! ws "[{\"x\":\"40\",\"y\":\"60\"},{\"x\":\"20\",\"y\":\"60\"}]"))})

(def websockets {"/data" data-handler})

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8140"))]
    (jetty/run-jetty (site main-routes) {:port port :join? false :websockets websockets})))
      
