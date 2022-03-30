<%-- 
    Document   : logout
    Created on : 30 Mar. 2022, 2:42:46 pm
    Author     : tammi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css" >
        <title>Logout</title>
    </head>
    <body>
        <% session.invalidate(); %>
        <h1>You have been logged out</h1>
    </body>
</html>
