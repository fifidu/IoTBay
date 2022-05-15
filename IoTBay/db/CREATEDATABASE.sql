/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fifidu
 * Created: 15/05/2022
 */

create table customer(
	customerID int NOT NULL,
	cusFName varchar(30) NOT NULL,
	cusLName varchar(30) NOT NULL,
	cusEmailAddress varchar(50) NOT NULL,
	cusPass varchar(20) NOT NULL,
	cusContactNumber varchar(10) NOT NULL,
	CONSTRAINT customer_PK PRIMARY KEY (customerID)
);

INSERT INTO customer VALUES (1, 'John', 'Smith', 'john.smith@email.com','20221234', '0401010010');
INSERT INTO customer VALUES (2, 'Samantha', 'Green', 'sam.green@email.com', 'helloSG','0483826496');
INSERT INTO customer VALUES (3, 'Long', 'Bottom', 'long.bottom@email.com', '283longbottom','0482957283');
INSERT INTO customer VALUES (4, 'Jill', 'Nill', 'jill.nill@email.com', 'nilljill1234', '0483728573');
INSERT INTO customer VALUES (5, 'Steven', 'Strange', 'steven.strange@avengers.com', 'marvel1234', '0438724104');
INSERT INTO customer VALUES (6, 'Penelope', 'Lane', 'penelope.lane@email.com','knlacb23', '0453570657');
INSERT INTO customer VALUES (7, 'Iason', 'Bothe', 'iason.bothe@email.com', '1234P4ss','0483456789');
INSERT INTO customer VALUES (8, 'Gallo', 'Kurata', 'gallo.k@email.com', 'BN.Hlz6!','0412345678');
INSERT INTO customer VALUES (9, 'Uni', 'Bros', 'me@unibros.com', 'WeLoveHSPs', '0409876543');
INSERT INTO customer VALUES (10, 'Papa', 'Riche', 'papasrich@email.com', '100k+', '0412098456');
INSERT INTO customer VALUES (11, 'Dick', 'Smith', 'dick.smith@email.com','01011101010', '0410110101');
INSERT INTO customer VALUES (12, 'Johnny', 'Green', 'jjjjohnny@email.com', 'yyyyY','0488326496');
INSERT INTO customer VALUES (13, 'Tim', 'Cha', 'chatim@email.com', '904enne','0485728113');
INSERT INTO customer VALUES (14, 'Emer', 'Zelenka', 'emze@email.com', 'LeN1234', '0483727311');
INSERT INTO customer VALUES (15, 'Georgia', 'Tierney', 'g_t@hotmail.com', '000TnL!', '0472114104');
INSERT INTO customer VALUES (16, 'Aisha', 'Islam', 'islam_aisha@email.com','0465hh', '0401444123');
INSERT INTO customer VALUES (17, 'Bob', 'Jane', 'tmart@hotmail.com', 'b0BjaNe','0457846735');
INSERT INTO customer VALUES (18, 'Long', 'Haired', 'hairy@email.com', 'I*nK475','0485728495');
INSERT INTO customer VALUES (19, 'Brendon', 'Robles', 'brobles20@email.com', 'BR?2002', '0483728333');
INSERT INTO customer VALUES (20, 'Hillary', 'Greene', 'hgreene2@gmail.com', 'g00D4u', '0486010234');

SELECT * FROM customer;

CREATE TABLE staff(
	staffID int NOT NULL,
	staffFName varchar(30) NOT NULL,
	staffLName varchar(30) NOT NULL,
	staffEmailAddress varchar(50) NOT NULL,
	staffPass varchar(20) NOT NULL,
	staffContactNumber varchar(10) NOT NULL,
	CONSTRAINT staff_PK  PRIMARY KEY (staffID)
);

