/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE shipping (
    shippingID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    orderID int,
    addressStreet varchar(100),
    addressCity varchar(100),
    addressState varchar(5),
    addressCountry varchar(100),
    addressPostal varchar(10),
    orderStatus varchar(20),
    currentLocation varchar(255),
    estDelivery date,
    CONSTRAINT shipping_PK PRIMARY KEY (shippingID),
    CONSTRAINT shipping_FK FOREIGN KEY (orderID) REFERENCES orders
);

INSERT INTO shipping (orderID, addressStreet, addressCity, addressState, addressCountry, addressPostal, orderStatus, currentLocation, estDelivery) VALUES (1, '20 Australia Street', 'Newtown', 'NSW', 'Australia', '2042', 'Delivered', 'Newtown, Australia', '2020-07-01');
INSERT INTO shipping (orderID, addressStreet, addressCity, addressState, addressCountry, addressPostal, orderStatus, currentLocation, estDelivery) VALUES (2, '206/101 Forest Road', 'Hurstville', 'NSW', 'Australia', '2220', 'Delivered', 'Hurstville, Australia', '2020-09-20');
INSERT INTO shipping (orderID, addressStreet, addressCity, addressState, addressCountry, addressPostal, orderStatus, currentLocation, estDelivery) VALUES (3, '31 Watkins Road', 'Newcastle', 'NSW', 'Australia', '2267', 'Delivered', 'Newcastle, Australia', '2021-09-25')
INSERT INTO shipping (orderID, addressStreet, addressCity, addressState, addressCountry, addressPostal, orderStatus, currentLocation, estDelivery) VALUES (4, '27 Mill Street', 'Carlton', 'VIC', 'Australia', '3053', 'In Transit', 'Melbourne, Australia', '2021-12-19');
INSERT INTO shipping (orderID, addressStreet, addressCity, addressState, addressCountry, addressPostal, orderStatus, currentLocation, estDelivery) VALUES (5, '123 Sesame Street', 'Lazy Town','TX', 'United States of America', '99304', 'Delivered', 'Lazy Town, United States of America', '2022-03-14');
SELECT * FROM shipping;
