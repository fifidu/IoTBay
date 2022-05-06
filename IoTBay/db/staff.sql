/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE staff (
    staffID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    staffFName varchar(30) NOT NULL,
    staffLName varchar(30) NOT NULL,
    staffEmailAddress varchar(50) NOT NULL,
    staffContactNumber varchar(10) NOT NULL,
    staffPassword varchar(100) NOT NULL,
    CONSTRAINT staff_PK  PRIMARY KEY (staffID)
);

INSERT INTO staff (staffFName, staffLName, staffEmailAddress, staffContactNumber, staffPassword) VALUES ('Tracy', 'Nightingale', 't.night@darkmail.com', '0429273951', 'May the odds be ever in your favour');
INSERT INTO staff (staffFName, staffLName, staffEmailAddress, staffContactNumber, staffPassword) VALUES ('Christine', 'Wong', 'cwong15@trollmail.com', '0487295738', 'Any strong emotions release the panda');
INSERT INTO staff (staffFName, staffLName, staffEmailAddress, staffContactNumber, staffPassword) VALUES ('Peter', 'Pan', 'ppan@fairymail.com', '0483039233', 'Faith, trust and pixie dust');
INSERT INTO staff (staffFName, staffLName, staffEmailAddress, staffContactNumber, staffPassword) VALUES ('Jack', 'Sparrow', 'j.sparrow@rummail.com', '0484628462', 'Wherever we want to go, we'll go);
INSERT INTO staff (staffFName, staffLName, staffEmailAddress, staffContactNumber, staffPassword) VALUES ('Steve', 'Minecraft', 'steve.m@crafty.com', '0494748293', 'Steve was blown up by a creeper');

SELECT * FROM staff;
