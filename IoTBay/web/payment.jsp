<%-- 
    Document   : payment
    Created on : 15/05/2022, 3:24:54 AM
    Author     : sr
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page import="uts.isd.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/payment.css" rel="stylesheet" type="text/css" >
        <link href="./css/header.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Enter Payment Details - IoTBay</title>
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
                
        <main> 
            <%
                String existingPaymentErr = (String) session.getAttribute("existingPaymentErr");
                String payIDFormatErr = (String) session.getAttribute("payIDFormatErr");
                String ordIDFormatErr = (String) session.getAttribute("ordIDFormatErr");
                String cusIDFormatErr = (String) session.getAttribute("cusIDFormatErr");
                String cardNoFormatErr = (String) session.getAttribute("cardNoFormatErr");
                String cardNameFormatErr = (String) session.getAttribute("cardNameFormatErr");
                String cardExpFormatErr = (String) session.getAttribute("cardExpFormatErr");
                String cvvFormatErr = (String) session.getAttribute("cvvFormatErr");
                String payDateFormatErr = (String) session.getAttribute("payDateFormatErr");
            %>
            <div class="content">
                <form class="create-payment-form" method="post" action="CreatePaymentController">
                    <caption><h3>Enter your payment details</h3></caption><br>
                    <p><span class="err-msg"> <%=(existingPaymentErr != null ? existingPaymentErr : "")%></span></p>
                    <label for="payid"><b>Payment ID</b> <span class="err-msg"> <%=(payIDFormatErr != null ? payIDFormatErr : "")%></span></label><br>
                    <input class="create-payment-form-input" type="number" id="payid" name="payID"><br><br>
                    <label for="ordid"><b>Order ID</b> <span class="err-msg"> <%=(ordIDFormatErr != null ? ordIDFormatErr : "")%></span></label><br>
                    <input class="create-payment-form-input" type="number" id="ordid" name="ordID"><br><br>
                    <label for="cusid"><b>Customer ID</b> <span class="err-msg"> <%=(cusIDFormatErr != null ? cusIDFormatErr : "")%></span></label><br>
                    <input class="create-payment-form-input" type="number" id="cusid" name="cusID"><br><br>
                    <label for="cardno"><b>Card Number</b> <span class="err-msg"> <%=(cardNoFormatErr != null ? cardNoFormatErr : "")%></span></label><br>
                    <input class="create-payment-form-input" type="number" id="cardno" name="cardNo"><br><br>
                    <label for="cardname"><b>Card Name</b> <span class="err-msg"> <%=(cardNameFormatErr != null ? cardNameFormatErr : "")%></span></label><br>
                    <input class="create-payment-form-input" type="text" id="cardname" name="cardName"><br><br>
                    <label for="cardexp"><b>Card Expiry</b> <span class="err-msg"> <%=(cardExpFormatErr != null ? cardExpFormatErr : "")%></span></label><br>
                    <input class="create-payment-form-input" type="date" id="cardexp" name="cardExp"><br><br>
                    <label for="cvv"><b>CVV</b></label> <span class="err-msg"> <%=(cvvFormatErr != null ? cvvFormatErr : "")%></span><br>
                    <input class="create-payment-form-input" type="number" id="cvv" name="cvv"><br><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </main>
    </body>
    
</html>
