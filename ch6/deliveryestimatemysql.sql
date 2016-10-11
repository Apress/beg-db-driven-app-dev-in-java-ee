USE dbsample;

delimiter //
CREATE FUNCTION deliveryEstimate(location_id INT) RETURNS VARCHAR(20) 
BEGIN
 DECLARE estimate VARCHAR(20);
 DECLARE location VARCHAR(100);
 SELECT area INTO location FROM locations WHERE loc_id = location_id;
 CASE
 WHEN location = 'US' THEN
 SET estimate = '2 business days';
 WHEN location = 'Canada' THEN
 SET estimate = '2-4 business days';
WHEN location = 'Europe' THEN
 SET estimate = '4-6 business days';
ELSE
 SET estimate = '8-12 business days';
 END CASE;
 RETURN estimate;
END;
//
delimiter ;

