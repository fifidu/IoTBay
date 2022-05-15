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
        <link href="./css/editaccount.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <title>Edit Customer - IoTBay</title>
    </head>
    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="index.jsp"><h3>IoTBay</h3></a>
                </div>
                <%
                Customer customer = (Customer) session.getAttribute("customer");
                %>
                <div class="header-end">
                    <div class="user-info header-button">
                        <a><i class="fa fa-user-circle"></i> Hello, <%=customer.getCusFName()%></a>
                        <div class="user-menu">
                            <a class="header-button" href="viewcustomer.jsp">Account Details</a>
                            <a class="header-button" href="ViewOrdersController">My Orders</a>
                            <a class="header-button" href="logout.jsp">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="header-outline"></div>
        </header>
        
        <div class="page-content">
        <%
        String emailFormatErr = (String) session.getAttribute("emailFormatErr");
        String passFormatErr = (String) session.getAttribute("passFormatErr");
        String confirmPassErr = (String) session.getAttribute("confirmPassErr");
        String nameFormatErr = (String) session.getAttribute("nameFormatErr");
        String contactFormatErr = (String) session.getAttribute("contactFormatErr");
        String existingAccountErr = (String) session.getAttribute("existingAccountErr");
        %>
        <div class="page-content">
            <form action="EditCustomerController" method="post">
                <h2 class="title">Edit Account Details</h2> <br>
                <p><span class="err-msg"><%=(existingAccountErr != null ? existingAccountErr : "")%></span></p>
                <label><b>First Name</b> <span class="err-msg"><%=(nameFormatErr != null ? nameFormatErr : "")%></span></label><br>
                <input type="text" id="fname" name="cusFName" ><br><br>
                <label><b>Last Name</b> <span class="err-msg"><%=(nameFormatErr != null ? nameFormatErr : "")%></span></label><br>
                <input type="text" id="lname" name="cusLName" ><br><br>
                <label><b>Email</b> <span class="err-msg"><%=(emailFormatErr != null ? emailFormatErr : "")%></span></label><br>
                <input type="text" id="email" name="cusEmailAddress" value="<%=customer.getCusEmailAddress()%>" readonly><br><br>
                <label><b>Phone Number</b> <span class="err-msg"><%=(contactFormatErr != null ? contactFormatErr : "")%></span></label><br>
                <input type="text" id="phone" name="cusContactNumber" pattern="[0-9]{10}" ><br><br>
                <label><b>Password</b> <span class="err-msg"><%=(passFormatErr != null ? passFormatErr : "")%></span></label><br>
                <input type="password" id="password" name="cusPass" ><br><br>
                <label><b>Confirm Password</b> <span class="err-msg"><%=(confirmPassErr != null ? confirmPassErr : "")%></span></label><br>
                <input type="password" id="cpassword" name="cusConfirmPass" ><br><br>
                <input type="submit" value="Submit">
            </form>
        </div>      
        </div>
        
    </body>
</html>