(ns backend.core
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [backend.routes.home :refer [home-routes]]
            [backend.data.employee :as data]))

(defn init []
  (data/create-table "employees"))

(defn destroy []
  (println "backend is shutting down"))


(defroutes app-routes
  (ANY "/employee/:id" [id] (employee id))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)))


