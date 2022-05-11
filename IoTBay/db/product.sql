/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE product (
    productID int NOT NULL,
    productName varchar(50),
    productSupplier varchar(50),
    productDescription varchar(255),
    productCost decimal(6,2),
    quantityAvailable int,
    quantitySold int,
    CONSTRAINT product_PK PRIMARY KEY (productID)
);

INSERT INTO product VALUES (1, 'Mesh Modem', 'FEthernet', 'Fastest Mesh Modem you can get for your home!', 349.99, 5, 5);
INSERT INTO product VALUES (2, 'USB-C Hub', 'HT Tech', 'USB-C Hub for Laptop', 29.99, 4, 10);
INSERT INTO product VALUES (3, 'iPhone 13', 'Apple', 'The Newest iPhone', 1299.99, 10, 10);
INSERT INTO product VALUES (4, 'Flashlight 5W', 'Camping Supplies Co.', 'Brighter than your future', 49.99, 1, 100);
INSERT INTO product VALUES (5, 'Computer Speakers','Logitech', 'Computer Speakers for Home Office', 69.99, 20, 10);

SELECT * FROM product;

