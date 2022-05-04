/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  chrisvuong
 * Created: 26/04/2022
 */

CREATE TABLE Orders {
    OrderID int,
    CustomerID int,
    CartID int,
    OrderDate timestamp,
    OrderStatus varchar(30),
    TotalCost double
};

