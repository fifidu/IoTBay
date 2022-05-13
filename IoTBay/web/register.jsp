<%-- 
    Document   : register
    Created on : 16/03/2022, 2:33:00 PM
    Author     : fifidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/register.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <title>Register - IoTBay</title>
    </head>
    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="index.jsp"><h3>IoTBay</h3></a>
                </div>
            </div>
            
            <div class="header-outline"></div>
        </header>
        
        <div class="page-content">
            <form action="RegisterController" method="post">
                <h1 class="title">Register</h1>
                <label><b>First Name</b></label><br>
                <input type="text" id="fname" name="firstName" required><br><br>
                <label><b>Last Name</b></label><br>
                <input type="text" id="lname" name="lastName" required><br><br>
                <label><b>Email</b></label><br>
                <input type="email" id="email" name="emailAddress" required><br><br>
                <label><b>Phone Number</b></label><br>
                <input type="tel" id="phone" name="phoneNo" pattern="[0-9]{10}" required><br><br>
                <label><b>Password</b></label><br>
                <input type="password" id="password" name="password" required><br><br>
                <label><b>Confirm Password</b></label><br>
                <input type="password" id="cpassword" name="cpassword" required><br><br>
                <input type="submit" value="Register">
            </form>
        </div>
        <div class="second-content">
            <p>Already have an account? <a href="login.jsp">Login</a></p>
        </div>
    </body>
</html>
