/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE cart (
    cartID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    customerID int NOT NULL,
    CONSTRAINT cart_PK PRIMARY KEY (cartID),
    CONSTRAINT cart_FK FOREIGN KEY (customerID) REFERENCES customer
);

INSERT INTO customer (customerID) VALUES (1);
INSERT INTO customer (customerID) VALUES (1);
INSERT INTO customer (customerID) VALUES (2);
INSERT INTO customer (customerID) VALUES (3);
INSERT INTO customer (customerID) VALUES (4);

SELECT * FROM cart;
