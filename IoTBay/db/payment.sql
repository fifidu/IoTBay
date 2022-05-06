/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE payment (
    paymentID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    orderID int,
    cardnumber int,
    cardname varchar(30),
    cardexpiry date,
    CONSTRAINT payment_PK PRIMARY KEY (paymentID),
    CONSTRAINT payment_FK FOREIGN KEY (orderID) REFERENCES orders
);

INSERT INTO payment (orderID, cardName, cardNumber, cardExpiry) VALUES (1, 1111222233334444, 'John Smith', 2024-01-01);
INSERT INTO payment (orderID, cardName, cardNumber, cardExpiry) VALUES (2, 1111222233334444, 'John Smith', 2024-01-01);
INSERT INTO payment (orderID, cardName, cardNumber, cardExpiry) VALUES (3, 1111222233334411, 'Samantha Green', 2024-03-01);
INSERT INTO payment (orderID, cardName, cardNumber, cardExpiry) VALUES (4, 1111222233334412, 'Long Bottom', 2024-04-01);
INSERT INTO payment (orderID, cardName, cardNumber, cardExpiry) VALUES (5, 1111222233334413, 'Steven Strange', 2024-05-01);

SELECT * from payment;
