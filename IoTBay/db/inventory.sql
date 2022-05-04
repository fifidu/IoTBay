/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fifidu
 * Created: 04/05/2022
 */

CREATE TABLE inventory (
    productID int,
    productName varchar(50),
    productSupplier varchar(50),
    productDescription varchar(255),
    productCost double,
    quantityAvailable int,
    quantitySold int
    CONSTRAINT inventory_PK PRIMARY KEY (productID)
);