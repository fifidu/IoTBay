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
 * @author chrisvuong
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        validator.clear(session);
        Customer customer = null;

        String cusEmailAddress = request.getParameter("cusEmailAddress");
        String cusPass = request.getParameter("cusPass");

        if (!validator.validateEmail(cusEmailAddress)) {
            session.setAttribute("emailFormatErr", "Incorrect Email Format");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                customer = manager.findCustomer(cusEmailAddress, cusPass);
                if (!manager.checkCustomer(cusEmailAddress)) {
                    session.setAttribute("unregisteredErr", "Email address is already used");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                } else if (customer != null) {
                    session.setAttribute("customer", customer);
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                } else {
                    session.setAttribute("incorrectPassErr", "Incorrect Password");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
        } catch (SQLException ex) {
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception is: " + ex);
            }
        }
    }

}
