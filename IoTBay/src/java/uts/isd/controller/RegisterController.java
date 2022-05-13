/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author salmon
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession();
                DBManager manager = (DBManager) session.getAttribute("manager");
                Validator validate = new Validator();
                String cusFName = request.getParameter("cusFName"); 
                String cusLName = request.getParameter("cusLName");
                String cusEmailAddress = request.getParameter("cusEmailAddress");
                /* add all attribtues from register form
                
                */
                if(validate.validateEmail(cusEmailAddress)){
                    /* if true then go ahead
                    else return error of invalid format
                    */
                    else
                }
                if(validate.validateName(cusFName)){
                    else 
                }
                if(validate.validateName(cusLName)){
                    else 
                }
                if(validate.validatePassword(cusPass)){
                    else 
                }
                /*
                check if in customer database
                */
                try {
                    
                }
        
    }


}
