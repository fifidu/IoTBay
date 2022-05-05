/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  chrisvuong
 * Created: 26/04/2022
 */

CREATE TABLE orders (
    orderID int,
    customerID int,
    cartID int,
    orderDate timestamp,
    orderStatus varchar(30),
    totalCost double,
    CONSTRAINT orders_PK PRIMARY KEY (orderID),
    CONSTRAINT orders_FK1 FOREIGN KEY (customerID) REFERENCES customer,
    CONSTRAINT orders_FK2 FOREIGN KEY (cartID) REFERENCES cart
);