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
        
        String action = request.getParameter("action");
        
        if (action != null){
            if (action.equals("update")){
                try {
                    Order order = manager.findOrder( Integer.parseInt(request.getParameter("order-to-update")) );
                    session.setAttribute("submittedOrder", order);

                    request.getRequestDispatcher("shipping.jsp").include(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ShippingController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Exception is: " + ex);
                }
            } else if (action.equals("delete")){
                try {
                    Shipping shipping = manager.findShipping( Integer.parseInt(request.getParameter("order-to-update")) );
                    manager.deleteShipping(shipping.getTrackingID());
                    
                    session.setAttribute("viewedShipping", null);
                    request.getRequestDispatcher("delivery.jsp").include(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ShippingController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Exception is: " + ex);
                }
            }
        } else {
            Validator validator = new Validator();
            validator.clear(session);

            String carrierCode = request.getParameter("shipment-method");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            String postal = request.getParameter("postal");
            
            boolean passed = true;

            if (!validator.validateCarrierCode(carrierCode)) {
                session.setAttribute("carrierCodeErr", "Invalid Carrier");
                passed = false;
            } 
            if (!validator.validateState(state)){
                session.setAttribute("stateErr", "Invalid State, use state code with capital letters");
                passed = false;
            } 
            if (!validator.validatePostal(postal)){
                session.setAttribute("postalErr", "Invalid Postal Code");
                passed = false;
            } 
            if (passed){
                try {
                    Order order = (Order) session.getAttribute("submittedOrder");
                    Shipping foundShipping = manager.findShipping(order.getCartID());
                    if (foundShipping != null){
                        foundShipping.setCarrierCode(carrierCode);
                        foundShipping.setAddressStreet(street);
                        foundShipping.setAddressCity(city);
                        foundShipping.setAddressState(state);
                        foundShipping.setAddressCountry(country);
                        foundShipping.setAddressPostal(postal);
                        manager.updateShipping(foundShipping);
                        session.setAttribute("viewedShipping", foundShipping);
                        request.getRequestDispatcher("delivery.jsp").include(request, response);
                    } else {
                        Shipping shipping = manager.addShipping(order.getOrderID(), carrierCode, street, city, state, country, postal);
                        session.setAttribute("activeShipping", shipping);
                        request.getRequestDispatcher("payment.jsp").include(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ShippingController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Exception is: " + ex);
                }
            } else {
                request.getRequestDispatcher("shipping.jsp").include(request, response);
            }
        }
    }
}
