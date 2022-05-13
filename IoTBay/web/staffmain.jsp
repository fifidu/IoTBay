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
                    <a class="header-button" href="main.jsp"><h3>IoTBay</h3></a>
                </div>

                <div class="header-center">
                    <form id="searchForm" action="">
                        <input id="search" type="text" name="search-query" placeholder="Search"/>
                    </form>
                </div>

                <div class="header-end">
                    <div class="user-info header-button">
<<<<<<< Updated upstream
                        <a><i class="fa fa-user-circle"></i> Hello, </a>
=======
                        <a><i class="fa fa-user-circle"></i> Hello, <%-- <jsp:getProperty name="user" property="firstName"/> --%> </a>
>>>>>>> Stashed changes
                        <div class="user-menu">
                            <a class="header-button" href="edituser.jsp">Edit Account</a>
                            <a class="header-button" href="logout.jsp">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="header-outline"></div>
        </header>

        <main>
            <nav>
                <a class="nav-item">See all products</a>
                <a class="nav-item">Add a new product</a>
            </nav>
            <div class="content">
                <table class="device-table">
                    <caption><h3>Device Catalogue</h3></caption>
                    <tr>
                        <th class="device-table-header">ProductID</th>
                        <th class="device-table-header">Product Type</th>
                        <th class="device-table-header">Product Name</th>
                        <th class="device-table-header">Product Supplier</th>
                        <th class="device-table-header">Product Description</th>
                        <th class="device-table-header">Product Cost</th>
                        <th class="device-table-header">Quantity Available</th>
                        <th class="device-table-header"></th>
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
                           <!--<td><a href="ViewCartController?cartID=
                           <%--<%=ord.getCartID()%> --%>
                           ">Edit</td>-->
                       </tr>
                    <%}%>
                </table>
            </div>
        </main>
    </body>

</html>