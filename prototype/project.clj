(defproject prototype "0.1.0-SNAPSHOT"
  :description "Numerry's prototype"
  :url "https://github.com/numerry/prototype"
  :license {:name "Apache License 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot prototype.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
