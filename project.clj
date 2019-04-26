;; * HOW TO BUILD THIS PROJECT FROM TEMPLATE?
;; lein new duct my-duct-first-step +site +example +sqlite +cljs
;; cd my-duct-first-step
;; lein deps :tree
;; lein duct setup
;; * HOW TO RUN THIS PROJECT USING EMACS?
;; open this file as emacs
;; M-x cider-jack-in
;; ;; go to cider-repl
;; user=> (dev)
;; dev=> (go)
;; ;; if you update anything, please do the command, (reset)
(defproject my-duct-first-step "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [duct/core "0.7.0"]
                 [duct/module.cljs "0.4.1"]
                 [duct/module.logging "0.4.0"]
                 [duct/module.sql "0.5.0"]
                 [duct/module.web "0.7.0"]
                 [org.xerial/sqlite-jdbc "3.27.2"]]
  :plugins [[duct/lein-duct "0.12.0"]]
  :main ^:skip-aot my-duct-first-step.main
  :resource-paths ["resources" "target/resources"]
  :prep-tasks     ["javac" "compile" ["run" ":duct/compiler"]]
  :middleware     [lein-duct.plugin/middleware]
  :profiles
  {:dev  [:project/dev :profiles/dev]
   :repl {:prep-tasks   ^:replace ["javac" "compile"]
          :dependencies [[cider/piggieback "0.4.0"]]
          :repl-options {:init-ns user
                         :nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}
   :uberjar {:aot :all}
   :profiles/dev {}
   :project/dev  {:source-paths   ["dev/src"]
                  :resource-paths ["dev/resources"]
                  :dependencies   [[integrant/repl "0.3.1"]
                                   [eftest "0.5.7"]
                                   [kerodon "0.9.0"]]}})
