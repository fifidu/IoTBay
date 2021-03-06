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
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class RemoveOrderItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        Order activeOrder = (Order) session.getAttribute("activeOrder");
        int productID = Integer.valueOf(request.getParameter("productID"));
        session.removeAttribute("viewOrderPageUpdate");
        try {
            Product removedProduct = manager.fetchIndividualProduct(productID);
            manager.deleteOrderItem(activeOrder.getCartID(), productID);
            session.setAttribute("viewOrderPageUpdate", removedProduct.getProductName() + " was removed from Order " + activeOrder.getOrderID());
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }

        request.getRequestDispatcher("ViewCartController?cartID=" + activeOrder.getCartID()).include(request, response);
    }


}
