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
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class ChangeActiveOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Customer customer = (Customer) session.getAttribute("customer");
        Order currentActiveOrder = (Order) session.getAttribute("activeOrder");
        int customerID = customer.getCustomerID();
        int currentActiveOrderID = currentActiveOrder.getOrderID();
        int newActiveOrderID = Integer.valueOf(request.getParameter("orderID"));
        
        session.removeAttribute("orderPageUpdate");

        try {
            manager.updateOrderStatus(currentActiveOrderID, "Saved");
            manager.updateOrderStatus(newActiveOrderID, "Active");
            Order newActiveOrder = manager.findActiveOrder(customerID);
            session.setAttribute("activeOrder", newActiveOrder);
            session.setAttribute("orderPageUpdate", "Order " + newActiveOrder.getOrderID() + " is now active");
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }

        request.getRequestDispatcher("ViewOrdersController").include(request, response);
    }


}
