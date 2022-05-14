<%-- 
    Document   : newjsp
    Created on : 16 Mar 2022, 2:21:57 pm
    Author     : Tammihn Ha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/login.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <title>Staff Login - IoTBay</title>
    </head>
    <body onload = "startTime() ">
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="index.jsp"><h3>IoTBay</h3></a>
                </div>
            </div>
            
            <div class="header-outline"></div>
        </header>
        <%
        String unregisteredErr = (String) session.getAttribute("unregisteredErr");
        String incorrectPassErr = (String) session.getAttribute("incorrectPassErr");
        String emailFormatErr = (String) session.getAttribute("emailFormatErr");
        %>
        <div class="page-content">
            <form action="StaffLoginController" method="post">
                <h1 class="title">Login</h1>
                <p><span class="err-msg"><%=(unregisteredErr != null ? unregisteredErr : "")%></span></p>
                <label><b>Email</b> <span class="err-msg"><%=(emailFormatErr != null ? emailFormatErr : "")%></span></label>
                <input type="text" id="email" name="staffEmailAddress">
                <label><b>Password</b> <span class="err-msg"><%=(incorrectPassErr != null ? incorrectPassErr : "")%></span></label>
                <input type="password" id="password" name="staffPass">
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>

