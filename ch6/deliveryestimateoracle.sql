CREATE OR REPLACE FUNCTION deliveryEstimate(location_id NUMBER) RETURN VARCHAR2 AS
 estimate VARCHAR2(20);
 location VARCHAR2(100);
BEGIN
 SELECT area INTO location FROM locations WHERE loc_id = location_id;
 estimate :=
 CASE
 WHEN location = 'US' THEN
 '2 business days'
 WHEN location = 'Canada' THEN
  '2-4 business days'
 WHEN location = 'Europe' THEN
 '4-6 business days'
 ELSE
 '8-12 business days'
 END;
 RETURN estimate;
END;
/
