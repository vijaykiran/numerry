(ns prototype.core
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]))

;;  (:gen-class)))

;; (defn -main
;;   "I don't do a whole lot ... yet."
;;   [& args]
;;   (println "Hello, World!"))

;; (defn handler [request]
;;   {:status 200
;;    :headers {"Content-Type" "text/html"}
;;    :body "Hello World"})

(defn splash []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello world!"})

(defroutes app
  (GET "/" []
       (splash))
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 8140))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))