INSERT INTO staff VALUES (1, 'Tracy', 'Nightingale', 't.night@darkmail.com', 'tracyiot12', '0429273951');
INSERT INTO staff VALUES (2, 'Christine', 'Wong', 'cwong15@trollmail.com', 'wongwong00', '0487295738');
INSERT INTO staff VALUES (3, 'Peter', 'Pan', 'ppan@fairymail.com', 'panpeter', '0483039233');
INSERT INTO staff VALUES (4, 'Jack', 'Sparrow', 'j.sparrow@rummail.com', 'adminsparrow90', '0484628462');
INSERT INTO staff VALUES (5, 'Steve', 'Minecraft', 'steve.m@crafty.com', 'grassblock1234', '0494748293');
INSERT INTO staff VALUES (6, 'Odell', 'Austin', 'odeataus@email.com', 'llLL11', '0465789453');
INSERT INTO staff VALUES (7, 'Dexter', 'Brewer', 'dexbrew11@trollmail.com', 'b4r1s*4', '0487511738');
INSERT INTO staff VALUES (8, 'Tinker', 'Bell', 'tbell@fairymail.com', 'b3llt*nk', '0483129233');
INSERT INTO staff VALUES (9, 'Levi', 'Sosa', 's.levi@rummail.com', '0956482a', '0461328462');
INSERT INTO staff VALUES (10, 'Louis', 'Stevens', 'stevenslouis@crafty.com', 'csg0', '0474844293');
INSERT INTO staff VALUES (11, 'Jed', 'Humphrey', 'jhump@darkmail.com', 'w3dNe2', '0427123951');
INSERT INTO staff VALUES (12, 'Lorenzo', 'Lloyd', 'triple.l@hotmail.com', 'LLL4eva', '0487297738');
INSERT INTO staff VALUES (13, 'Holly', 'Stars', 'starryskies@fairymail.com', 'h0ly', '0483939233');
INSERT INTO staff VALUES (14, 'Selina', 'Go', 'sgo@rummail.com', 'g0nnaCry', '0484628992');
INSERT INTO staff VALUES (15, 'Dina', 'Carter', 'd.carter@crafty.com', '0987pass', '0490048293');
INSERT INTO staff VALUES (16, 'Tammy', 'Colon', 'tammy_c@darkmail.com', 't4mmyrulez', '0429173951');
INSERT INTO staff VALUES (17, 'Wiley', 'Wheeler', 'ww9057@trollmail.com', 'wiley2005', '0487295066');
INSERT INTO staff VALUES (18, 'Russel', 'Walker', 'thisisrussel@fairymail.com', 'HNL0P364', '0483009233');
INSERT INTO staff VALUES (19, 'Marty', 'Floyd', 'mf.martyfloyd@rummail.com', 'mfMF**!!', '0484628401');
INSERT INTO staff VALUES (20, 'Nannie', 'Espinoza', 'nan.e@crafty.com', 'mcfee', '0494748213');

SELECT * FROM staff;

CREATE TABLE product (
    productID int NOT NULL,
    productName varchar(50),
	productType varchar(50),
    productSupplier varchar(50),
    productDescription varchar(255),
    productCost decimal(6,2),
    quantityAvailable int,
    CONSTRAINT product_PK PRIMARY KEY (productID)
);

