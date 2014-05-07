(ns lobos.migrations
  ;; exclude some clojure built-in symbols so we can use the lobos' symbols
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  ;; use only defmigration macro from lobos
  (:use (lobos [migration :only [defmigration]]
          core
          schema config helpers)))

;;; Defines the database for lobos migrations
(def mytime
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "mytime"
   :user "simonlomax"
   :password "nomisxamol"})

(defmigration add-users-table
  ;; code be executed when migrating the schema "up" using "migrate"
  (up [] (create mytime
           (table :users (integer :id :primary-key )
             (varchar :firstname 255 :not-null )
             (varchar :lastname 255 :not-null )
             (varchar :email 255 :unique))))
  ;; Code to be executed when migrating schema "down" using "rollback"
  (down [] (drop (table :authors ))))

