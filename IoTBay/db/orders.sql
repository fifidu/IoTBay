/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE orders (
    orderID int NOT NULL,
    cartID int,
    orderDate date,
    orderStatus varchar(30),
    totalCost DOUBLE(6,2),
    CONSTRAINT orders_PK PRIMARY KEY (orderID),
    CONSTRAINT orders_FK1 FOREIGN KEY (cartID) REFERENCES cart
);

INSERT INTO orders VALUES (1, 1, '20200620', 'Delivered', 1369.98);
INSERT INTO orders VALUES (2, 2, '20200906', 'Delivered', 149.97); 
INSERT INTO orders VALUES (3, 3, '20210916', 'Delivered', 349.99);
INSERT INTO orders VALUES (4, 4, '20211207', 'Processing', 29.99);
INSERT INTO orders VALUES (5, 5, '20220227', 'Processing', 99.98);

SELECT * FROM orders;