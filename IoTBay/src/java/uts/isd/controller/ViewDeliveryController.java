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
import uts.isd.model.Shipping;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Minh Quan Tran
 */
public class ViewDeliveryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int orderID = Integer.valueOf(request.getParameter("orderID"));
        
        try {
            Shipping shipping = (Shipping) manager.findShipping(orderID);
            session.setAttribute("viewedShipping", shipping);
            
            request.getRequestDispatcher("delivery.jsp").include(request, response); 
        } catch (SQLException ex) {
            Logger.getLogger(ViewDeliveryController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception is: " + ex);
        }
    }
}
