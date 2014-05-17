(ns api.data.database
  (:require [korma.db :refer :all]
            [korma.core :refer :all]))


(defdb db (postgres {:db "mytime"
                     :user "simonlomax"
                     :password "nomisxamol"}))

(defentity departments)
(defentity employees)
