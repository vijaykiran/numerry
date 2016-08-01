(ns numerry.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [numerry.views.core :refer :all]))

(defroutes main-routes
  (GET "/" [] (home))
  (GET "/p/:id" [id] (plot id))
  (GET "/p/:id/data" [id] (plot-data id))
  (GET "/plots" [] (plots))
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))


