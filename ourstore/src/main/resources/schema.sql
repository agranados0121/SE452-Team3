DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS Inventory;
DROP TABLE IF EXISTS Promotion;
DROP TABLE IF EXISTS Income;
DROP TABLE IF EXISTS OrderItem;
DROP TABLE IF EXISTS CustomerOrder;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Brand;
DROP TABLE IF EXISTS Category;

CREATE TABLE IF NOT EXISTS Customer(
	customerid INT UNIQUE PRIMARY KEY,
	firstname VARCHAR(30),
	lastname VARCHAR(30),
	email VARCHAR(64) UNIQUE,
	password VARCHAR(64)
	);
	
CREATE TABLE IF NOT EXISTS CustomerOrder(
	orderid INT PRIMARY KEY,
	customerid INT,
	orderdate DATE,
	shipdate DATE,
	FOREIGN KEY(customerid) references Customer(customerid)
	);

CREATE TABLE IF NOT EXISTS Category(
	categoryid INT PRIMARY KEY,
	categoryname VARCHAR(30)
	);
	
CREATE TABLE IF NOT EXISTS Brand(
	brandid INT PRIMARY KEY,
	brandname VARCHAR(30)
	);
	
CREATE TABLE IF NOT EXISTS Product(
	productid INT PRIMARY KEY,
	productname VARCHAR(64),
	brandid INT,
	categoryid INT,
	price DECIMAL,
	FOREIGN KEY(brandid) REFERENCES Brand(brandid),
	FOREIGN KEY(categoryid) REFERENCES Category(categoryid)
	);
	
CREATE TABLE IF NOT EXISTS Inventory(
	productid INT,
	quantity INT,
	FOREIGN KEY(productId) REFERENCES Product(productid)
	);
	
CREATE TABLE IF NOT EXISTS Promotion(
	promotionid INT PRIMARY KEY,
	productid INT,
	active BOOLEAN,
	discount float,
	description VARCHAR(100),
	FOREIGN KEY(productid) REFERENCES Product(productid)
	);
	
CREATE TABLE IF NOT EXISTS Income(
	productid INT,
	price float,
	FOREIGN KEY(productid) REFERENCES Product(productid)
	);
	
CREATE TABLE IF NOT EXISTS OrderItem(
	orderid INT PRIMARY KEY,
	productid INT,
	quantity INT,
	price FLOAT,
	FOREIGN KEY(productid) REFERENCES Product(productid),
	FOREIGN KEY(orderid) REFERENCES CustomerOrder(orderid)
	);
	
CREATE TABLE IF NOT EXISTS Admin(
	adminid INT PRIMARY KEY,
	email VARCHAR(64) UNIQUE,
	password VARCHAR(64)
);
