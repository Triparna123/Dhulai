INSERT INTO LAUNDRY_SHOP (
    SHOP_ID,
    NAME,
    TIMING,
    RATINGS,
    DISTANCE,
    IMAGE_PATH,
    DESCRIPTION,
    WORKING_DAYS_AND_TIME

) VALUES (
    1,
    'Dhulai Baranagar Bazar',
    '8 AM - 6 PM',
    '4.5',
    2.5,
    '',
    'Environmentally friendly washing,Dhullai providing people\n oriented excellence service.Care of your clothes and peruse\n coexistence with development.',
    '{"Monday": "8 AM - 6 PM", "Tuesday": "8 AM - 6 PM"}'
 
);

INSERT INTO LAUNDRY_SHOP_SERVICES (SHOP_ID, SERVICE_ID)
VALUES
    (1, 1),  -- Shop 1 provides service Wash
    (1, 2);  -- Shop 1 provides service Fold

-- Insert data into LAUNDRY_SHOP_PRODUCTS table
INSERT INTO LAUNDRY_SHOP_PRODUCTS (SHOP_ID, PRODUCT_ID)
VALUES
    (1, 1),  -- Shop 1 provides product Detergent
    (1, 2),  -- Shop 1 provides product Iron
    (1, 3);