INSERT INTO product VALUES (1, 'Mesh Modem', 'Internet', 'FEthernet', 'Fastest Mesh Modem you can get for your home!', 349.99, 5);
INSERT INTO product VALUES (2, 'USB-C Hub', 'Accessory', 'HT Tech', 'USB-C Hub for Laptop', 29.99, 6);
INSERT INTO product VALUES (3, 'iPhone 13', 'Phone', 'Apple', 'The Newest iPhone', 1299.99, 10);
INSERT INTO product VALUES (4, 'Flashlight 5W', 'Outdoor', 'Camping Supplies Co.', 'Brighter than your future', 49.99, 17);
INSERT INTO product VALUES (5, 'Computer Speakers', 'Accessory', 'Logitech', 'Computer Speakers for Home Office', 69.99, 20);
INSERT INTO product VALUES (6, 'Apple Airpods', 'Headphones', 'Apple', 'Easy Wireless Earphones for Daily Use!', 218.99, 10);
INSERT INTO product VALUES (7, 'Wireless Gaming Mouse', 'Accessory', 'Logitech', 'Bluetooth Mouse for Gaming', 129.99, 17);
INSERT INTO product VALUES (8, 'Samsung Galaxy S20 (Cloud Navy)', 'Phone', 'Samsung', 'Colourful design and pro grade performance', 799.99, 10);
INSERT INTO product VALUES (9, 'Samsung Galaxy S20 (Cloud White)', 'Phone', 'Samsung', 'Colourful design and pro grade performance', 799.99, 10);
INSERT INTO product VALUES (10, 'Samsung Galaxy S20 (Cosmic Grey)', 'Phone', 'Samsung', 'Colourful design and pro grade performance', 799.99, 10);
INSERT INTO product VALUES (11, 'Zenbook EVO', 'Laptop', 'ASUS', 'Durable laptop fit for any kind of use!', 1899.99, 7);
INSERT INTO product VALUES (12, 'Chromebook', 'Laptop', 'Lenovo', 'Laptop with detachable keyboard', 374.00, 8);
INSERT INTO product VALUES (13, 'iPhone 11', 'Phone', 'Apple', 'Do more for less', 734.99, 10);
INSERT INTO product VALUES (14, 'Smart TV 65"', 'TV', 'Samsung', 'Extraordinary colour and brightness', 1795.99, 15);
INSERT INTO product VALUES (15, 'Computer Speakers', 'Accessory', 'Logitech', 'Computer Speakers for Home Office', 69.99, 20);
INSERT INTO product VALUES (16, 'Nintendo Switch', 'Console', 'Nintendo', 'The best handheld console on the market', 449.99, 9);
INSERT INTO product VALUES (17, 'Nintendo Switch Lite', 'Console', 'Nintendo', 'A lighter version of our Switch', 329.99, 8);
INSERT INTO product VALUES (18, 'Blue Yeti USB Microphone', 'Microphone', 'Blue', 'Sound crisper than ever', 168.99, 10);
INSERT INTO product VALUES (19, 'Rode NT USB Microphone', 'Microphone', 'Rode', 'Recording singing from the comfort of your home', 199.99, 14);
INSERT INTO product VALUES (20, 'Polaroid Camera', 'Camera', 'FujiFilm', 'Capture a moment in film', 329.99, 20);

SELECT * FROM product;

CREATE TABLE cart (
	cartID int NOT NULL,
	customerID int NOT NULL,
	CONSTRAINT cart_PK PRIMARY KEY (cartID),
	CONSTRAINT cart_FK FOREIGN KEY (customerID) REFERENCES customer
);

INSERT INTO cart VALUES (1, 1);
INSERT INTO cart VALUES (2, 1);
INSERT INTO cart VALUES (3, 2);
INSERT INTO cart VALUES (4, 3);
INSERT INTO cart VALUES (5, 5);
INSERT INTO cart VALUES (6, 4);
INSERT INTO cart VALUES (7, 7);
INSERT INTO cart VALUES (8, 8);
INSERT INTO cart VALUES (9, 9);
INSERT INTO cart VALUES (10, 10);
INSERT INTO cart VALUES (11, 6);
INSERT INTO cart VALUES (12, 11);
INSERT INTO cart VALUES (13, 12);
INSERT INTO cart VALUES (14, 13);
INSERT INTO cart VALUES (15, 14);
INSERT INTO cart VALUES (16, 15);
INSERT INTO cart VALUES (17, 16);
INSERT INTO cart VALUES (18, 18);
INSERT INTO cart VALUES (19, 19);
INSERT INTO cart VALUES (20, 20);

SELECT * FROM cart;

CREATE TABLE cartLine (
    cartID int NOT NULL,
    productID int NOT NULL,
    quantity int,
    CONSTRAINT cartLine_PK PRIMARY KEY (cartID, productID),
    CONSTRAINT cartLine_FK1 FOREIGN KEY (cartID) REFERENCES cart,
    CONSTRAINT cartLine_FK2 FOREIGN KEY (productID) REFERENCES product
);

