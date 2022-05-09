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
        (new TestDB()).runQueries();
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

    private String readChoice() {
        System.out.print("Command OR * to exit: ");
        return in.nextLine();
    }

    private void runQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
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
                case "help":
                    System.out.println("cart -> cart database");
                    System.out.println("cartline -> cartline database");
                    System.out.println("customer -> customer database");
                    System.out.println("orders -> orders database");
                    System.out.println("payment -> payment database");
                    System.out.println("shipping -> shipping database");
                    System.out.println("staff -> staff database");
                    System.out.println("* -> exit database");
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
    // Test Cart Database
    private void cartQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                case "c":
                    testCreateCart();
                case "d":
                    testDeleteCart();
                case "sa":
                    testShowAllCarts();
                case "sc":
                    testShowCustomerCarts();
                case "h":
                    System.out.println("c -> create cart");
                    System.out.println("d -> delete carts");
                    System.out.println("sa -> show all carts");
                    System.out.println("sc -> show customer carts");
                    System.out.println("* -> return to database selection");
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
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                case "a":
                    testAddOrderItem();
                case "d":
                    testDeleteOrderItem();
                case "da":
                    testDeleteAllOrderItems();
                case "u":
                    testUpdateOrderItemQuantity();
                case "sa":
                    testShowAllCartItems();
                case "sc":
                    testShowCustomerCartItems();
                case "h":
                    System.out.println("a -> add order item");
                    System.out.println("u -> upate order item quantity");
                    System.out.println("d -> delete order item");
                    System.out.println("sa -> show all cart items");
                    System.out.println("sc -> show customer cart items");
                    System.out.println("* -> return to database selection");
                default:
                    System.out.println("Unknown Command");
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

    private void testDeleteAllOrderItems() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        try {
            db.deleteAllOrderItems(cartID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("All products in Cart " + cartID + " have been deleted");
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
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
    
    // Test Orders Database
    private void ordersQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                case "c":
                    testCreateOrder();
                case "u":
                    testUpdateOrderStatus();
                case "sc":
                    testShowCustomerOrders();
                case "sa":
                    testShowAllOrders();
                case "so":
                    testSearchOrders();
                case "ida":
                    testSortByOrderIDAsc();
                case "idd":
                    testSortByOrderIDDesc();
                case "dta":
                    testSortByOrderDateAsc();
                case "dtd":
                    testSortByOrderDateDesc();
                case "tca":
                    testSortByTotalCostAsc();
                case "tcd":
                    testSortByTotalCostDesc();
                case "h":
                    System.out.println("c -> create order");
                    System.out.println("u -> update order status");
                    System.out.println("sa -> show all orders");
                    System.out.println("sc -> show customer orders");
                    System.out.println("so -> search orders");
                    System.out.println("ida -> sort by order id ascending");
                    System.out.println("idd -> sort by order id descending");
                    System.out.println("dta -> sort by order date ascending");
                    System.out.println("dtd -> sort by order date descending");
                    System.out.println("tca -> sort by total cost ascending");
                    System.out.println("tcd -> sort by total cost descending");
                    System.out.println("* -> return to database selection");
                default:
                    System.out.println("Unknown Command");
            }
        }
    }

    private void testCreateOrder() throws SQLException {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        
        try {
            db.createOrder(cartID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Order for Cart " + cartID + " has been created");

    }

    private void testUpdateOrderStatus() throws SQLException {
        System.out.print("Order ID: ");
        int orderID = in.nextInt();
        System.out.print("Order Status: ");
        String orderStatus = in.nextLine();
        
        try {
            db.updateOrderStatus(orderID, orderStatus);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Order " + orderID + " has been updated with status " + orderStatus);
    }

    private void testShowCustomerOrders() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.showCustomerOrders(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testShowAllOrders() throws SQLException {
        try {
            db.showAllOrders();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSearchOrders() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        System.out.print("Order Status: ");
        String searchInput = in.nextLine();
        
        try {
            db.searchOrder(customerID, searchInput);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSortByOrderIDAsc() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.sortByOrderIDAsc(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSortByOrderIDDesc() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.sortByOrderIDDesc(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSortByOrderDateAsc() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.sortByOrderDateAsc(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSortByOrderDateDesc() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.sortByOrderDateDesc(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSortByTotalCostAsc() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.sortByTotalCostAsc(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testSortByTotalCostDesc() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.sortByTotalCostDesc(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Test Payment Database
    private void paymentQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
    
    // Test Product Database
    private void productQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
    
    // Test Shipping Database
    private void shippingQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
            }
        }
    }
    
    // Test Staff Database
    private void staffQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
            }
        }
    }

}
