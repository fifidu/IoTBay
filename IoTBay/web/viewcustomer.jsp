<%-- 
    Document   : viewcustomer
    Created on : 14 May 2022, 12:53:07 am
    Author     : Tammihn Ha
--%>

<%@page import="uts.isd.model.Customer"%>
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
        <title>View Customer Details - IoTBay</title>
    </head>

    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="ShowProductsController"><h3>IoTBay</h3></a>
                </div>

                <%
                Customer customer = (Customer) session.getAttribute("customer");
                %>
                <div class="header-end">
                    <div class="user-info header-button">
                        <a><i class="fa fa-user-circle"></i> Hello, <%=customer.getCusFName()%></a>
                        <div class="user-menu">
                            <a class="header-button" href="viewcustomer.jsp">View Account Details</a>
                            <a class="header-button" href="ViewOrdersController">View Orders</a>
                            <a class="header-button" href="ViewPaymentHistoryController">View Payment History</a>
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
                <h4>First Name: </h4><p><%=customer.getCusFName()%></p><br>
                <h4>Last Name: </h4><p><%=customer.getCusLName()%></p><br>
                <h4>Email Address: </h4><p><%=customer.getCusEmailAddress()%></p><br>
                <h4>Phone Number: </h4><p><%=customer.getCusContactNumber()%></p><br>
                <p><a class="main-link" href = "editcustomer.jsp">Edit Details</a></p><br>
                <p><a class="red-link" href = "deletecustomer.jsp">Delete Account</a></p>
            </div>
        </main>
    </body>

</html>
