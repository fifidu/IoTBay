<%-- 
    Document   : staffcreateproduct
    Created on : 13/05/2022, 6:38:47 PM
    Author     : fifidu
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/staffcreateproduct.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Add a product to the catalogue - IoTBay</title>
    </head>
    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="FetchProductsController"><h3>IoTBay</h3></a>
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
                <a class="nav-item">Add a new product</a>
            </nav>
            <% 
            String prodIDFormatErr = (String) session.getAttribute("prodIDFormatErr");
            String prodCostFormatErr = (String) session.getAttribute("prodCostFormatErr");
            String prodQuantityFormatErr = (String) session.getAttribute("prodQuantityFormatErr");
            String existingProductErr = (String) session.getAttribute("existingProductErr");
            String prodCreateSuccess = (String) session.getAttribute("prodCreateSuccess");
            %>
            <div class="page-content">
                <form class="create-product-form" action="CreateProductController" method="post">
                    <caption><h3>Add a product to the catalogue</h3></caption>
                    <p><span class="success-msg"><%=(prodCreateSuccess != null ? prodCreateSuccess : "")%></span></p><br>
                    <p><span class="err-msg"><%=(existingProductErr != null ? existingProductErr : "")%></span></p><br>
                    <label><b>ProductID</b> <span class="err-msg"><%=(prodIDFormatErr != null ? prodIDFormatErr : "")%></span></label><br>
                    <input class="create-product-form-input" type="number" id="pid" name="prodID" ><br><br>
                    <label><b>Product Name</b> </label><br>
                    <input class="create-product-form-input" type="text" id="pname" name="prodName" ><br><br>
                    <label><b>Product Type</b></label><br>
                    <input class="create-product-form-input" type="text" id="ptype" name="prodType" ><br><br>
                    <label><b>Product Supplier</b></label><br>
                    <input class="create-product-form-input" type="text" id="psupp" name="prodSupplier"><br><br>
                    <label><b>Product Description</b></label><br>
                    <input class="create-product-form-input" type="text" id="pdesc" name="prodDescription" ><br><br>
                    <label><b>Product Cost</b> <span class="err-msg"><%=(prodCostFormatErr != null ? prodCostFormatErr : "")%></span></label><br>
                    <input class="create-product-form-input" type="number" step="0.01" id="pcost" name="prodCost" ><br><br>
                    <label><b>Quantity to be available</b> <span class="err-msg"><%=(prodQuantityFormatErr != null ? prodQuantityFormatErr : "")%></span></label><br>
                    <input class="create-product-form-input" type="number" id="pquant" name="quantAvailable" ><br><br>
                    <input type="submit" value="Create">
                </form>
            </div>
        </main>
    </body>
</html>
