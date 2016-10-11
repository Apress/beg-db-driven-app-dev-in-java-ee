USE dbsample;

START TRANSACTION;

INSERT INTO locations VALUES(1, 'US');
INSERT INTO locations VALUES(2, 'Canada');
INSERT INTO locations VALUES(3, 'Europe');
INSERT INTO locations VALUES(4, 'Other');

INSERT INTO customers VALUES(1, 'John Poplavski', 1, 'joshp@mail.com', '(650)777-5665');
INSERT INTO customers VALUES(2, 'Paul Medica', 3, 'paulmed@mail.com', '(029)2124-5540');

INSERT INTO employees VALUES(1, 'Serg', 'Oganovich');
INSERT INTO employees VALUES(2, 'Maya', 'Silver');

INSERT INTO books VALUES('1430209631', 'Beginning GlassFish TopLink: From Novice to Professional', 'Yuli Vasiliev', 10, 44.99);
INSERT INTO books VALUES('1590595300', 'Expert Oracle Databas Architecture: 9i and 10g Programming Techniques and Solutions', 'Thomas Kyte', 10, 49.99);

COMMIT;
