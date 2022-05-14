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
public class CreateProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        validator.clearProduct(session);

        String prodID = request.getParameter("prodID");
        String prodName = request.getParameter("prodName");
        String prodType = request.getParameter("prodType");
        String prodSupplier = request.getParameter("prodSupplier");
        String prodDescription = request.getParameter("prodDescription");
        String prodCost = request.getParameter("prodCost");
        String quantAvailable = request.getParameter("quantAvailable");

        if (!validator.validateID(prodID)) {
            session.setAttribute("prodIDFormatErr", "Incorrect ProductID Format");
            request.getRequestDispatcher("staffcreateproduct.jsp").include(request, response);
        }
        else if (!validator.validateCost(prodCost)) {
            session.setAttribute("prodCostFormatErr", "Incorrect Product Cost Format");
            request.getRequestDispatcher("staffcreateproduct.jsp").include(request, response);
        }
        else if (!validator.validateID(quantAvailable)) {
            session.setAttribute("prodQuantityFormatErr", "Incorrect Product Quantity Format");
            request.getRequestDispatcher("staffcreateproduct.jsp").include(request, response);
        }
        else {
            try {
                int intProdID = Integer.parseInt(prodID);
                double doubleProdCost = Double.parseDouble(prodCost);
                int intQuantAvailable = Integer.parseInt(quantAvailable);
                if (manager.checkProduct(intProdID)) {
                    session.setAttribute("existingProductErr", "A product with this ID already exists");
                }
                else {
                    manager.createProduct(intProdID, prodName, prodType, prodSupplier, prodDescription, doubleProdCost, intQuantAvailable);
                    request.getRequestDispatcher("FetchProductsController").include(request, response);
                }
            }
            catch (SQLException sqled) {
                Logger.getLogger(CreateProductController.class.getName()).log(Level.SEVERE, null, sqled);
                System.out.println("Product creation failed with error: " + sqled);
            }
        }
//        request.getRequestDispatcher("staffcreateproduct.jsp").include(request, response);
    }
}
