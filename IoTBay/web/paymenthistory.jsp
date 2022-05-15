<%-- 
    Document   : paymenthistory
    Created on : 15/05/2022, 6:16:47 AM
    Author     : sr
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page import="uts.isd.model.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/paymenthistory.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>View Payment History - IoTBay</title>
    </head>
    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="ShowProductsController"><h3>IoTBay</h3></a>
                </div>
                <div class="header-center">
                    <form id="searchForm" action="SearchPaymentsController" method="get">
                        <input id="search" type="text" name="search-query" placeholder="Search"/>
                    </form>
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
        <nav>
            <a class="nav-item" href="ViewPaymentHistoryController">Payment History</a>
        </nav>
        <div class="page-content">
            <h1 class="title">Payment History</h1>
            <table>
                <tr>
                    <th>Payment ID</th>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Card Number</th>
                    <th>Card Name</th>
                    <th>Card Expiry Date</th>
                    <th>CVV</th>
                    <th>Payment Date</th>
                </tr>
                <% 
                    ArrayList<Payment> paymentHistory = (ArrayList<Payment>) session.getAttribute("paymentHistory");
                    for (Payment pay: paymentHistory) { %>
                        <tr>
                            <td><%=pay.getPaymentID()%></td>
                            <td><%=pay.getOrderID()%></td>
                            <td><%=pay.getCustomerID()%></td>
                            <td><%=pay.getCardNumber()%></td>
                            <td><%=pay.getCardName()%></td>
                            <td><%=pay.getCardExpiry()%></td>
                            <td><%=pay.getCvv()%></td>
                            <td><%=pay.getPaymentDate()%></td>
                        </tr>
                    <%}%>
            </table>
        </div>
    </main>
</html>
