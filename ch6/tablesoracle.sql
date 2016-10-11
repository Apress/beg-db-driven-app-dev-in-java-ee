DROP TABLE details;
DROP TABLE shoppingCarts;
DROP TABLE orders;
DROP TABLE customers;
DROP TABLE locations;
DROP TABLE employees;
DROP TABLE books;

CREATE TABLE locations (
  loc_id NUMBER PRIMARY KEY,
  area VARCHAR2(100)
);

CREATE TABLE customers (
  cust_id NUMBER PRIMARY KEY,
  cust_name VARCHAR2(100),
  loc_id NUMBER,
  email VARCHAR2(100),
  phone VARCHAR2(20),
  FOREIGN KEY(loc_id) REFERENCES locations(loc_id)
);

CREATE TABLE employees(
 empno NUMBER PRIMARY KEY,
 firstname VARCHAR2(30),
 lastname VARCHAR2(30) 
);

CREATE TABLE books(
  isbn VARCHAR2(20) PRIMARY KEY,
  title VARCHAR2(150),
  author VARCHAR2(150),
  quantity NUMBER,
  price NUMBER(8,2)
);

CREATE TABLE orders(
  pono NUMBER PRIMARY KEY,
  cust_id NUMBER,
  empno NUMBER,
  shipping_date DATE,
  delivery_estimate VARCHAR2(20),
  FOREIGN KEY(cust_id) REFERENCES customers(cust_id),
  FOREIGN KEY(empno) REFERENCES employees(empno)
);

CREATE TABLE details(
  ordno NUMBER,
  book_id VARCHAR2(20),
  units NUMBER,
  unit_price NUMBER(8,2),
  PRIMARY KEY(ordno, book_id),
  FOREIGN KEY(ordno) REFERENCES orders(pono),
  FOREIGN KEY(book_id) REFERENCES books(isbn)
);

CREATE TABLE shoppingCarts(
  cart_id NUMBER,
  book_id VARCHAR2(20),
  units NUMBER,
  unit_price NUMBER(8,2),
  PRIMARY KEY(cart_id, book_id),
  FOREIGN KEY(book_id) REFERENCES books(isbn)
);
