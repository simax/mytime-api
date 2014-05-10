(ns api.data.departments
  (:require [cheshire.core :as json]))


(defn get-all []
   (json/encode
    [{:id 1, :name "EKM"}
     {:id 2, :name "Development"}
     {:id 3, :name "Design"}
     {:id 4, :name "Customer Support"}]))
