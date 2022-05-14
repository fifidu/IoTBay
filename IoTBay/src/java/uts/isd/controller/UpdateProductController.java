/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author fifidu
 */
public class UpdateProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        validator.clearProduct(session);
        String prodID = request.getParameter("prodID");
        String prodName = request.getParameter("prodName");
        String prodType = request.getParameter("prodType");
        String prodSupplier = request.getParameter("prodSupplier");
        String prodDescription = request.getParameter("prodDescription");
        String prodCost = request.getParameter("prodCost");
        String quantAvailable = request.getParameter("quantAvailable");
        DBManager manager = (DBManager) session.getAttribute("manager");
    
        if (!validator.validateCost(prodCost)) {
            session.setAttribute("prodCostFormatErr", "Incorrect Product Cost Format");
            request.getRequestDispatcher("staffeditproduct.jsp").include(request, response);
        }
        else if (!validator.validateID(quantAvailable)) {
                session.setAttribute("prodQuantityFormatErr", "Incorrect Product Quantity Format");
                request.getRequestDispatcher("staffeditproduct.jsp").include(request, response);
        }
        else {
            try {
                int intProdID = Integer.parseInt(prodID);
                double doubleProdCost = Double.parseDouble(prodCost);
                int intQuantAvailable = Integer.parseInt(quantAvailable);
                Product product = new Product(intProdID, prodName, prodType, prodSupplier, prodDescription, doubleProdCost, intQuantAvailable);
                session.setAttribute("product", product);
                manager.updateProduct(intProdID, prodName, prodType, prodSupplier, prodDescription, doubleProdCost, intQuantAvailable);
                session.setAttribute("prodEditSuccess", "Product successfully updated!");
                request.getRequestDispatcher("staffeditproduct.jsp").include(request, response);
            }    
            catch (SQLException ex) {
                Logger.getLogger(CreateProductController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Product update failed with error: " + ex);
            }
        }
    }
}
