<%-- 
    Document   : customerremoved
    Created on : 15 May 2022, 5:05:09 pm
    Author     : tammi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/logout.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <title>Logout</title>
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
        <% session.invalidate(); %>
        <div class="page-content">
            <h1>Your account has been deleted</h1><br>
            <p><a class="underline-link" href = "index.jsp">Click here to return to index</a> </p>
        </div>
    </body>
</html>
