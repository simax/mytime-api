(ns api.resources.departments
  (:require [liberator.core :refer [resource defresource]]
            [api.data.departments :as data]))


(defresource get-departments []
  :available-media-types ["text/plain"
                          "application/json"]

  :exists? (fn [ctx]
              {::departments (data/get-all)})
  :handle-ok ::departments)
