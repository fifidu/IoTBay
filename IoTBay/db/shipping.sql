/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

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

INSERT INTO shipping VALUES (1, 1, '20 Australia Street', 'Newtown', 'NSW', 'Australia', '2042', 'Delivered', 'Newtown, Australia', '20200701');
INSERT INTO shipping VALUES (2, 2, '206/101 Forest Road', 'Hurstville', 'NSW', 'Australia', '2220', 'Delivered', 'Hurstville, Australia', '20200920');
INSERT INTO shipping VALUES (3, 3, '31 Watkins Road', 'Newcastle', 'NSW', 'Australia', '2267', 'Delivered', 'Newcastle, Australia', '20210925')
INSERT INTO shipping VALUES (4, 4, '27 Mill Street', 'Carlton', 'VIC', 'Australia', '3053', 'In Transit', 'Melbourne, Australia', '20211219');
INSERT INTO shipping VALUES(5, 5, '123 Sesame Street', 'Lazy Town','TX', 'United States of America', '99304', 'Delivered', 'Lazy Town, United States of America',  '20220314');

SELECT * FROM shipping;