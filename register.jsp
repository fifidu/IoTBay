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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="welcome.jsp" method="post">
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" id="fname" name="fname" required></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" id="lname" name="lname" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" id="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Contact Number:</td>
                    <td><input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required></td>
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
                    <td><input type="checkbox" id="tos" name="tos"></td>
                </tr>
            </table>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
