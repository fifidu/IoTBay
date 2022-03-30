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
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css" >
        <title>Welcome - IoTBay</title>
    </head>
    <body>
        <h1>IoTBay</h1>
        <h2>Welcome, <%= request.getParameter("fname") %>!</h2>
    </body>
</html>
