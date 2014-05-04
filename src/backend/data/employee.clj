(ns backend.data.employee
  (:require [korma.db :as db]))


(defdb db (postgres {:db "mytime"
                     :user "simonlomax"
                     :password "nomisxamol"}))

(defn create-table [table-name]
  (if (not (table-exists table-name)
    (db/execute!
     conn
     ["CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\""])
    (db/execute!
     conn
     ["CREATE TABLE IF NOT EXISTS employees
      (id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
       first-name TEXT NOT NULL,
       last-name TEXT NOT NULL,
       department_id INT32 NULL,
       date_created TIMESTAMPTZ NOT NULL DEFAULT now())"])))

(defn table-exists [table-name]
  (with-connection db
   (let [sql (str "SELECT EXISTS(SELECT * FROM information_schema.tables WHERE table_name = '" table-name "'")]
    (with-query-results rs [sql]
      (not= (empty? rs))))))

