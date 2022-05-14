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
public class FindProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String searched = request.getParameter("search-query");

        try {
            ArrayList<Product> productList = manager.findProduct(searched);
            session.setAttribute("productList", productList);
        }
        catch (SQLException sqled) {
            Logger.getLogger(FindProductController.class.getName()).log(Level.SEVERE, null, sqled);
            System.out.println("Search failed with error: " + sqled);
        }
        request.getRequestDispatcher("staffsearchproduct.jsp").include(request, response);
    }
}
