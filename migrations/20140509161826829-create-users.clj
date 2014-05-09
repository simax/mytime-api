;; migrations/20140509161826829-create-users.clj

(defn up []
  ["CREATE TABLE users (id serial primary key, firstname varchar(255) null, lastname varchar(255) null)"])

(defn down []
  ["drop table users"])
