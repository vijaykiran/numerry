(ns numerry.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer :all]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defn app [request]
  (response {:numerry "0.0.1"}))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8140"))]
    (run-jetty (wrap-json-response app) {:port port})))

