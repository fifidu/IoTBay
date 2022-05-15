/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Customer;
import uts.isd.model.Order;
import uts.isd.model.Payment;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author sr
 */
public class CreatePaymentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Payment payment = null;
        validator.clear(session);
        Customer customer = (Customer) session.getAttribute("customer");
        Order submittedOrder = (Order) session.getAttribute("submittedOrder");
        
        int customerID = customer.getCustomerID();
        int orderID = submittedOrder.getOrderID();
        String cardNo = request.getParameter("cardNo");
        String cardName = request.getParameter("cardName");
        String cardExp = request.getParameter("cardExp");
        String cvv = request.getParameter("cvv");

        try {
            if (!validator.validateCardNumber(cardNo)) {
                session.setAttribute("cardNoFormatErr", "Incorrect Card Number Format - 16 numbers");
                request.getRequestDispatcher("payment.jsp").include(request, response);
            } else if (!validator.validateCardName(cardName)) {
                session.setAttribute("cardNameFormatErr", "Incorrect Card Name Format");
                request.getRequestDispatcher("payment.jsp").include(request, response);
            } else if (!validator.validatePaymentDatePattern(cardExp)) {
                session.setAttribute("cardExpFormatErr", "Incorrect Card Expiry Date Format - yyyy-mm-dd");
                request.getRequestDispatcher("payment.jsp").include(request, response);
            } else if (!validator.validateCvv(cvv)) {
                session.setAttribute("cvvFormatErr", "Incorrect CVV Format - 4 numbers");
                request.getRequestDispatcher("payment.jsp").include(request, response);
            } else {
                int intCvv = Integer.parseInt(cvv);
                Payment paymentDetails = manager.createPayment(orderID, customerID, cardNo, cardName, cardExp, intCvv);
                session.setAttribute("paymentDetails", paymentDetails);
                session.setAttribute("paymentDetailsCreated", "Payment details processed!");
                request.getRequestDispatcher("confirmpayment.jsp").include(request, response);
            }
        }  catch (SQLException | NullPointerException ex) {
            Logger.getLogger(CreatePaymentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Payment submission failed with error: " + ex);
        }
    }
}
