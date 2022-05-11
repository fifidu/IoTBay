/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.CartLine;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author chrisvuong
 */
public class ViewCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String tempCartID = request.getParameter("cartID");
        int cartID = Integer.valueOf(tempCartID);
        
        try {
            ArrayList<CartLine> cartList = manager.fetchCartItems(cartID);
            request.setAttribute("cartList", cartList);
        } catch (SQLException e) {
            System.out.println("Exception is: " + e);
        }

        request.getRequestDispatcher("vieworder.jsp").include(request, response);   
    }

}
