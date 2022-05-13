<%-- 
    Document   : vieworder
    Created on : 30/04/2022, 3:04:06 PM
    Author     : chrisvuong
--%>

<%@page import="uts.isd.model.CartLine"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/vieworder.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>View Order - IoTBay</title>
    </head>

    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="main.jsp"><h3>IoTBay</h3></a>
                </div>

                <div class="header-center">
                    <form id="searchForm" action="">
                        <input id="search" type="text" name="search-query" placeholder="Search"/>
                    </form>
                </div>

                <div class="header-end">
                    <div class="user-info header-button">
                        <a><i class="fa fa-user-circle"></i> Hello, </a>
                        <div class="user-menu">
                            <a class="header-button" href="edituser.jsp">Edit Account</a>
                            <a class="header-button" href="ViewOrdersController?customerID=<%=1%>">My Orders</a>
                            <a class="header-button" href="logout.jsp">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="header-outline"></div>
        </header>

        <main>
            <nav>
                <a class="nav-item">Product</a>
            </nav>
            <div class="page-content">
                <h1 class="title">Cart</h1>
                <table class="center">
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Cost</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    <%  ArrayList<CartLine> cartList = (ArrayList<CartLine>)request.getAttribute("cartList");
                        if (cartList.size() != 0) {
                            for (CartLine cl: cartList) { %>
                                <tr>
                                    <td><%=cl.getProductID()%></td>
                                    <td><%=cl.getProductName()%></td>
                                    <td>$<%=cl.getProductCost()%></td>
                                    <td><%=cl.getQuantity()%></td>
                                    <td>$<%=cl.getItemTotal()%></td>
                                    <% if (cl.getOrderStatus().equals("Active")) {%>
                                    <td>Edit</td>
                                </tr>
                                    <%} 
                            }
                        }%>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Total Cost</td>
                            <td>$<%=request.getAttribute("totalCost")%></td>
                        </tr>
                </table>
            </div>
        </main>
    </body>

</html>
