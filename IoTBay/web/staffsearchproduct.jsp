<%@page import="uts.isd.model.Staff"%>
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
                    <a class="header-button" href="FetchProductsController"><h3>IoTBay</h3></a>
                </div>

                <div class="header-center">
                    <form id="searchForm" action="FindProductController" method="get">
                        <input id="search" type="text" name="search-query" placeholder="Search"/>
                    </form>
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
            <nav>
                <a class="nav-item" href="FetchProductsController">See all products</a>
                <a class="nav-item" href="staffcreateproduct.jsp">Add a new product</a>
            </nav>
            <div class="page-content">
                <h1 class="title">Device Catalogue</h1>
                <table>
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Type</th>
                        <th>Product Supplier</th>
                        <th>Product Description</th>
                        <th>Product Cost</th>
                        <th>Quantity Available</th>
                        <th>Edit Product Details</th>
                        <th>Delete Product</th>
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
                           <td><a href="UpdateProductController?productID=<%=prod.getProductID()%>">View</a></td>
                           <td><a href="DeleteProductController?productID=<%=prod.getProductID()%>">Delete</a></td>
                       </tr>
                    <%}%>
                </table>
            </div>
        </main>
    </body>

</html>