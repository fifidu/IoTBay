<%@page import="uts.isd.model.Customer"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Product"%>
<html lang="en" dir="ltr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/main.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Store - IoTBay</title>
    </head>

    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="ShowProductsController"><h3>IoTBay</h3></a>
                </div>

                <div class="header-center">
                    <form id="searchForm" action="FindProductController" method="get">
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
                            <a class="header-button" href="viewcustomer.jsp">Account Details</a>
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
                <a class="nav-item" href="ShowProductsController">All Products</a>
            </nav>
            <div class="content">
                <table class="device-table">
                    <caption><h3>Device Catalogue</h3></caption>
                    <tr>
                        <th class="device-table-header">Product ID</th>
                        <th class="device-table-header">Product Name</th>
                        <th class="device-table-header">Product Type</th>
                        <th class="device-table-header">Product Supplier</th>
                        <th class="device-table-header">Product Description</th>
                        <th class="device-table-header">Product Cost</th>
                        <th class="device-table-header">Quantity Available</th>
                        <th class="device-table-header"></th>
                        <th></th>
                    </tr>
                    <% ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("productList");
                       for (Product prod: productList) { %>
                       <tr>
                           <td><%=prod.getProductID()%></td>
                           <td><%=prod.getProductName()%></td>
                           <td><%=prod.getProductType()%></td>
                           <td><%=prod.getProductSupplier()%></td>
                           <td><%=prod.getProductDescription()%></td>
                           <td><%=prod.getProductCost()%></td>
                           <td><%=prod.getQuantityAvailable()%></td>
                           <td><a href="ViewProductController?productID=<%=prod.getProductID()%>">View</a></td>
                       </tr>
                    <%}%>
                </table>
            </div>
        </main>
    </body>

</html>