INSERT INTO cartLine VALUES (1, 5, 1);
INSERT INTO cartLine VALUES (1, 3, 1);
INSERT INTO cartLine VALUES (2, 4, 3);
INSERT INTO cartLine VALUES (3, 1, 1);
INSERT INTO cartLine VALUES (4, 2, 1);
INSERT INTO cartLine VALUES (5, 4, 2);
INSERT INTO cartLine VALUES (6, 4, 1);
INSERT INTO cartLine VALUES (7, 5, 1);
INSERT INTO cartLine VALUES (8, 6, 3);
INSERT INTO cartLine VALUES (9, 8, 1);
INSERT INTO cartLine VALUES (10, 9, 1);
INSERT INTO cartLine VALUES (10, 10, 2);
INSERT INTO cartLine VALUES (11, 8, 1);
INSERT INTO cartLine VALUES (12, 10, 1);
INSERT INTO cartLine VALUES (12, 17, 3);
INSERT INTO cartLine VALUES (13, 13, 1);
INSERT INTO cartLine VALUES (14, 8, 1);
INSERT INTO cartLine VALUES (14, 9, 1);
INSERT INTO cartLine VALUES (15, 18, 2);
INSERT INTO cartLine VALUES (16, 12, 1);
INSERT INTO cartLine VALUES (16, 13, 1);
INSERT INTO cartLine VALUES (16, 14, 3);
INSERT INTO cartLine VALUES (17, 16, 1);
INSERT INTO cartLine VALUES (18, 7, 1);
INSERT INTO cartLine VALUES (18, 13, 1);
INSERT INTO cartLine VALUES (18, 18, 2);
INSERT INTO cartLine VALUES (19, 5, 1);
INSERT INTO cartLine VALUES (19, 3, 1);
INSERT INTO cartLine VALUES (20, 14, 3);

SELECT * FROM cartLine;

CREATE TABLE orders (
    orderID int NOT NULL,
    cartID int,
    orderDate date,
    orderStatus varchar(30),
    totalCost decimal(6,2),
    CONSTRAINT orders_PK PRIMARY KEY (orderID),
    CONSTRAINT orders_FK1 FOREIGN KEY (cartID) REFERENCES cart
);

INSERT INTO orders VALUES (1, 1, '2020-06-20', 'Delivered', 1369.98);
INSERT INTO orders VALUES (2, 2, '2020-09-06', 'Delivered', 149.97); 
INSERT INTO orders VALUES (3, 3, '2021-09-16', 'Delivered', 349.99);
INSERT INTO orders VALUES (4, 4, '2021-12-07', 'Delivered', 29.99);
INSERT INTO orders VALUES (5, 5, '2022-02-27', 'Delivered', 99.98);
INSERT INTO orders VALUES (6, 6, '2022-02-27', 'Delivered', 139.98);
INSERT INTO orders VALUES (7, 7, '2022-03-01', 'Delivered', 1149.97); 
INSERT INTO orders VALUES (8, 8, '2022-03-06', 'Delivered', 13.99);
INSERT INTO orders VALUES (9, 9, '2022-03-17', 'Delivered', 42.00);
INSERT INTO orders VALUES (10, 10, '2022-03-18', 'Delivered', 99.08);
INSERT INTO orders VALUES (11, 11, '2022-03-18', 'Delivered', 72.98);
INSERT INTO orders VALUES (12, 12, '2022-03-21', 'Delivered', 193.54); 
INSERT INTO orders VALUES (13, 13, '2022-03-22', 'Delivered', 399.99);
INSERT INTO orders VALUES (14, 14, '2022-03-28', 'Delivered', 103.43);
INSERT INTO orders VALUES (15, 15, '2022-04-02', 'Delivered', 104.27);
INSERT INTO orders VALUES (16, 16, '2022-04-20', 'In Transit', 1847.98);
INSERT INTO orders VALUES (17, 17, '2022-05-01', 'In Transit', 149.00); 
INSERT INTO orders VALUES (18, 18, '2022-05-06', 'Processing', 847.99);
INSERT INTO orders VALUES (19, 19, '2022-05-07', 'Processing', 46.99);
INSERT INTO orders VALUES (20, 20, '2022-05-07', 'Processing', 27.50);

SELECT * FROM orders;

