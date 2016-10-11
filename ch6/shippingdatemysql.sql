USE dbsample;

delimiter //
CREATE FUNCTION shippingDate() RETURNS DATE 
BEGIN
 DECLARE dayno INT;
 DECLARE shpdate DATE;
 SELECT WEEKDAY(NOW()) INTO dayno;
 IF dayno < 5 THEN
 SELECT CURDATE() INTO shpdate;
 ELSEIF dayno = 5 THEN
  SELECT DATE_ADD(CURDATE(), INTERVAL 2 DAY) INTO shpdate;
 ELSEIF dayno = 6 THEN
  SELECT DATE_ADD(CURDATE(), INTERVAL 1 DAY) INTO shpdate;
 END IF;
 RETURN shpdate;
END;
//
delimiter ;
