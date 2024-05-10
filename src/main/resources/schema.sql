CREATE TABLE CUSTOMERS (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    surname VARCHAR(100),
    age INT,
    phone_number VARCHAR(20)
);

CREATE TABLE ORDERS (
    id SERIAL PRIMARY KEY,
    date TIMESTAMP,
    customer_id INT REFERENCES CUSTOMERS(id),
    product_name VARCHAR(255),
    amount DECIMAL
);