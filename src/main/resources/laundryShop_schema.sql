DROP TABLE IF EXISTS LAUNDRY_SHOP;
DROP TABLE IF EXISTS LAUNDRY_SHOP_SERVICES;
DROP TABLE IF EXISTS LAUNDRY_SHOP_PRODUCTS;

CREATE TABLE LAUNDRY_SHOP (
    SHOP_ID INTEGER PRIMARY KEY,
    NAME VARCHAR(255),
    TIMING VARCHAR(255),
    RATINGS VARCHAR(255),
    DISTANCE DOUBLE,
    IMAGE_PATH VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    WORKING_DAYS_AND_TIME JSONB,

    -- Add other columns as needed
);

CREATE TABLE LAUNDRY_SHOP_SERVICES (
    SHOP_ID INTEGER REFERENCES LAUNDRY_SHOP(SHOP_ID),
    SERVICE_ID INTEGER REFERENCES SERVICESWASH(SERVICE_ID),
    PRIMARY KEY (SHOP_ID, SERVICE_ID)
);

-- Create the table for LaundryShopProducts relationship
CREATE TABLE LAUNDRY_SHOP_PRODUCTS (
    SHOP_ID INTEGER REFERENCES LAUNDRY_SHOP(SHOP_ID),
    PRODUCT_ID INTEGER REFERENCES PRODUCT(PRODUCT_ID),
    PRIMARY KEY (SHOP_ID, PRODUCT_ID)
);