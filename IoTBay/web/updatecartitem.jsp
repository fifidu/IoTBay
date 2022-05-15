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
                            <a class="header-button" href="edituser.jsp">Edit Account</a>
                            <a class="header-button" href="ViewOrdersController">My Orders</a>
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
                <h1 class="title">Edit Product</h1>
                <table class="center">
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Description</th>
                        <th>Product Cost</th>
                    </tr>
                    <% Product editProduct = (Product) session.getAttribute("editProduct"); %>
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
                    <a class="main-link" href="RemoveOrderItemController?productID=<%=editProduct.getProductID()%>">Remove Item</a>
                </div>
            </div>
        </main>
    </body>

</html>