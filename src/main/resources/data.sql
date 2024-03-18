--LaundryShop_data.sql
INSERT INTO LAUNDRY_SHOP (
    SHOP_ID,
    NAME,
    TIMING,
    RATINGS,
    DISTANCE,
    IMAGE_PATH,
    DESCRIPTION
) VALUES (
    1,
    'Dhulai Baranagar Bazar',
    '8 AM - 6 PM',
    4.5,
    2.5,
    '',
    'Environmentally friendly washing,Dhullai providing people\n oriented excellence service.Care of your clothes and peruse\n coexistence with development.'
);

--sesrvice_data.sql
INSERT INTO SERVICESWASH (
    SERVICE_ID,
    SERVICE_NAME,
    ICON_NAME
) VALUES (
    1,
    'WASH',
    'wash'
);

INSERT INTO SERVICESWASH (
    SERVICE_ID,
    SERVICE_NAME,
    ICON_NAME
) VALUES (
    2,
    'WASH AND IRON',
    'washAndIron'
);

INSERT INTO SERVICESWASH (
    SERVICE_ID,
    SERVICE_NAME,
    ICON_NAME
) VALUES (
    3,
    'DRY CLEAN',
    'dry clean'
);

--product_data.sql
-- Insert data into the PRODUCT table
INSERT INTO PRODUCT (
    PRODUCT_ID,
    PRODUCT_NAME,
    QUANTITY,
    PRICE,
    ORIGINALPRICE,
    IMAGE_PATH
) VALUES (
    1,
    'T-Shirt',
    50,
    5.99,
    7.99,
    ''
),
(
    2,
    'Jeans',
    30,
    19.99,
    24.99,
    ''
),
(
    3,
    'Formal Shirt',
    40,
    8.99,
    10.99,
    ''
);

INSERT INTO WORKING_DAYS_AND_TIME(
    WORKING_ID,
    DAYS,
    OPEN_TIME,
    CLOSE_TIME,
    SHOP_ID
)VALUES(
    1,
    'MONDAY',
    '10:00:00',
    '17:00:00',
    1
);

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

-- Shop 1 provides service Fold
-- Insert data into LAUNDRY_SHOP_PRODUCTS table
INSERT INTO LAUNDRY_SHOP_PRODUCTS (
    SHOP_ID,
    PRODUCT_ID
) VALUES (
    1,
    1
), -- Shop 1 provides product Detergent
(
    1,
    2
), -- Shop 1 provides product Iron
(
    1,
    3
);

--- FOR OFFERS AND COUPONS
INSERT INTO OFFERS_AND_COUPONS (
    OFFER_ID,
    OFFERS,
    COUPON_CODE,
    PAYMENT_MODE
) VALUES(
    1,
    'MOB150',
    '150',
    'MOBIQUIK'
),
(
    2,
    'PAYTMUPI',
    '100',
    'PAYTM'
),
(
    3,
    'HSBC100',
    '205',
    'HSBC card'
);