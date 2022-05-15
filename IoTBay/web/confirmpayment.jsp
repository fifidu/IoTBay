<%-- 
    Document   : confirmpayment
    Created on : 15/05/2022, 4:18:58 AM
    Author     : sr
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/payment.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Confirm Payment Details - IoTBay</title>
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
    </body>
    
    <main>
        <nav>
            <a class="nav-item" href="ViewPaymentController">Saved Payment Details</a>
        </nav>
        <div class="content">
            <table class="results-table">
                <tr>
                    <th class="results-table-header">Payment ID</th>
                    <th class="results-table-header">Order ID</th>
                    <th class="results-table-header">Customer ID</th>
                    <th class="results-table-header">Card Number</th>
                    <th class="results-table-header">Card Name</th>
                    <th class="results-table-header">Card Expiry Date</th>
                    <th class="results-table-header">CVV</th>
                    <th class="results-table-header">Payment Date</th>
                </tr>
                <% 
                    Payment paymentDetails = (Payment) session.getAttribute("paymentDetails");%>
                        <tr>
                            <td><%=paymentDetails.getPaymentID()%></td>
                            <td><%=paymentDetails.getOrderID()%></td>
                            <td><%=paymentDetails.getCustomerID()%></td>
                            <td><%=paymentDetails.getCardNumber()%></td>
                            <td><%=paymentDetails.getCardName()%></td>
                            <td><%=paymentDetails.getCardExpiry()%></td>
                            <td><%=paymentDetails.getCvv()%></td>
                            <td><%=paymentDetails.getPaymentDate()%></td>
                        </tr>
            </table>
            <a href="updatepayment.jsp">Update Payment Details</a>
            <a href="DeletePaymentController">Delete Payment Details</a>
            <a href="ViewPaymentHistoryController">Submit Payment Details</a>
        </div>
    </main>
</html>
