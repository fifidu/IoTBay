<%-- 
    Document   : newjsp
    Created on : 16 Mar 2022, 2:21:57 pm
    Author     : fifidu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css" >
        <title>Login - IoTBay</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="welcome.jsp" method="post">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" id="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="password" name="password" required></td>
                </tr>              
            </table>
            <input type="submit" value="Login">
        </form>
        <div>
            <p>Don't have an account?</p>
            <a class="main-link" href="register.jsp">Create an account</a>
        </div>
    </body>
</html>
