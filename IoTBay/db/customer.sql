/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

create table customer (
    customerID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    cusFName varchar(30) NOT NULL,
    cusLName varchar(30) NOT NULL,
    cusEmailAddress varchar(50) NOT NULL,
    cusContactNumber varchar(10) NOT NULL,
    cusPassword varchar(100) NOT NULL,
    CONSTRAINT customer_PK PRIMARY KEY (customerID)
);

INSERT INTO customer VALUES ('John', 'Smith', 'john.smith@email.com', '0401010010');
INSERT INTO customer VALUES ('Samantha', 'Green', 'sam.green@email.com', '0483826496');
INSERT INTO customer VALUES ('Long', 'Bottom', 'long.bottom@email.com', '0482957283');
INSERT INTO customer VALUES ('Jill', 'Nill', 'jill.nill@email.com', '0483728573');
INSERT INTO customer VALUES ('Steven', 'Strange', 'steven.strange@avengers.com', '0438724104');

SELECT * FROM customer;

