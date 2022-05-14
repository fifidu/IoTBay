/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author fifidu
 */
public class EditProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        validator.clearProduct(session);
        int productID = Integer.valueOf(request.getParameter("productID"));
        DBManager manager = (DBManager) session.getAttribute("manager");
    
        try {
            Product productToEdit = manager.getIndividualProduct(productID);
            session.setAttribute("productToEdit", productToEdit);
            request.getRequestDispatcher("staffeditproduct.jsp").include(request, response);
        }
        catch (SQLException ex) {
            Logger.getLogger(CreateProductController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Product update failed with error: " + ex);
        }
    }
}
