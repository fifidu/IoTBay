<%-- 
    Document   : welcome
    Created on : 16/03/2022, 3:00:18 PM
    Author     : fifidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/welcome.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
<!--        <link href="./css/styles.css" rel="stylesheet" type="text/css" >-->
        <title>Welcome - IoTBay</title>
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
            <h1>IoTBay</h1><br>

            <jsp:useBean id="user" class="uts.isd.model.UserBean" scope="session"/>
            <jsp:setProperty name="user" property="firstName" value="${param.firstName}"/>
            <jsp:setProperty name="user" property="lastName" value="${param.lastName}"/>
            <jsp:setProperty name="user" property="emailAddress" value="${param.emailAddress}"/>
            <jsp:setProperty name="user" property="phoneNo" value="${param.phoneNo}"/>
            <jsp:setProperty name="user" property="password" value="${param.password}"/>

            <h2>Welcome, <jsp:getProperty name="user" property="firstName"/></h2><br>
            <p>Your email is <jsp:getProperty name="user" property="emailAddress"/></p><br>
            <a class="main-link" href="main.jsp">Continue to Store</a>
        </div>
    </body>
</html>