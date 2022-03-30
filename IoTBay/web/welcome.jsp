<%-- 
    Document   : welcome
    Created on : 16/03/2022, 3:00:18 PM
    Author     : fifidu
--%>

<%@page import="uts.isd.model.UserBean"%>
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
        <jsp:useBean id="user" class="uts.isd.model.UserBean" scope="session">
            <jsp:setProperty name="user" property="firstName" value="${param.firstName}"/>
            <jsp:setProperty name="user" property="lastName" value="${param.lastName}"/>
            <jsp:setProperty name="user" property="emailAddress" value="${param.emailAddress}"/>
            <jsp:setProperty name="user" property="phoneNo" value="${param.phoneNo}"/>
            <jsp:setProperty name="user" property="password" value="${param.password}"/>
        </jsp:useBean>
        
        <h2>Welcome, <jsp:getProperty name="user" property="firstName"/></h2>
        <p>Your email is <jsp:getProperty name="user" property="emailAddress"/></p>
        <a href="main.jsp">Continue to Store</a>
    </body>
</html>