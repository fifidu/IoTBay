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
        
        <%
        String emailFormatErr = (String) session.getAttribute("emailFormatErr");
        String passFormatErr = (String) session.getAttribute("passFormatErr");
        String confirmPassErr = (String) session.getAttribute("confirmPassErr");
        String nameFormatErr = (String) session.getAttribute("nameFormatErr");
        String contactFormatErr = (String) session.getAttribute("contactFormatErr");
        String existingAccountErr = (String) session.getAttribute("existingAccountErr");
        %>
        <div class="page-content">
            <form action="RegisterController" method="post">
                <h1 class="title">Register</h1>
                <p><span class="err-msg"><%=(existingAccountErr != null ? existingAccountErr : "")%></span></p>
                <label><b>First Name</b> <span class="err-msg"><%=(nameFormatErr != null ? nameFormatErr : "")%></span></label><br>
                <input type="text" id="fname" name="cusFName" ><br><br>
                <label><b>Last Name</b> <span class="err-msg"><%=(nameFormatErr != null ? nameFormatErr : "")%></span></label><br>
                <input type="text" id="lname" name="cusLName" ><br><br>
                <label><b>Email</b> <span class="err-msg"><%=(emailFormatErr != null ? emailFormatErr : "")%></span></label><br>
                <input type="text" id="email" name="cusEmailAddress" ><br><br>
                <label><b>Phone Number</b> <span class="err-msg"><%=(contactFormatErr != null ? contactFormatErr : "")%></span></label><br>
                <input type="text" id="phone" name="cusContactNumber" pattern="[0-9]{10}" ><br><br>
                <label><b>Password</b> <span class="err-msg"><%=(passFormatErr != null ? passFormatErr : "")%></span></label><br>
                <input type="password" id="password" name="cusPass" ><br><br>
                <label><b>Confirm Password</b> <span class="err-msg"><%=(confirmPassErr != null ? confirmPassErr : "")%></span></label><br>
                <input type="password" id="cpassword" name="cusConfirmPass" ><br><br>
                <input type="submit" value="Register">
            </form>
        </div>
        <div class="second-content">
            <p>Already have an account? <a href="login.jsp">Login</a></p>
        </div>
    </body>
</html>