CREATE TABLE shipping(
	trackingID int NOT NULL,
	orderID int,
	addressStreet varchar(100),
	addressCity varchar(100),
	addressState varchar(5),
	addressCountry varchar(100),
	addressPostal varchar(10),
	orderStatus varchar(20),
	currentLocation varchar(255),
    estDelivery date,
	CONSTRAINT shipping_PK PRIMARY KEY (trackingID),
	CONSTRAINT shipping_FK FOREIGN KEY (orderID) REFERENCES orders
);

INSERT INTO shipping VALUES (1, 1, '20 Australia Street', 'Newtown', 'NSW', 'Australia', '2042', 'Delivered', 'Newtown, Australia', '2020-07-01');
INSERT INTO shipping VALUES (2, 2, '206/101 Forest Road', 'Hurstville', 'NSW', 'Australia', '2220', 'Delivered', 'Hurstville, Australia', '2020-09-20');
INSERT INTO shipping VALUES (3, 3, '31 Watkins Road', 'Newcastle', 'NSW', 'Australia', '2267', 'Delivered', 'Newcastle, Australia', '2021-09-25');
INSERT INTO shipping VALUES (4, 4, '27 Mill Street', 'Carlton', 'VIC', 'Australia', '3053', 'Delivered', 'Melbourne, Australia', '2021-12-19');
INSERT INTO shipping VALUES(5, 5, '123 Sesame Street', 'Lazy Town','TX', 'United States of America', '99304', 'Delivered', 'Lazy Town, United States of America',  '2022-03-14');
INSERT INTO shipping VALUES (6, 6, '742 Evergreen Terrace', 'Springfield', 'ORE', 'United States of America', '97077', 'Delivered', 'Springfield, United States of America', '2022-05-01');
INSERT INTO shipping VALUES (7, 7, '13 Railway Parade', 'Newtown', 'NSW', 'Australia', '2042', 'Delivered', 'Newtown, Australia', '2022-03-28');
INSERT INTO shipping VALUES (8, 8, '31/5 Wattle Avenue', 'Parramatta', 'NSW', 'Australia', '2150', 'Delivered', 'Parramatta, Australia', '2022-04-05');
INSERT INTO shipping VALUES (9, 9, '127 Acorn Road', 'Cairns', 'QLD', 'Australia', '4870', 'Delivered', 'Cairns, Australia', '2022-05-07');
INSERT INTO shipping VALUES(10, 10, '3/56 Oliver Crescent', 'Macquarie Fields', 'NSW', 'Australia', '2564', 'Delivered', 'Macquarie Fields, Australia', '2022-04-12');
INSERT INTO shipping VALUES (11, 11, '22 Australia Street', 'Newtown', 'NSW', 'Australia', '2042', 'Delivered', 'Newtown, Australia', '2022-04-18');
INSERT INTO shipping VALUES (12, 12, '34 Chester Street', 'The Pocket', 'NSW', 'Australia', '2483', 'Delivered', 'The Pocket, Australia', '2022-04-20');
INSERT INTO shipping VALUES (13, 13, '67 Panorama Road', 'Taminda', 'NSW', 'Australia', '2340', 'Delivered', 'Taminda, Australia', '2022-04-25');
INSERT INTO shipping VALUES (14, 14, '1 Little Myers Street', 'Darley', 'VIC', 'Australia', '3340', 'Delivered', 'Melbourne, Australia', '2022-05-04');
INSERT INTO shipping VALUES(15, 15, '77 Bayview Road', 'Chinbingina','SA', 'Australia', '5680', 'Delivered', 'Chinbingina, Australia',  '2022-05-13');
INSERT INTO shipping VALUES (16, 16, '43 English Street', 'Murray Bridge', 'SA', 'Australia', '4254', 'In Transit', 'Sydney, Australia', '2022-05-28');
INSERT INTO shipping VALUES (17, 17, '46 Savages Road', 'Tarragindi', 'QLD', 'Australia', '4121', 'In Transit', 'Sydney, Australia', '2022-05-27');
INSERT INTO shipping VALUES (18, 18, '68 Round Drive', 'Wallsend South', 'NSW', 'Australia', '2287', 'Processing', 'Sydney, Australia', '2022-05-25');
INSERT INTO shipping VALUES (19, 19, '29 George Street', 'Bayrick', 'QLD', 'Australia', '4478', 'Processing', 'Sydney, Australia', '2022-06-13');
INSERT INTO shipping VALUES(20, 20, '30 Parton Road', 'Liverpool','UK', 'England', '0151', 'Processing', 'Sydney, Australia',  '2022-08-14');

