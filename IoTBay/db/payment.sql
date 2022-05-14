/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

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