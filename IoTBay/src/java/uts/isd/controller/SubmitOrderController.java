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
import uts.isd.model.CartLine;
import uts.isd.model.Customer;
import uts.isd.model.Order;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class SubmitOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int cartID = Integer.valueOf(request.getParameter("cartID"));
        Customer customer = (Customer) session.getAttribute("customer");
        int customerID = customer.getCustomerID();
        session.removeAttribute("activeOrderMsg");
        session.removeAttribute("orderUpdate");
        session.removeAttribute("submittedOrderMsg");
        session.removeAttribute("cancelledOrderMsg");
        try {
            ArrayList<CartLine> cartList = manager.fetchCartItems(cartID);
            for (CartLine cl: cartList) {
                if (!manager.checkItemStock(cl.getProductID())) {
                    session.setAttribute("outOfStockErr", cl.getProductName() + " is out of stock");
                    request.getRequestDispatcher("ViewCartController?cartID=" + cartID).include(request, response);
                } else if (!manager.checkSelectedQuantity(cl.getProductID(), cl.getQuantity())) {
                    session.setAttribute("selectQuantityErr", "There are " + cl.getQuantityAvailable() + " " + cl.getProductName() + " available. You have selected " + cl.getQuantity());
                    request.getRequestDispatcher("ViewCartController?cartID=" + cartID).include(request, response);
                }  
            }

            Order submittedOrder = manager.findOrder(cartID);
            Order newActiveOrder = manager.createOrder(customerID);
            manager.submitOrder(submittedOrder.getOrderID());

            session.setAttribute("submittedOrderMsg", "Order " + submittedOrder.getOrderID() + " has been submitted");
            session.setAttribute("activeOrder", newActiveOrder);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }

        request.getRequestDispatcher("ViewOrdersController").include(request, response);
    }

}
