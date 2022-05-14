<%-- 
    Document   : index
    Created on : 30 Mar. 2022, 2:26:37 pm
    Author     : tammi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home - IoTBay</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/index.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
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
        
        <div class="page-content"> <!<!-- Everything in the middle of the screen -->
            <h1>Welcome to IoTBay!</h1><br>
            <p>To place an order, please</p><br>
            <a class="main-link" href = login.jsp>Login</a> or  
            <a class="main-link" href = register.jsp>Register</a> or
            <a class="main-link" href = staffwelcome.jsp>Staff Welcome Bypass</a>
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>