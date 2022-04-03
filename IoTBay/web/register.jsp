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
            <h1>Register</h1>
            <form action="welcome.jsp" method="post">
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" id="fname" name="firstName" required></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" id="lname" name="lastName" required></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" id="email" name="emailAddress" required></td>
                    </tr>
                    <tr>
                        <td>Contact Number:</td>
                        <td><input type="tel" id="phone" name="phoneNo" pattern="[0-9]{10}" required></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" id="password" name="password" required></td>
                    </tr>
                    <tr>
                        <td>Confirm Password:</td>
                        <td><input type="password" id="cpassword" name="cpassword" required></td>
                    </tr>                
                    <tr>
                        <td>Agree to terms of service?</td>
                        <td><input type="checkbox" id="tos" name="tos" required></td>
                    </tr>
                </table>
                <input type="submit" value="Register">
            </form><br>
            <div>
            <p>Already have an account? <a href="login.jsp">Login</a></p>
        </div>
        </div>
    </body>
</html>
