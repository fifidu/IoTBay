# IoTBay
Group 30 - Introduction to Software Development [Autumn 2022]

Contents of this file
------------------------------------------
*Project Description
*Requirements
*Installation
*Configuration
*Group Members

Introduction
------------------------------------------
The IoTBay web application allows its users (IoTBay staff and customers) to register an account in order to access the main store page. Returning users can log into the application using an email address and password.

‘index.jsp’ serves as the landing page, from which the user can either login (login.jsp) or register (register.jsp) to access the main store page (main.jsp). From the main page, the user can log out (logout.jsp), upon which their session will be terminated.

To view the accompanying report, visit: https://docs.google.com/document/d/1xJ9-4yDXiKTA4QnkpgtR0OuHemYwV8Ow9jE1mKq88G4/edit?usp=sharing

To suggest changes or view version history, visit: https://github.com/fifidu/IoTBay

Requirements
------------------------------------------
Java 8u321
Glassfish 4.1.2
NetBeans IDE 12.6

Installation
------------------------------------------
Glassfish 4.1.2
* Download Glassfish 4.1.2 from https://javaee.github.io/glassfish/download
* Unzip the Glassfish zip file at a desired location
* Open Command Prompt (Windows) or Terminal (macOS) 
* Change the directory to the Glassfish installation directory and run the following: “bin/asadmin”
* In order to deploy the file, you must start a domain. Run the following to start a domain: “start-domain [domain name]”
* To deploy the file run the following: “deploy [directory to file]”
* Go to desired browser and type the following: “http://localhost:8080/IoTBay

NetBeans IDE 12.6
* Download Glassfish 4.1.2 from https://javaee.github.io/glassfish/download
* Unzip the Glassfish zip file at a desired location
* Open the IoTBay.war file in NetBeans IDE 12.6
* Press Run Project


Configuration
------------------------------------------
After installation, no further configuration is required.

Group Members
------------------------------------------
* Christopher Vuong, 13568530
* Tammihn Ha, 14242008
* Minh Quan Tran, 14065662
* Fifi Du, 14240547
* Sharmila Rahman, 14275198
