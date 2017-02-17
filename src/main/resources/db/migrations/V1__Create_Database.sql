DROP DATABASE `demorestdev`;

CREATE DATABASE `demorestdev`;

CREATE TABLE customers(id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    phone VARCHAR(15) NOT NULL);

CREATE TABLE addresses(cust_id INT NOT NULL,
    street VARCHAR(60) NOT NULL,
    city VARCHAR(60) NOT NULL,
    state VARCHAR(20) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    PRIMARY KEY(cust_id),
    CONSTRAINT fk_cust_id FOREIGN KEY(cust_id) REFERENCES customers (id));