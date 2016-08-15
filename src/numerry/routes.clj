(ns numerry.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [numerry.views :refer :all]))

(defroutes main-routes
  (GET "/" [] (home))
  (GET "/p/:id" [id] (plot id))
  (GET "/plots" [] (plots))
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))


