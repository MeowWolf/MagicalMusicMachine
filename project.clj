(defproject magical-music-machine "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/data.json "2.4.0"]
                 [lein-cloverage "1.2.2"]
                 [overtone/osc-clj "0.9.0"]
                 [org.clojure/core.async "1.3.618"]
                 [org.clojure/clojure "1.10.1"]]
  :plugins [[lein-cloverage "1.2.2"]]
  :main ^:skip-aot mmm.core
  :target-path "target/%s"
  :aliases {:dev {:extra-paths ["test"]}}
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
