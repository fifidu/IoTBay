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
import uts.isd.model.Order;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class CreateOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int customerID = Integer.valueOf(request.getParameter("customerID"));

        try {
            if (manager.checkActiveOrders(customerID)) {
                request.setAttribute("orderUpdate", "Order Creation Unsuccessful: Active Order Already Exists");
            } else {
                Order newOrder = manager.createOrder(customerID);
                request.setAttribute("activeOrder", newOrder);
                request.setAttribute("orderUpdate", "Order Created");
            }           
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }

        request.getRequestDispatcher("ViewOrdersController?customerID=" + customerID).include(request, response);
    }
}