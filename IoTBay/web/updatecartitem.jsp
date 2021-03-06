<%-- 
    Document   : viewproduct
    Created on : 13/05/2022, 16:00:00 PM
    Author     : chrisvuong
--%>
<%@page import="uts.isd.model.Product"%>
<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/viewproduct.css" rel="stylesheet" type="text/css" >
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
<%
String updatedQuantityMsg = (String) session.getAttribute("updatedQuantityMsg");
%>
        <main>
            <nav>
                <a class="nav-item">Product</a>
            </nav>
            <div class="page-content">
                <h1 class="title">Update Product</h1>                    
                <% Product editProduct = (Product) session.getAttribute("editProduct"); %>
                <p><%=(updatedQuantityMsg != null ? updatedQuantityMsg : "")%></p>
                <div>
                    <ul>
                        <li><a class="red-button" href="RemoveOrderItemController?productID=<%=editProduct.getProductID()%>">Remove Item</a></li>
                    </ul>
                </div>
                <table class="center">
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Description</th>
                        <th>Product Cost</th>
                    </tr>

                       <tr>
                           <td><%=editProduct.getProductID()%></td>
                           <td><%=editProduct.getProductName()%></td>
                           <td><%=editProduct.getProductDescription()%></td>
                           <td>$<%=editProduct.getProductCost()%></td>
                       </tr>
                </table>
                <div class="second-content">
                    <form action="UpdateOrderItemController" method="post">
                        <label><b>Quantity</b> <span class="err-msg"></span></label><br>
                        <input type="number" id="updatedQuantity" name="updatedQuantity" value="<%=session.getAttribute("editQuantity")%>"><br><br>
                        <input type="submit" value="Edit Quantity">
                    </form>

                </div>
            </div>
        </main>
    </body>

</html>