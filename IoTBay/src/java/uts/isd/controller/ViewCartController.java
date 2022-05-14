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
import uts.isd.model.CartLine;
import uts.isd.model.Customer;
import uts.isd.model.Order;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class ViewCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int cartID = Integer.valueOf(request.getParameter("cartID"));
        
        try {
            ArrayList<CartLine> cartList = manager.fetchCartItems(cartID);
            Order viewedOrder = manager.findOrder(cartID);
            double totalCost = manager.calculateTotalCost(cartID);
            
            session.setAttribute("viewedOrder", viewedOrder);
            session.setAttribute("cartList", cartList); 
            session.setAttribute("totalCost", totalCost);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }

        request.getRequestDispatcher("vieworder.jsp").include(request, response);   
    }

}
