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
import uts.isd.model.Customer;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Tammihn
 */
public class EditCustomerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        validator.clear(session);
        Customer customer = (Customer) session.getAttribute("customer");
        
        int customerID = customer.getCustomerID();
        String cusFName = request.getParameter("cusFName");
        String cusLName = request.getParameter("cusLName");
        String cusEmailAddress = request.getParameter("cusEmailAddress");
        String cusPass = request.getParameter("cusPass");
        String cusConfirmPass = request.getParameter("cusConfirmPass");
        String cusContactNumber = request.getParameter("cusContactNumber");

        if (!validator.validateEmail(cusEmailAddress)) {
            session.setAttribute("emailFormatErr", "Incorrect Email Format");
            request.getRequestDispatcher("editcustomer.jsp").include(request, response);
        } else if (!validator.validatePassword(cusPass)) {
            session.setAttribute("passFormatErr", "Incorrect Password Format");
            request.getRequestDispatcher("editcustomer.jsp").include(request, response);
        } else if (!cusPass.equals(cusConfirmPass)) {
            session.setAttribute("confirmPassErr", "Passwords are not the same");
            request.getRequestDispatcher("editcustomer.jsp").include(request, response);
        } else if (!validator.validateName(cusFName)) {
            session.setAttribute("nameFormatErr", "Incorrect Name Format");
            request.getRequestDispatcher("editcustomer.jsp").include(request, response);
        } else if (!validator.validateName(cusLName)) {
            session.setAttribute("nameFormatErr", "Incorrect Name Format");
            request.getRequestDispatcher("editcustomer.jsp").include(request, response);        
        } else if (!validator.validateContactNumber(cusContactNumber)) {
            session.setAttribute("contactFormatErr", "Incorrect Contact Number Format");
            request.getRequestDispatcher("editcustomer.jsp").include(request, response);
        } else {
            try {
                if (!customer.getCusEmailAddress().equals(cusEmailAddress)) {
                    if (manager.checkCustomer(cusEmailAddress)) {
                        session.setAttribute("existingAccountErr", "Email address is already used for an account");
                        request.getRequestDispatcher("editcustomer.jsp").include(request, response);
                    } else {
                        customer = manager.updateCustomer(customerID, cusFName, cusLName, cusEmailAddress, cusPass, cusContactNumber);
                        session.setAttribute("customer", customer);
                        request.getRequestDispatcher("viewcustomer.jsp").include(request, response);
                    }
                } else {
                        customer = manager.updateCustomer(customerID, cusFName, cusLName, cusEmailAddress, cusPass, cusContactNumber);
                        session.setAttribute("customer", customer);
                        request.getRequestDispatcher("viewcustomer.jsp").include(request, response);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception is: " + ex);
            }
        }
    }

}
