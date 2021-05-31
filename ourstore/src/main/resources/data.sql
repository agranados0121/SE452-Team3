INSERT Into Admin(adminid, email, password) VALUES
(0, 'firewall@four.com', 'secret');

INSERT Into Brand(brandid, brandname) VALUES
(1, 'Guchi'),
(2, 'Nice'),
(3, 'Luis V'),
(4, 'Sonie'),
(5, 'Pear'),
(6, 'GL');

INSERT INTO Customer(customerid, firstname, lastname, email, password) VALUES
(1, 'John', 'Smith' , 'jsmith@gmail.com', '1234'),
(2, 'Jane', 'Doe', 'jdoe123@gmail.com', 'password');

INSERT Into Category(categoryid, categoryname) VALUES
(1, 'Shoes'),
(2, 'Shirts'),
(3, 'Electronics');

INSERT INTO Product(productid, brandid, categoryid, price, productname) VALUES
(1,1,1,80.00,'Black'),
(2,1,1,55.00,'Strip'),
(3,1,1,60.00,'Neon'),
(4,1,2,80,'Pink'),
(5,1,2,80,'Pride'),
(6,1,2,80,'Zebra'),
(7,2,1,75,'Running'),
(8,2,1,75,'Casual'),
(9,2,2,75,'Athletic'),
(10,2,2,75,'Loose'),
(11,3,2,250,'Basic'),
(12,3,2,500,'Weird'),
(13,4,3,500,'PS6'),
(14,4,3,100,'Controler'),
(15,4,3,80,'Membership'),
(16,5,3,500,'Phone'),
(17,5,3,200,'Watch'),
(18,6,3,900,'Washing Machine'),
(19,6,3,900,'Dryer'),
(20,6,3,1000,'Fridge');

INSERT INTO Promotion(promotionId, productId, active, discount, description) VALUES 
(1, 1, TRUE, .9, 'Shoes Sale - 10% off!'),
(2, 3, TRUE, .8, 'Guchi Sale - 20% off!'),
(3, 5, TRUE, .9, 'Nice Shirts Sale - 50% off!');

INSERT INTO Inventory(productid, quantity) VALUES
(1, 5),
(2, 5),
(3, 5),
(4, 5),
(5, 5),
(6, 5),
(7, 5),
(8, 5),
(9, 5),
(10, 5),
(11, 5),
(12, 5),
(13, 5),
(14, 5),
(15, 5),
(16, 5),
(17, 5),
(18, 5),
(19, 5),
(20, 5);















