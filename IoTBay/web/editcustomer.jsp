<%-- 
    Document   : editcustomer
    Created on : 14 May 2022, 12:53:07 am
    Author     : Tammihn Ha
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/welcome.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <title>Edit Customer - IoTBay</title>
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
            <a class="main-link" href="ShowProductsController">Continue to Store</a>
        </div>
            
     <%
        String emailFormatErr = (String) session.getAttribute("emailFormatErr");
        String passFormatErr = (String) session.getAttribute("passFormatErr");
        String confirmPassErr = (String) session.getAttribute("confirmPassErr");
        String nameFormatErr = (String) session.getAttribute("nameFormatErr");
        String contactFormatErr = (String) session.getAttribute("contactFormatErr");
        String existingAccountErr = (String) session.getAttribute("existingAccountErr");
        %>
        <div class="page-content">
            <form action="RegisterController" method="post">
                <h1 class="title">Register</h1>
                <p><span class="err-msg"><%=(existingAccountErr != null ? existingAccountErr : "")%></span></p>
                <label><b>First Name</b> <span class="err-msg"><%=(nameFormatErr != null ? nameFormatErr : "")%></span></label><br>
                <input type="text" id="fname" name="cusFName" ><br><br>
                <label><b>Last Name</b> <span class="err-msg"><%=(nameFormatErr != null ? nameFormatErr : "")%></span></label><br>
                <input type="text" id="lname" name="cusLName" ><br><br>
                <label><b>Email</b> <span class="err-msg"><%=(emailFormatErr != null ? emailFormatErr : "")%></span></label><br>
                <input type="text" id="email" name="cusEmailAddress" ><br><br>
                <label><b>Phone Number</b> <span class="err-msg"><%=(contactFormatErr != null ? contactFormatErr : "")%></span></label><br>
                <input type="text" id="phone" name="cusContactNumber" pattern="[0-9]{10}" ><br><br>
                <label><b>Password</b> <span class="err-msg"><%=(passFormatErr != null ? passFormatErr : "")%></span></label><br>
                <input type="password" id="password" name="cusPass" ><br><br>
                <label><b>Confirm Password</b> <span class="err-msg"><%=(confirmPassErr != null ? confirmPassErr : "")%></span></label><br>
                <input type="password" id="cpassword" name="cusConfirmPass" ><br><br>
                <input type="submit" value="Register">
            </form>
        </div>
                
    </body>
</html>