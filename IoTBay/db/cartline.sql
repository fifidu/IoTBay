/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  chrisvuong
 * Created: 26/04/2022
 */

CREATE TABLE cartLine (
    cartID int NOT NULL,
    productID int NOT NULL,
    quantity int,
    CONSTRAINT cartLine_PK PRIMARY KEY (cartID, productID),
    CONSTRAINT cartLine_FK1 FOREIGN KEY (cartID) REFERENCES cart,
    CONSTRAINT cartLine_FK2 FOREIGN KEY (productID) REFERENCES product
);

INSERT INTO cartLine (cartID, productID, quantity) VALUES (1, 5, 1);
INSERT INTO cartLine (cartID, productID, quantity) VALUES (1, 3, 1);
INSERT INTO cartLine (cartID, productID, quantity) VALUES (2, 4, 3);
INSERT INTO cartLine (cartID, productID, quantity) VALUES (3, 1, 1);
INSERT INTO cartLine (cartID, productID, quantity) VALUES (4, 2, 1);
INSERT INTO cartLine (cartID, productID, quantity) VALUES (5, 4, 2);


SELECT * FROM cartLine;
