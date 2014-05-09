(ns backend.resources
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [backend.routes.home :refer [home-routes]]))


(defresource get-employee [id]
  :available-media-types ["text/plain"
                          "application/json"]

  :exists? (fn [ctx]
              {::employee (data/get-emplyee id)})
  :handle-ok ::employee)
