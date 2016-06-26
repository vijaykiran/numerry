(defproject prototype "0.0.1-SNAPSHOT"
  :description "Numerry's engine"
  :url "http://numerry.com"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :min-lein-version "2.0.0"
  :main ^:skip-aot numerry.core
  :plugins [[environ/environ.lein "0.3.1"]]
  :uberjar-name "numerry.jar"
  :target-path "target/%s"

  :profiles {:production {:env {:production true}} :uberjar {:aot :all}}
)


