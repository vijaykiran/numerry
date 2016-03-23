(defproject prototype "0.1.0-SNAPSHOT"
  :description "Numerry's prototype"
  :url "http://numerry.com"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [compojure "1.4.0"]
                 [environ "1.0.0"]
                 [clj-http "2.1.0"]
                 [ring "1.4.0"]]
  :min-lein-version "2.0.0"
  :main ^:skip-aot prototype.core
  :plugins [[environ/environ.lein "0.3.1"]
            [lein-cljsbuild "1.1.3"]]
  :hooks [environ.leiningen.hooks leiningen.cljsbuild]
  :uberjar-name "prototype.jar"
  :profiles {:production {:env {:production true}} :uberjar {:aot :all}}
  :target-path "target/%s"

  :cljsbuild {:builds [{:source-paths ["src"]
                        :compiler {:output-to "resources/public/js/numerry.js"
                                   :optimizations :whitespace
                                   :pretty-print true}
                        :jar true}]}
  )


