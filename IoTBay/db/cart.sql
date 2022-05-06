/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE cart (
	cartID int NOT NULL,
	customerID int NOT NULL,
	CONSTRAINT cart_PK PRIMARY KEY (cartID),
	CONSTRAINT cart_FK FOREIGN KEY (customerID) REFERENCES customer
);

INSERT INTO customer VALUES (1, 1);
INSERT INTO customer VALUES (2, 1);
INSERT INTO customer VALUES (3, 2);
INSERT INTO customer VALUES (4, 3);
INSERT INTO customer VALUES (5, 4);

SELECT * FROM cart;