(ns numerry.views
  (:require [ring.util.response :refer :all]
            [hiccup.page :refer [html5 include-js]]
            [cheshire.core :refer :all]
            [ring.util.codec :refer :all]
            [numerry.database :as db]))

(defn to-uuid [id]
  (String. (base64-decode id) "UTF-8"))

(defn from-uuid [uuid]
  (base64-encode (.getBytes uuid)))

(defn base [title & body]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:link {:rel "apple-touch-icon" :sizes "180x180" :href "/apple-touch-icon.png"}]    
    [:link {:rel "icon" :type "image/png" :href "/favicon-16x16.png" :sizes "16x16"}]
    [:link {:rel "icon" :type "image/png" :href "/favicon-32x32.png" :sizes "32x32"}]
    [:link {:rel "manifest" :href "/manifest.json"}]
    [:link {:rel="mask-icon" :href "/safari-pinned-tab.svg" :color "#5bbad5"}]
    [:meta {:name "theme-color" :content "#ffffff"}]
    (include-js "https://d3js.org/d3.v4.min.js")
    (include-js "/websockets.js")
    [:title title]]
   [:body body]))

(defn home []
  (base "Numerry" [:p "Hello world!"]))

(defn plot [id]
  (base (to-uuid id) nil))

(defn plots []
  (base "Plots" [:p "TODO: List the available plots."]))


