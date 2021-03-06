/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Payment;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author sr
 */
public class ViewPaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            ArrayList<Payment> paymentDetails = manager.viewPaymentDetails(orderID);
            session.setAttribute("paymentDetails", paymentDetails);
        }
        catch (SQLException | NullPointerException sqled) {
            Logger.getLogger(ViewPaymentController.class.getName()).log(Level.SEVERE, null, sqled);
            System.out.println("Unable to view saved payment details due to: " + sqled);
        }
        request.getRequestDispatcher("confirmpayment.jsp").include(request, response);
    }
}
