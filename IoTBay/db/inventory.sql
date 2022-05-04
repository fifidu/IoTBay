/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fifidu
 * Created: 04/05/2022
 */

CREATE TABLE Inventory {
    ProductID INT,
    ProductName VARCHAR,
    ProductSupplier VARCHAR,
    ProductDescription VARCHAR,
    ProductCost DOUBLE,
    QuantityAvailable INT,
    QuantitySold INT
};