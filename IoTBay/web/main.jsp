-<%--
    Document   : main
    Created on : 27/03/2022, 1:11:50 PM
    Author     : chrisvuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>IoTBay</title>
    </head>
    <header>
        <button id="home">IoTBay</button>
        <input type="text" id="search" name="search" placeholder="Search items"/>
        <button class="searchbtn"><i class="fa fa-search"></i></button>
        <div class="dropdown" style="float:right;">
            <a href="viewcart.jsp" class="topbarbtn"><i class="fa fa-shopping-cart"></i></a>
        </div>
        <div class="dropdown" style="float:right;">
            <button class="dropbtn"><i class="fa fa-user-circle"></i> <jsp:getProperty name="user" property="firstName"/></button>
            <div class="dropdown-content">
                <a href="logout.jsp">Logout</a>
            </div>
        </div>
    </header>
    <body>
        <div>
            <ul class="navbar">
                <li><a class="active">Home</a></li>
                <li><a>Products</a></li>
            </ul>
        </div>
        <div class="main">
            <p>Nothing to see here...</p>
        </div>
    </body>
    <footer>
    </footer>
</html>
