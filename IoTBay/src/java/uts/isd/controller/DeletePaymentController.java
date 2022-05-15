/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author sr
 */
public class DeletePaymentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        try {
            manager.deletePayment(paymentID);
            session.setAttribute("paymentDelSuccess", "Successfully deleted payment details");
            request.getRequestDispatcher("confirmpayment.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(DeletePaymentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Payment details were not deleted due to: " + ex);
        }
    }
}
