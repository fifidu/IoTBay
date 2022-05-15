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
import uts.isd.model.Order;
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class UpdateOrderItemController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Product editProduct = (Product) session.getAttribute("editProduct");
        Order activeOrder = (Order) session.getAttribute("activeOrder");
        int updatedQuantity = Integer.valueOf(request.getParameter("updatedQuantity"));
        session.removeAttribute("updatedQuantityMsg");

        try {
            manager.updateOrderItemQuantity(activeOrder.getCartID(), editProduct.getProductID(), updatedQuantity);
            session.setAttribute("updatedQuantityMsg", editProduct.getProductName() + " was updated with Quantity " + updatedQuantity);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }

        request.getRequestDispatcher("updatecartitem.jsp").include(request, response);
    }
}
