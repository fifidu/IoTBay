<%-- 
    Document   : shipping
    Created on : 14 May 2022, 6:50:41 pm
    Author     : someo
--%>
<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/shipping.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Shipping - IoTBay</title>
    </head>
    <body>
        <header>
            <div class="header-content">
                <div class="header-start">
                    <a class="header-button" href="ShowProductsController"><h3>IoTBay</h3></a>
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
            <form action="ShippingController" method="post">
                <h1>Shipment details</h1>
                <hr />
                <label>Shipment Methods</label>
                <ul id="shipment-method">
                    <li>
                        <input type="radio" id="aup" name="shipment-method" value="AUP" required>
                        <label for="aup">Australia Post (12-15 working days)</label>
                    </li>
                    <li>
                        <input type="radio" id="dhl" name="shipment-method" value="DHL" required>
                        <label for="dhl">DHL (2-5 working days)</label>
                    </li>
                    <li>
                        <input type="radio" id="fdx" name="shipment-method" value="FDX" required>
                        <label for="fdx">FedEX (3-7 working days)</label>
                    </li>
                </ul>
                <hr />
                <label>Delivery Address</label>
                <div id="address" class="address">
                    <label for="street">Street</label>
                    <input type="text" id="street" name="street" required>
                    <label for="city">City</label>
                    <input type="text" id="city" name="city" required>
                    <label for="state">State</label>
                    <input type="text" id="state" name="state" required>
                    <label for="country">Country</label>
                    <input type="text" id="country" name="country" required>
                    <label for="postal">Postal Code</label>
                    <input type="text" id="postal" name="postal" required>
                </div>
                <hr />
                <button type="submit">Proceed to Checkout</button>
            </form>
        </main>
    </body>
</html>
