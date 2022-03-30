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
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css" >
    </head>
    <body>
        <h1>Welcome to IoTBay!</h1>
        <div>
            <p>To place an order, please</p> 
            <a class="main-link" href = login.jsp>Login</a>
            <a class="main-link" href = register.jsp>Register</a></div>
    </body>
</html>
