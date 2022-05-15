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
import uts.isd.model.Customer;
import uts.isd.model.Order;
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class AddToOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        int quantity = Integer.valueOf(request.getParameter("selectedQuantity"));
        Product activeProduct = (Product) session.getAttribute("activeProduct");
        int quantityAvailable = activeProduct.getQuantityAvailable();
        Order activeOrder = (Order) session.getAttribute("activeOrder");
        Customer customer = (Customer) session.getAttribute("customer");

        session.removeAttribute("addToOrderUpdate");

        try {
            if (activeOrder == null) {
                Order newOrder = manager.createOrder(customer.getCustomerID());
                session.setAttribute("activeOrder", newOrder);
                activeOrder = (Order) session.getAttribute("activeOrder");
            }
            if (quantityAvailable == 0) {
                session.setAttribute("addToOrderUpdate", "Item is currently sold out");
                request.getRequestDispatcher("viewproduct.jsp").include(request, response);
            } else if (quantity > quantityAvailable) {
                session.setAttribute("addToOrderUpdate", "Quantity selected is higher than product availability: Quantity Available = " + activeProduct.getQuantityAvailable());
                request.getRequestDispatcher("viewproduct.jsp").include(request, response);
            } else if (manager.checkItemInCart(activeOrder.getCartID(), activeProduct.getProductID())){
                manager.addQuantityToExistingItem(activeOrder.getCartID(), activeProduct.getProductID(), quantity);
                session.setAttribute("addToOrderUpdate", activeProduct.getProductName() + " with Quantity " + quantity + " has been added to Order " + activeOrder.getOrderID());
                request.getRequestDispatcher("viewproduct.jsp").include(request, response);
            } else {
                manager.addOrderItem(activeOrder.getCartID(), activeProduct.getProductID(), quantity);
                session.setAttribute("addToOrderUpdate", activeProduct.getProductName() + " with Quantity " + quantity + " has been added to Order " + activeOrder.getOrderID());
                request.getRequestDispatcher("viewproduct.jsp").include(request, response);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);}
        }
}
