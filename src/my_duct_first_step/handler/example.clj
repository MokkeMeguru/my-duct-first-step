(ns my-duct-first-step.handler.example
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [integrant.core :as ig]))


(defn example-endpoint
  ;; これは、例として作った簡単な endpoint 。
  ;; これを使うことで、localhost:3000/example にアクセスすると、Hello, World が見えるようになります。
  [options]
  (context "/example" []
           (GET "/" [] "<b>Hello, World!</b>")))

(defmethod ig/init-key :my-duct-first-step.handler/example [_ options]
  ;; この部分は元からあった endpoint
  ;; localhost:3000/example にアクセスすることで、example.html という提供されている html ファイルを表示します。
  ;; (context "/example" []
  ;;          (GET "/" []
  ;;               (io/resource "my_duct_first_step/handler/example/example.html")))
  (example-endpoint options))
