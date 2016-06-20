(defproject prototype "0.1.0-SNAPSHOT"
  :description "Numerry's engine"
  :url "http://numerry.com"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.170"]]
  :min-lein-version "2.0.0"
  :main ^:skip-aot numerry.core
  :plugins [[environ/environ.lein "0.3.1"] [lein-cljsbuild "1.1.3"]]
  :hooks [environ.leiningen.hooks leiningen.cljsbuild]
  :uberjar-name "numerry.jar"
  :target-path "target/%s"

  :profiles {:production {:env {:production true}} :uberjar {:aot :all}}
  :cljsbuild {:builds [{:source-paths ["src"]
                        :test-paths ["test"]
                        :compiler {:output-to "numerry.js"
                                   :optimizations :advanced}
                        :jar true}]}
  
  )


