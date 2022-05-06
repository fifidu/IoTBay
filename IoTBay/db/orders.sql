/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE orders (
    orderID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    cartID int,
    orderDate date,
    orderStatus varchar(30),
    totalCost decimal(10,2),
    CONSTRAINT orders_PK PRIMARY KEY (orderID),
    CONSTRAINT orders_FK1 FOREIGN KEY (cartID) REFERENCES cart
);

INSERT INTO orders (cartID, orderDate, orderStatus, totalCost) VALUES (1, '2020-06-20', 'Delivered', 1369.98);
INSERT INTO orders (cartID, orderDate, orderStatus, totalCost) VALUES (2, '2020-09-06', 'Delivered', 149.97); 
INSERT INTO orders (cartID, orderDate, orderStatus, totalCost) VALUES (3, '2021-09-16', 'Delivered', 349.99);
INSERT INTO orders (cartID, orderDate, orderStatus, totalCost) VALUES (4, '2021-12-07', 'Processing', 29.99);
INSERT INTO orders (cartID, orderDate, orderStatus, totalCost) VALUES (5, '2022-02-27', 'Processing', 99.98);

SELECT * FROM orders;
