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
public class FetchProductsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        try {
            ArrayList<Product> productList = manager.fetchProducts();
            session.setAttribute("productList", productList);
        }
        catch (SQLException sqled) {
            //insert line to post error to website
            Logger.getLogger(FetchProductsController.class.getName()).log(Level.SEVERE, null, sqled);
            System.out.println("Fetch failed with error: " + sqled);
        }
        request.getRequestDispatcher("staffmain.jsp").include(request, response);
    }
}