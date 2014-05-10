;; migrations/20140510132453277-add-demo-data.clj

(defn up []
  ["insert into departments (name) values ('Development');"
   "insert into departments (name) values ('Design');"
   "insert into departments (name) values ('Customer Support');"

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('Antony', 'Chesworth', 'antonychesworth@ekmsystems.co.uk',
    (select id from departments where name='EKM'),
     NULL)";

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('Nick', 'Stansfield', 'nickstansfield@ekmsystems.co.uk',
    (select id from departments where name='Development'),
    (select id from employees where lastname='Chesworth'));"

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('Simon', 'Lomax', 'simonlomax@ekmsystems.co.uk',
    (select id from departments where name='Development'),
    (select id from employees where lastname='Stansfield'));"

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('Simon', 'Wriggley', 'simonwriggley@ekmsystems.co.uk',
    (select id from departments where name='Development'),
    (select id from employees where lastname='Stansfield'));"

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('Lisa', 'Young', 'lisayoung@ekmsystems.co.uk',
    (select id from departments where name='Development'),
    (select id from employees where lastname='Stansfield'));"

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('Dave', 'Sharpe', 'davesharpe@ekmsystems.co.uk',
    (select id from departments where name='Design'),
    (select id from employees where lastname='Chesworth'));"

   "insert into employees (firstname, lastname, email, departmentid, managerid)
    values ('John', 'Slater', 'johnslater@ekmsystems.co.uk',
    (select id from departments where name='Design'),
    (select id from employees where lastname='Shapre'));"

  ])

(defn down []
  [])
