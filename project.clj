(defproject simon "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:user {:dependencies [[lein-lobos "1.0.0-beta1"]]}}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [lobos "1.0.0-beta1"]
                 [korma "0.3.0-RC5"]
                 [postgresql/postgresql "9.1-901.jdbc4"]])
