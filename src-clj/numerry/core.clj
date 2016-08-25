(ns numerry.core
  (:gen-class)
  (:require [immutant.web :as web]
            [immutant.web.async :as async]
            [compojure.handler :refer [site]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [numerry.views :as views]
            [numerry.websockets :refer [websockets]]))

(def port
  (Integer/parseInt (get (System/getenv) "PORT" "8140")))

(defroutes main-routes
  (GET "/" [] (views/home))
  (GET "/p/:id" [id] (views/plot id))
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))

(defn ws [request]
  (async/as-channel request websockets))

(defn -main []
  (-> (web/run (site main-routes) :port port)
      (assoc :path "/data")
      (->> (web/run ws))))
