<%-- 
    Document   : welcome
    Created on : 16/03/2022, 3:00:18 PM
    Author     : fifidu
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/welcome.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
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
        
        <%
        Customer customer = (Customer) session.getAttribute("customer");
        %>
        
        <div class="page-content">
            <h1>IoTBay</h1><br>
            <h2>Welcome, <%=customer.getCusFName()%></h2><br>
            <p>Your email is <%=customer.getCusEmailAddress()%></p><br>
            <a class="main-link" href="main.jsp">Continue to Store</a>
        </div>
    </body>
</html>