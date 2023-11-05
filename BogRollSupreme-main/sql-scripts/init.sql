CREATE DATABASE IF NOT EXISTS brs;

USE brs;

CREATE TABLE IF NOT EXISTS products (
                                        sku INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                                        product_name VARCHAR(45) NOT NULL,
    description VARCHAR(140) NOT NULL,
    price DOUBLE NOT NULL,
    trained BOOLEAN NOT NULL,
    trained_price DOUBLE NOT NULL,
    product_image VARCHAR(45) NOT NULL
    );

CREATE TABLE IF NOT EXISTS users (
                                     id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                                     full_name VARCHAR(45) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    email VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(128) NOT NULL,
    salt VARCHAR(128) NOT NULL,
    administrator BOOLEAN NOT NULL
    );

CREATE TABLE IF NOT EXISTS orders (
                                      order_number INT NOT NULL UNIQUE PRIMARY KEY,
                                      sku INT NOT NULL,
                                      product_name VARCHAR(45) NOT NULL,
    price DOUBLE NOT NULL,
    user_id INT NOT NULL,
    fulfilled BOOLEAN NOT NULL,
    day_ordered VARCHAR(45) NOT NULL
    );

INSERT INTO users(id, full_name, username, email, password, salt, administrator) VALUES (1, "admin01", "admin01", "admin@bogroll.eth", "admin01", "Administratoradmin01", 1);
INSERT INTO users(id, full_name, username, email, password, salt, administrator) VALUES (2, "Bogroll", "user01", "user@bogrollsupreme.eth", "user01", "Bogrolluser01", 0);
INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (111, "ChatGPT AI Model", "AI Model based on OpenAI's extremely popular ChatGPT", 200.00, 0, 500.00, "/images/products/111.png");
INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (112, "ChatBot AI Model", "AI Model to respond to business' customers queries 24/7", 100.00, 0, 150.00, "/images/products/111.png");
INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (113, "Betting Tip AI Model", "AI Model based on OpenAI's extremely popular ChatGPT", 2000.00, 0, 5000.00, "/images/products/111.png");
INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (114, "Banknote Authentication AI Model", "AI Model based on OpenAI's extremely popular ChatGPT", 300.00, 0, 500.00, "/images/products/111.png");
INSERT INTO products(sku, product_name, description, price, trained, trained_price, product_image) VALUES (115, "Cancer Detection AI Model", "AI Model based on OpenAI's extremely popular ChatGPT", 50.00, 0, 100.00, "/images/products/111.png");

INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (101, 111, "ChatGPT AI Model", 800, 23, 0, "Monday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (102, 112, "ChatBot AI Model", 150, 13, 0, "Tuesday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (103, 111, "ChatGPT AI Model", 500, 13, 0, "Wednesday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (104, 111, "ChatGPT AI Model", 500, 13, 1, "Thursday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (105, 113, "Betting Tip AI Model", 2000, 13, 1, "Friday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (106, 115, "Cancer Detection AI Model", 50, 13, 1, "Saturday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (107, 114, "Banknote Authentication AI Model", 500, 13, 1, "Sunday");

INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (108, 111, "ChatGPT AI Model", 500, 23, 1, "Monday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (109, 111, "ChatGPT AI Model", 800, 13, 1, "Tuesday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (110, 111, "ChatGPT AI Model", 800, 13, 1, "Wednesday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (111, 111, "ChatGPT AI Model", 800, 13, 0, "Thursday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (112, 111, "ChatGPT AI Model", 800, 13, 0, "Friday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (113, 111, "ChatGPT AI Model", 800, 13, 0, "Saturday");
INSERT INTO orders(order_number, sku, product_name, price, user_id, fulfilled, day_ordered) VALUES (114, 111, "ChatGPT AI Model", 800, 13, 0, "Sunday");