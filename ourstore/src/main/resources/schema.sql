DROP TABLE IF EXISTS Admin CASCADE;
DROP TABLE IF EXISTS Inventory CASCADE;
DROP TABLE IF EXISTS Promotion CASCADE;
DROP TABLE IF EXISTS Income CASCADE;
DROP TABLE IF EXISTS OrderItem CASCADE;
DROP TABLE IF EXISTS CustomerOrder CASCADE;
DROP TABLE IF EXISTS Customer CASCADE;
DROP TABLE IF EXISTS Product CASCADE;
DROP TABLE IF EXISTS Brand CASCADE;
DROP TABLE IF EXISTS Category CASCADE;

CREATE TABLE IF NOT EXISTS Customer(
	customerid SERIAL UNIQUE PRIMARY KEY,
	firstname VARCHAR(30),
	lastname VARCHAR(30),
	email VARCHAR(64) UNIQUE,
	password VARCHAR(64)
	);
	
CREATE TABLE IF NOT EXISTS CustomerOrder(
	orderid SERIAL PRIMARY KEY,
	customerid INT,
	orderdate VARCHAR(30),
	shipdate VARCHAR(30)
	);

CREATE TABLE IF NOT EXISTS Category(
	categoryid INT PRIMARY KEY,
	categoryname VARCHAR(30) UNIQUE
	);
	
CREATE TABLE IF NOT EXISTS Brand(
	brandid INT PRIMARY KEY,
	brandname VARCHAR(30) UNIQUE
	);
	
CREATE TABLE IF NOT EXISTS Product(
	productid INT PRIMARY KEY,
	productname VARCHAR(64),
	brandid INT,
	brandname VARCHAR(30),
	categoryid INT,
	categoryname VARCHAR(30),
	price DECIMAL,
	FOREIGN KEY(brandid) REFERENCES Brand(brandid),
	FOREIGN KEY(brandname) REFERENCES Brand(brandname),
	FOREIGN KEY(categoryid) REFERENCES Category(categoryid),
	FOREIGN KEY(categoryname) REFERENCES Category(categoryname)
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
	orderid SERIAL PRIMARY KEY,
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
