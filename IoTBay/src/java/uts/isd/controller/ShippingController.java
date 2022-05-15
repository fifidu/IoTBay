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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.Shipping;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author someo
 */
public class ShippingController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        validator.clear(session);
        
        String carrierCode = request.getParameter("shipment-method");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postal = request.getParameter("postal");
        
        if (!validator.validateCarrierCode(carrierCode)) {
            session.setAttribute("carrierCodeErr", "Invalid Carrier");
            request.getRequestDispatcher("shipping.jsp").include(request, response);
        } else if (!validator.validatePostal(postal)){
            session.setAttribute("postalErr", "Invalid Postal Code");
            request.getRequestDispatcher("shipping.jsp").include(request, response);
        } else {
            try {
                Order order = (Order) session.getAttribute("activeOrder");
                Shipping shipping = manager.addShipping(order.getOrderID(), carrierCode, street, city, state, country, postal);
                session.setAttribute("activeShipping", shipping);
                request.getRequestDispatcher("welcome.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception is: " + ex);
            }
        }
    }
}
