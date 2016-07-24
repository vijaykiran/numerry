(ns numerry.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [numerry.views :refer :all]))

(defroutes main-routes
  (GET "/" [] (home))
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))


