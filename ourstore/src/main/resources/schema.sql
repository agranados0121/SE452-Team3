DROP TABLE IF EXISTS Admins;
DROP TABLE IF EXISTS Inventory;
DROP TABLE IF EXISTS Promotion;
DROP TABLE IF EXISTS Income;
DROP TABLE IF EXISTS Order_items;

DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Brands;
DROP TABLE IF EXISTS Categories;

CREATE TABLE IF NOT EXISTS Customer(
	id INT UNIQUE PRIMARY KEY,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	email VARCHAR(64) UNIQUE,
	passwords VARCHAR(64)
	);
	
CREATE TABLE IF NOT EXISTS Orders(
	order_id INT PRIMARY KEY,
	user_id INT,
	order_date DATE,
	order_status VARCHAR(30),
	shipped_date DATE,
	FOREIGN KEY(user_id) references Customer(id)
	);

CREATE TABLE IF NOT EXISTS Categories(
	category_id INT PRIMARY KEY,
	category_name VARCHAR(30)
	);
	
CREATE TABLE IF NOT EXISTS Brands(
	brand_id INT PRIMARY KEY,
	brand_name VARCHAR(30)
	);
	
CREATE TABLE IF NOT EXISTS Products(
	product_id INT PRIMARY KEY,
	product_name VARCHAR(64),
	brand_id INT,
	category_id INT,
	price DECIMAL,
	FOREIGN KEY(brand_id) REFERENCES Brands(brand_id),
	FOREIGN KEY(category_id) REFERENCES Categories(category_id)
	);
	
CREATE TABLE IF NOT EXISTS Inventory(
	product_id INT,
	amt INT,
	FOREIGN KEY(product_id) REFERENCES Products(product_id)
	);
	
CREATE TABLE IF NOT EXISTS Promotion(
	promotion_id INT PRIMARY KEY,
	product_id INT,
	active BOOLEAN,
	percent float,
	FOREIGN KEY(product_id) REFERENCES Products(product_id)
	);
	
CREATE TABLE IF NOT EXISTS Income(
	product_id INT,
	price float,
	FOREIGN KEY(product_id) REFERENCES Products(product_id)
	);
	
CREATE TABLE IF NOT EXISTS Order_items(
	order_id INT PRIMARY KEY,
	product_id INT,
	amt INT,
	price FLOAT,
	FOREIGN KEY(product_id) REFERENCES Products(product_id),
	FOREIGN KEY(order_id) REFERENCES Orders(order_id)
	);
	
CREATE TABLE IF NOT EXISTS Admins(
	admin_id INT PRIMARY KEY,
	email VARCHAR(64) UNIQUE,
	passwords VARCHAR(64)
);
