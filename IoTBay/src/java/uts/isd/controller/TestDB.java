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
    // Test Cart Database
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
        
        System.out.println("New Cart for Customer " + customerID + " has been created");
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

    // Test CartLine Database
    private void cartLineQueries() throws SQLException {
        char c;
        while ((c = readDBChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAddOrderItem();
                case 'R':
                    testShowCustomerCartItems();
                case 'U':
                    testUpdateOrderItemQuantity();
                case 'D':
                    testDeleteOrderItem();
                case 'S':
                    testShowAllCartItems();
                default:
            }
        }
    }

    private void testAddOrderItem() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        System.out.print("Product ID: ");
        int productID = in.nextInt();
        System.out.print("Quantity: ");
        int quantity = in.nextInt();
        
        try {
            db.addOrderItem(cartID, productID, quantity);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Product " + productID + " with Quantity " + quantity + " has been added to Cart " + cartID);
    }

    private void testUpdateOrderItemQuantity() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        System.out.print("Product ID: ");
        int productID = in.nextInt();
        System.out.print("Quantity: ");
        int quantity = in.nextInt();
        
        try {
            db.updateOrderItemQuantity(cartID, productID, quantity);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Product " + productID + "in Cart " + cartID + " has been updated with Quantity " + quantity);
    }

    private void testDeleteOrderItem() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        System.out.print("Product ID: ");
        int productID = in.nextInt();
        
        try {
            db.deleteOrderItem(cartID, productID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Product " + productID + "has been deleted from Cart " + cartID);
    }

    private void testShowCustomerCartItems() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        
        try {
            db.showCustomerCartItems(cartID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testShowAllCartItems() {
        try {
            db.showAllCartItems();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Test Customer Database
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
    
    // Test Orders Database
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
    
    // Test Payment Database
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
    
    // Test Product Database
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
    
    // Test Shipping Database
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
    
    // Test Staff Database
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
