<%-- 
    Document   : orders
    Created on : 23/04/2022, 10:21:27 PM
    Author     : chrisvuong
--%>
<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/orders.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Orders - IoTBay</title>
    </head>

    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="ShowProductsController"><h3>IoTBay</h3></a>
                </div>

                <div class="header-center">
                    <form id="searchForm" action="">
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
                            <a class="header-button" href="edituser.jsp">Edit Account</a>
                            <a class="header-button" href="ViewOrdersController">My Orders</a>
                            <a class="header-button" href="logout.jsp">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="header-outline"></div>
        </header>
<%
    String orderPageUpdate = (String) session.getAttribute("orderPageUpdate");
%>
        <main>
            <nav>
                <a class="nav-item">Product</a>
            </nav>
            <div class="page-content">
                <h1 class="title">Orders</h1>
                <p><%=(orderPageUpdate != null ? orderPageUpdate : "")%></p>
                <div>
                    <ul>
                        <li><a href="CreateOrderController?customerID=<%=customer.getCustomerID()%>">Create Order</a></li>
                        <li><a href="ShowProductsController">Return to Home</a></li>
                    </ul>
                </div>
                <table class="center">
                    <tr>
                        <th>Order ID</th>
                        <th>Order Date</th>
                        <th>Order Status</th>
                        <th>Total Cost</th>
                        <th></th>
                    </tr>
                    <% ArrayList<Order> orderList = (ArrayList<Order>)session.getAttribute("orderList");
                       for (Order ord: orderList) { %>
                       <tr>
                           <td><%=ord.getOrderID()%></td>
                           <td><%=ord.getOrderDate()%></td>
                           <td><%=ord.getOrderStatus()%></td>
                           <td>$<%=ord.getTotalCost()%></td>
                           <% if (ord.getOrderStatus().equals("Active")) {%>
                           <td><a href="ViewCartController?cartID=<%=ord.getCartID()%>">Edit</td>
                           <% } else {%>
                           <td><a href="ViewCartController?cartID=<%=ord.getCartID()%>">View</td>
                           <%}
                           if (ord.getOrderStatus().equals("Active") || ord.getOrderStatus().equals("Saved")) {%>
                           <td><a href="CancelOrderController?orderID=<%=ord.getOrderID()%>">Cancel</a></td>
                           <%}%>
                           <%if (ord.getOrderStatus().equals("Saved")) {%>
                           <td><a href="ChangeActiveOrderController?orderID=<%=ord.getOrderID()%>">Make Active</a></td>
                            <%}%>
                       </tr>
                    <%}%>
                </table>
            </div>
        </main>
    </body>

</html>
