/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

public class SearchPaymentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String searched = request.getParameter("search-query");

        try {
            ArrayList<Payment> paymentHistory = manager.searchPaymentRecordsDate(searched);
            session.setAttribute("paymentHistory", paymentHistory);
        }
        catch (SQLException sqled) {
            Logger.getLogger(ViewPaymentHistoryController.class.getName()).log(Level.SEVERE, null, sqled);
            System.out.println("Search failed with error: " + sqled);
        }
        request.getRequestDispatcher("paymenthistory.jsp").include(request, response);
    }
}