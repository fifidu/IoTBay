/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Tammihn Ha
 * Created: 05/05/2022
 */

CREATE TABLE staff(
	staffID int NOT NULL,
	staffFName varchar(30) NOT NULL,
	staffLName varchar(30) NOT NULL,
	staffEmailAddress varchar(50) NOT NULL,
	staffContactNumber varchar(10) NOT NULL,
	CONSTRAINT staff_PK  PRIMARY KEY (staffID)
);

INSERT INTO staff VALUES (1, 'Tracy', 'Nightingale', 't.night@darkmail.com', '0429273951');
INSERT INTO staff VALUES (2, 'Christine', 'Wong', 'cwong15@trollmail.com', '0487295738');
INSERT INTO staff VALUES (3, 'Peter', 'Pan', 'ppan@fairymail.com', '0483039233');
INSERT INTO staff VALUES (4, 'Jack', 'Sparrow', 'j.sparrow@rummail.com', '0484628462');
INSERT INTO staff VALUES (5, 'Steve', 'Minecraft', 'steve.m@crafty.com', '0494748293');

SELECT * FROM staff;
