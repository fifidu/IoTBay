<%-- 
    Document   : newjsp
    Created on : 16 Mar 2022, 2:21:57 pm
    Author     : fifidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/login.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <title>Login - IoTBay</title>
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
            <h1>Login</h1>
        <form action="welcome.jsp" method="post">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" id="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password" required></td>
                </tr>
                <br>
            </table>
            <br>
            <input type="submit" value="Login">
        </form><br>
        <div>
            <p>Don't have an account?</p><br>
            <a class="main-link" href="register.jsp">Create an account</a>
        </div>
        </div>
    </body>
</html>
