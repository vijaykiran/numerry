(ns prototype.core
  (:gen-class)
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]))

(defn app []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello world!"})

(defroutes app
  (GET "/" []
       (app))
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 8140))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))


