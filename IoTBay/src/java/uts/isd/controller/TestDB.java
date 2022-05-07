/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;

/**
 *
 * @author chrisvuong
 */
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.*;
import uts.isd.model.dao.DBManager;


public class TestDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
 
    public static void main(String[] args) throws SQLException {

    }

    public TestDB() {
        try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readDBChoice() {
        System.out.print("Operation CRUDS OR * to return: ");
        return in.nextLine().charAt(0);
    }

    private String readChoice() {
        System.out.print("Choose Table OR * to exit: ");
        return in.nextLine();
    }

    private void runQueries() throws SQLException {
        String s;
        while ((s = readChoice()) != "*") {
            switch (s) {
                case "cart":
                    cartQueries();
                case "cartline":
                    cartLineQueries();
                case "customer":
                    customerQueries();
                case "orders":
                    ordersQueries();
                case "payment":
                    paymentQueries();
                case "product":
                    productQueries();
                case "shipping":
                    shippingQueries();
                case "staff":
                    staffQueries();
                default:
                    System.out.println("Unknown Command");
            }
        }
    }

    private void cartQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                    testCreateCart();
                case 'R':
                    testShowCustomerCarts();
                case 'D':
                    testDeleteCart();
                case 'S':
                    testShowAllCarts();
                default:
                    System.out.println("Unknown Command");
            }
        }
    }

    private void testCreateCart() {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.createCart(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("New Cart for Customer ID " + customerID + " has been created");
    }
    
    private void testShowCustomerCarts() {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.showCustomerCarts(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testDeleteCart() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        
        try {
            db.deleteCart(cartID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cart " + cartID + " has been deleted");
    }

    private void testShowAllCarts() {
        try {
            db.showAllCarts();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cartLineQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }

    private void customerQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }

    private void ordersQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }

    private void paymentQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }

    private void productQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }

    private void shippingQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }

    private void staffQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                case 'R':
                case 'U':
                case 'D':
                case 'S':
                default:
            }
        }
    }
}
