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
        <link href="./css/vieworder.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Confirm Payment Details - IoTBay</title>
    </head>

    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="main.jsp"><h3>IoTBay</h3></a>
                </div>

                <%
                    Customer customer = (Customer) session.getAttribute("customer");
                %>
                <div class="header-end">
                    <div class="user-info header-button">
                        <a><i class="fa fa-user-circle"></i> Hello, <%=customer.getCusFName()%></a>
                        <div class="user-menu">
                            <a class="header-button" href="edituser.jsp">Edit Account</a>
                            <a class="header-button" href="ViewOrdersController">My Orders</a>
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
        <div class="page-content">
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
                    ArrayList<Payment> paymentDetails = (ArrayList<Payment>)session.getAttribute("paymentDetails");
                    for (Payment pay: paymentDetails)
                %>
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
            </table>
            <a href="updatepayment.jsp">Update Payment Details</a>
            <a href="DeletePaymentController">Delete Payment Details</a>
            <a href="paymenthistory.jsp">Submit Payment Details</a>
        </div>
    </main>
</html>
