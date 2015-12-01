(defproject om-next-react-native "0.1.0-SNAPSHOT"
  :description "My first Om program!"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.omcljs/om "1.0.0-alpha22"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT" :scope "test"]]

  :plugins [[lein-cljsbuild "1.1.1"]]

  :cljsbuild {:builds [{:id "dev"
                      :source-paths ["src"]
                                     :compiler {:output-to "index.android.js"
                                                :optimizations :advanced}}]})