SELECT * FROM shipping;

CREATE TABLE payment(
	paymentID int NOT NULL,
	orderID int,
	customerID int,
	cardnumber varchar(20),
	cardname varchar(30),
	cardexpiry date,
	cardcvv varchar(4),
	paymentdate date,
	CONSTRAINT payment_PK PRIMARY KEY (paymentID),
	CONSTRAINT payment_FK1 FOREIGN KEY (orderID) REFERENCES orders,
	CONSTRAINT payment_FK2 FOREIGN KEY (customerID) REFERENCES customer
);

INSERT INTO payment VALUES (1, 1, 1, '1111222233334444', 'John Smith', '2024-01-01', '0123', '2020-06-20');
INSERT INTO payment VALUES (2, 2, 1, '1111222233334444', 'John Smith', '2024-01-01', '0123', '2020-09-06');
INSERT INTO payment VALUES (3, 3, 2, '1111222233334411', 'Samantha Green', '2024-03-02', '1543', '2020-09-16');
INSERT INTO payment VALUES (4, 4, 3, '1111222233334412', 'Long Bottom', '2024-04-03', '8475', '2021-12-07');
INSERT INTO payment VALUES (5, 5, 5, '1111222233334413', 'Steven Strange', '2024-05-01', '3542', '2021-02-27');
INSERT INTO payment VALUES (6, 6, 4, '1111222233331111', 'Jill Nill', '2024-07-01', '9876', '2021-02-27');
INSERT INTO payment VALUES (7, 7, 7, '1111222233334441', 'Iason Bothe', '2024-08-01', '0847', '2022-03-03');
INSERT INTO payment VALUES (8, 8, 8, '1111222233334401', 'Gallo Kurata', '2024-12-01', '7642', '2022-03-06');
INSERT INTO payment VALUES (9, 9, 9, '1111222231334412', 'Uni Bros', '2024-04-12', '9877', '2022-03-17');
INSERT INTO payment VALUES (10, 10, 10, '1111222233314413', 'Papa Riche', '2024-05-05', '4658', '2022-03-18');
INSERT INTO payment VALUES (11, 11, 6, '1234123412341234', 'Penelope Lane', '2022-01-01', '9472', '2022-03-20');
INSERT INTO payment VALUES (12, 12, 11, '1100222233334444', 'Dick Smith', '2024-11-01', '2843', '2020-03-21');
INSERT INTO payment VALUES (13, 13, 12, '1111222233334400', 'Johnny Green', '2024-03-17', '2394', '2022-03-22');
INSERT INTO payment VALUES (14, 14, 13, '1111222233334410', 'Tim Cha', '2024-04-18', '5546', '2022-03-28');
INSERT INTO payment VALUES (15, 15, 14, '1111222233331113', 'Emer Zelenka', '2024-09-01', '0564', '2022-04-02');
INSERT INTO payment VALUES (16, 16, 15, '1111222233330000', 'Georgia Tierney', '2024-10-10', '8471', '2022-04-22');
INSERT INTO payment VALUES (17, 17, 16, '1111222233331444', 'Aisha Islam', '2024-11-11', '1111', '2022-05-02');
INSERT INTO payment VALUES (18, 18, 18, '1111222233335411', 'Long Haired', '2023-03-30', '8847', '2022-05-06');
INSERT INTO payment VALUES (19, 19, 19, '1111227833334412', 'Brendon Robles', '2024-02-03', '0758', '2022-05-07');
INSERT INTO payment VALUES (20, 20, 20, '1111222233304413', 'Hillary Greene', '2024-05-28', '1443', '2022-05-10');

SELECT * from payment;