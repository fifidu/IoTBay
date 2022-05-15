<%-- 
    Document   : viewuser
    Created on : 14 May 2022, 12:53:07 am
    Author     : Tammihn Ha
--%>

<%@page import="uts.isd.model.Staff"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Product"%>
<html lang="en" dir="ltr">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/viewcustomer.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>View Staff Details - IoTBay</title>
    </head>
    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="FetchProductsController"><h3>IoTBay</h3></a>
                </div>
                <%
                Staff staff = (Staff) session.getAttribute("staff");
                %>
                <div class="header-end">
                    <div class="user-info header-button">
                        <a><i class="fa fa-user-circle"></i> Hello, <%=staff.getStaffFName()%></a>
                        <div class="user-menu">
                            <a class="header-button" href="viewstaff.jsp">View Account Details</a>
                            <a class="header-button" href="logout.jsp">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="header-outline"></div>
        </header>
                        
        <main>
            <div class="page-content">
                <h3>Account Details</h3> <br><br>
                <h4>First Name: </h4><p><%=staff.getStaffFName()%></p><br>
                <h4>Last Name: </h4><p><%=staff.getStaffLName()%></p><br>
                <h4>Email Address: </h4><p><%=staff.getStaffEmailAddress()%></p><br>
                <h4>Phone Number: </h4><p><%=staff.getStaffContactNumber()%></p><br>
                <p><a class="main-link" href = "editstaff.jsp">Edit Details</a></p>
            </div>
        </main>
    </body>
</html>
