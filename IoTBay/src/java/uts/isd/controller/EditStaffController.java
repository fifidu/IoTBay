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
import uts.isd.model.Staff;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author Tammihn
 */
public class EditStaffController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        validator.clear(session);
        Staff staff = (Staff) session.getAttribute("staff");
        
        int staffID = staff.getStaffID();
        String staffFName = request.getParameter("staffFName");
        String staffLName = request.getParameter("staffLName");
        String staffEmailAddress = request.getParameter("staffEmailAddress");
        String staffPass = request.getParameter("staffPass");
        String staffConfirmPass = request.getParameter("staffConfirmPass");
        String staffContactNumber = request.getParameter("staffContactNumber");

        if (!validator.validateEmail(staffEmailAddress)) {
            session.setAttribute("emailFormatErr", "Incorrect Email Format");
            request.getRequestDispatcher("editstaff.jsp").include(request, response);
        } else if (!validator.validatePassword(staffPass)) {
            session.setAttribute("passFormatErr", "Incorrect Password Format");
            request.getRequestDispatcher("editstaff.jsp").include(request, response);
        } else if (!staffPass.equals(staffConfirmPass)) {
            session.setAttribute("confirmPassErr", "Passwords are not the same");
            request.getRequestDispatcher("editstaff.jsp").include(request, response);
        } else if (!validator.validateName(staffFName)) {
            session.setAttribute("nameFormatErr", "Incorrect Name Format");
            request.getRequestDispatcher("editstaff.jsp").include(request, response);
        } else if (!validator.validateName(staffLName)) {
            session.setAttribute("nameFormatErr", "Incorrect Name Format");
            request.getRequestDispatcher("editstaff.jsp").include(request, response);        
        } else if (!validator.validateContactNumber(staffContactNumber)) {
            session.setAttribute("contactFormatErr", "Incorrect Contact Number Format");
            request.getRequestDispatcher("editstaff.jsp").include(request, response);
        } else {
            try {
                if (!staff.getStaffEmailAddress().equals(staffEmailAddress)) {
                    if (manager.checkCustomer(staffEmailAddress)) {
                        session.setAttribute("existingAccountErr", "Email address is already used for an account");
                        request.getRequestDispatcher("editstaff.jsp").include(request, response);
                    } else {
                        staff = manager.updateStaff(staffID, staffFName, staffLName, staffEmailAddress, staffPass, staffContactNumber);
                        session.setAttribute("staff", staff);
                        request.getRequestDispatcher("viewstaff.jsp").include(request, response);
                    }
                } else {
                        staff = manager.updateStaff(staffID, staffFName, staffLName, staffEmailAddress, staffPass, staffContactNumber);
                        session.setAttribute("staff", staff);
                        request.getRequestDispatcher("viewstaff.jsp").include(request, response);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception is: " + ex);
            }
        }
    }

}

