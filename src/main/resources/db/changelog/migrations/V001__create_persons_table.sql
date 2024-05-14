CREATE TABLE persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    city_of_living VARCHAR(20) NOT NULL
);
