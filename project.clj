(defproject numerry "0.0.1-SNAPSHOT"
  :description "Numerry"
  :url "http://numerry.com"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.225"]
                 [ring "1.4.0"]
                 [org.immutant/immutant "2.1.5"]
                 [compojure "1.5.1"]
                 [environ "1.0.0"]
                 [com.apa512/rethinkdb "0.15.26"]
                 [cheshire "5.6.3"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.3.1"]
            [lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.4"]]
  :hooks [environ.leiningen.hooks leiningen.cljsbuild]
  :source-paths ["src-clj"]
  :uberjar-name "numerry.jar"
  :main ^:skip-aot numerry.core
  :target-path "target/%s"
  :ring {:handler numerry.core/-main}
  :profiles {:uberjar {:aot :all}}
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :jar true
                        :compiler {:output-to "resources/public/plot.js"
                                   ;; :foreign-libs [{:file "https://d3js.org/d3.v4.min.js"
                                   ;;                 :provides  ["d3"]}]
                                   :optimizations :whitespace
                                   :pretty-print true}}]})


