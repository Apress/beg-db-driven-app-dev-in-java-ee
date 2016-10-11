USE dbsample;

DROP TABLE IF EXISTS details;
DROP TABLE IF EXISTS shoppingCarts;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS books;

CREATE TABLE locations (
  loc_id INTEGER PRIMARY KEY,
  area VARCHAR(100)
)
ENGINE = InnoDB;

CREATE TABLE customers (
  cust_id INTEGER PRIMARY KEY,
  cust_name VARCHAR(100),
  loc_id INTEGER,
  email VARCHAR(100),
  phone VARCHAR(20),
  FOREIGN KEY(loc_id) REFERENCES locations(loc_id)
)
ENGINE = InnoDB;

CREATE TABLE employees(
 empno INTEGER PRIMARY KEY,
 firstname VARCHAR(30),
 lastname VARCHAR(30) 
)
ENGINE = InnoDB;

CREATE TABLE books(
  isbn VARCHAR(20) PRIMARY KEY,
  title VARCHAR(150),
  author VARCHAR(150),
  quantity INTEGER,
  price NUMERIC(8,2)
)
ENGINE = InnoDB;

CREATE TABLE orders(
  pono INTEGER PRIMARY KEY,
  cust_id INTEGER,
  empno INTEGER,
  shipping_date DATE,
  delivery_estimate VARCHAR(20),
  FOREIGN KEY(cust_id) REFERENCES customers(cust_id),
  FOREIGN KEY(empno) REFERENCES employees(empno)
) 
ENGINE = InnoDB;

CREATE TABLE details(
  ordno INTEGER,
  book_id VARCHAR(20),
  units INTEGER,
  unit_price NUMERIC(8,2),
  PRIMARY KEY(ordno, book_id),
  FOREIGN KEY(ordno) REFERENCES orders(pono),
  FOREIGN KEY(book_id) REFERENCES books(isbn)
) ENGINE = InnoDB;

CREATE TABLE shoppingCarts(
  cart_id INTEGER,
  book_id VARCHAR(20),
  units INTEGER,
  unit_price NUMERIC(8,2),
  PRIMARY KEY(cart_id, book_id),
  FOREIGN KEY(book_id) REFERENCES books(isbn)
) ENGINE = InnoDB;

