-- --LaundryShop_data.sql
INSERT INTO LAUNDRY_SHOP (
   
    NAME,
    ADDRESS
) VALUES (
   
    'Dhulai Baranagar Bazar',
    'Kutighat'
);

--sesrvice_data.sql
INSERT INTO SERVICESWASH (

    SERVICE_NAME,
    ICON_NAME
) VALUES (

    'WASH',
    'wash'
);

INSERT INTO SERVICESWASH (
   
    SERVICE_NAME,
    ICON_NAME
) VALUES (
  
    'WASH AND IRON',
    'washAndIron'
);

INSERT INTO SERVICESWASH (
  
    SERVICE_NAME,
    ICON_NAME
) VALUES (
   
    'DRY CLEAN',
    'dry clean'
);

-- --product_data.sql
-- -- Insert data into the PRODUCT table
-- INSERT INTO PRODUCT (
--     PRODUCT_ID,
--     PRODUCT_NAME,
--     QUANTITY,
--     PRICE,
--     ORIGINALPRICE,
--     IMAGE_PATH
-- ) VALUES (
--     1,
--     'T-Shirt',
--     50,
--     5.99,
--     7.99,
--     ''
-- ),
-- (
--     2,
--     'Jeans',
--     30,
--     19.99,
--     24.99,
--     ''
-- ),
-- (
--     3,
--     'Formal Shirt',
--     40,
--     8.99,
--     10.99,
--     ''
-- );

-- INSERT INTO WORKING_DAYS_AND_TIME(
--     WORKING_ID,
--     DAYS,
--     OPEN_TIME,
--     CLOSE_TIME,
--     SHOP_ID
-- )VALUES(
--     1,
--     'MONDAY',
--     '10:00:00',
--     '17:00:00',
--     1
-- );

INSERT INTO LAUNDRY_SHOP_SERVICES (
    SHOP_ID,
    SERVICE_ID
) VALUES (
    1,
    1
), -- Shop 1 provides service Wash
(
    1,
    2
);

-- INSERT INTO laundry_shop_service_summary (shop_id, shop_name, shop_address, services_list) 
-- SELECT 
--     ls.shop_id,
--     ls.name,
--     ls.address,
--     GROUP_CONCAT(sw.service_name ORDER BY sw.service_name) AS services_list
-- FROM 
--     laundry_shop ls
-- JOIN 
--     laundry_shop_services lss ON ls.shop_id = lss.shop_id
-- JOIN 
--     serviceswash sw ON lss.service_id = sw.service_id
-- GROUP BY 
--     ls.shop_id, ls.name, ls.address;

-- -- Shop 1 provides service Fold
-- -- Insert data into LAUNDRY_SHOP_PRODUCTS table
-- INSERT INTO LAUNDRY_SHOP_PRODUCTS (
--     SHOP_ID,
--     PRODUCT_ID
-- ) VALUES (
--     1,
--     1
-- ), -- Shop 1 provides product Detergent
-- (
--     1,
--     2
-- ), -- Shop 1 provides product Iron
-- (
--     1,
--     3
-- );

-- --- FOR OFFERS AND COUPONS
-- INSERT INTO OFFERS_AND_COUPONS (
--     OFFER_ID,
--     OFFERS,
--     COUPON_CODE,
--     PAYMENT_MODE
-- ) VALUES(
--     1,
--     'MOB150',
--     '150',
--     'MOBIQUIK'
-- ),
-- (
--     2,
--     'PAYTMUPI',
--     '100',
--     'PAYTM'
-- ),
-- (
--     3,
--     'HSBC100',
--     '205',
--     'HSBC card'
-- );

-- Insert data into services_wash (must come before laundry_shop_services)
-- INSERT INTO services_wash (service_name, icon_name) VALUES ('Washing', '');
-- INSERT INTO services_wash (service_name, icon_name) VALUES ('Dry Cleaning', '');
-- INSERT INTO services_wash (service_name, icon_name) VALUES ('Ironing', '');

-- -- Insert data into laundry_shop
-- INSERT INTO laundry_shop (name, address) VALUES ('CleanWave', '123 Clean St');
-- INSERT INTO laundry_shop (name, address) VALUES ('FreshNReady', '456 Fresh Ave');

-- -- Map services to laundry shops in laundry_shop_services
-- INSERT INTO laundry_shop_services (shop_id, service_id) VALUES (1, 1); -- CleanWave offers Washing
-- INSERT INTO laundry_shop_services (shop_id, service_id) VALUES (1, 2); -- CleanWave offers Dry Cleaning
-- INSERT INTO laundry_shop_services (shop_id, service_id) VALUES (2, 3); -- FreshNReady offers Ironing


