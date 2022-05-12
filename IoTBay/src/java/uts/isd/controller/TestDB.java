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
import uts.isd.model.*;
import uts.isd.model.dao.DBManager;
import uts.isd.model.dao.DBConnector;



public class TestDB {
    
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
 
    public static void main(String[] args) throws SQLException {
        TestDB test = new TestDB();
        test.runQueries();
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
                    break;
                case "cartline":
                    cartLineQueries();
                    break;
                case "customer":
                    customerQueries();
                    break;
                case "orders":
                    ordersQueries();
                    break;
                case "payment":
                    paymentQueries();
                    break;
                case "product":
                    productQueries();
                    break;
                case "shipping":
                    shippingQueries();
                    break;
                case "staff":
                    staffQueries();
                    break;
                case "h":
                    System.out.println("cart -> cart database");
                    System.out.println("cartline -> cartline database");
                    System.out.println("customer -> customer database");
                    System.out.println("orders -> orders database");
                    System.out.println("payment -> payment database");
                    System.out.println("shipping -> shipping database");
                    System.out.println("staff -> staff database");
                    System.out.println("* -> exit database");
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
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
                    break;
                case "d":
                    testDeleteCart();
                    break;
                case "sa":
                    testShowAllCarts();
                    break;
                case "sc":
                    testShowCustomerCarts();
                    break;
                case "h":
                    System.out.println("c -> create cart");
                    System.out.println("d -> delete cart");
                    System.out.println("sa -> show all carts");
                    System.out.println("sc -> show customer carts");
                    System.out.println("* -> return to database selection");
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }

    private void testCreateCart() {
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.createCart(cartID, customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("New Cart for Customer " + customerID + " has been created");
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
    
    private void testShowCustomerCarts() {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.showCustomerCarts(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    break;
                case "d":
                    testDeleteOrderItem();
                    break;
                case "da":
                    testDeleteAllOrderItems();
                    break;
                case "u":
                    testUpdateOrderItemQuantity();
                    break;
                case "sa":
                    testShowAllCartItems();
                    break;
                case "sc":
                    testShowCustomerCartItems();
                    break;
                case "h":
                    System.out.println("a -> add order item");
                    System.out.println("u -> upate order item quantity");
                    System.out.println("d -> delete order item");
                    System.out.println("sa -> show all cart items");
                    System.out.println("sc -> show customer cart items");
                    System.out.println("* -> return to database selection");
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
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
        System.out.println("Product " + productID + " in Cart " + cartID + " has been updated with Quantity " + quantity);
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
        System.out.println("Product " + productID + " has been deleted from Cart " + cartID);
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
                    break;
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
                    break;
                case "u":
                    testUpdateOrderStatus();
                    break;
                case "ca":
                    testCancelOrder();
                case "s":
                    testSubmitOrder();
                    break;
                case "sc":
                    testShowCustomerOrders();
                    break;
                case "sa":
                    testShowAllOrders();
                    break;
                case "so":
                    testSearchOrders();
                    break;
                case "h":
                    System.out.println("c -> create order");
                    System.out.println("u -> update order status");
                    System.out.println("ca -> cancel order");
                    System.out.println("s -> submit order");
                    System.out.println("sa -> show all orders");
                    System.out.println("sc -> show customer orders");
                    System.out.println("so -> search orders");
                    System.out.println("* -> return to database selection");
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }

    private void testCreateOrder() throws SQLException {
        System.out.print("Customer ID: ");
        int customerID = in.nextInt();
        
        try {
            db.createOrder(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("New order for Customer " + customerID + " has been created");

    }

    private void testUpdateOrderStatus() throws SQLException {
        System.out.print("Order Status: ");
        String orderStatus = in.nextLine();
        System.out.print("Order ID: ");
        int orderID = in.nextInt();
        
        try {
            db.updateOrderStatus(orderID, orderStatus);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Order " + orderID + " has been updated with status " + orderStatus);
    }

    private void testCancelOrder() throws SQLException {
        System.out.print("Order ID: ");
        int orderID = in.nextInt();
        System.out.print("Cart ID: ");
        int cartID = in.nextInt();

        try {
            db.cancelOrder(orderID, cartID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Order " + orderID + " has been cancelled");
    }

    private void testSubmitOrder() throws SQLException {
        System.out.print("Order ID: ");
        int orderID = in.nextInt();

        try {
            db.submitOrder(orderID);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Order " + orderID + " has been submitted");
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

    // Test Payment Database
    private void paymentQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
    
    // Test Product Database
    private void productQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                case "c":
                    testCreateProduct();
                case "s":
                    testFindProduct();
                case "f":
                    testFetchProducts();
                case "u":
                    testUpdateProduct();
                case "d":
                    testDeleteProduct();                      
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }

    //Testing createProduct()
    private void testCreateProduct() throws SQLException {
        System.out.print("Product ID: ");
        int enteredProductID = in.nextInt();
        System.out.print("Product name: ");
        String enteredProductName = in.nextLine();
        System.out.print("Product type: ");
        String enteredProductType = in.nextLine();
        System.out.print("Product supplier: ");
        String enteredProductSupplier = in.nextLine();
        System.out.print("Product description: ");
        String enteredProductDescription = in.nextLine();
        System.out.print("Product cost: ");
        double enteredProductCost = in.nextDouble();
        System.out.print("Product quantity: ");
        int enteredProductQuantity = in.nextInt();

        try {
            db.createProduct(enteredProductID, enteredProductName, enteredProductType, enteredProductSupplier, enteredProductDescription, enteredProductCost, enteredProductQuantity);
        }

        catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Testing findProduct()
    private void testFindProduct() throws SQLException {
        System.out.print("Search: ");
        String searched = in.nextLine();

        try {
            db.findProduct(searched);
        }

        catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Testing fetchProducts()
    private void testFetchProducts() throws SQLException {
        try {
            ArrayList<Product> products = db.fetchProducts();
            System.out.println("PRODUCTS TABLE");
            
            for (Product p : products) {
                System.out.printf("%-20s %-30s %-20s %-10s \n", p.getProductID(), p.getProductName(), p.getProductType(), p.getProductSupplier(), p.getProductDescription(), p.getProductCost(), p.getQuantityAvailable());
            }
//            products.stream().forEach((product) -> {
//                System.out.printf("%-20s %-30s %-20s %-10s \n", product.getProductID(), product.getProductName(), product.getProductType(), product.getProductSupplier(), product.getProductDescription(), product.getProductCost(), product.getQuantityAvailable());
//            });
        }

        catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Testing updateProduct()
    private void testUpdateProduct() throws SQLException {
        System.out.print("Product ID: ");
        int enteredProductID = in.nextInt();
        System.out.print("Product name: ");
        String enteredProductName = in.nextLine();
        System.out.print("Product type: ");
        String enteredProductType = in.nextLine();
        System.out.print("Product supplier: ");
        String enteredProductSupplier = in.nextLine();
        System.out.print("Product description: ");
        String enteredProductDescription = in.nextLine();
        System.out.print("Product cost: ");
        double enteredProductCost = in.nextDouble();
        System.out.print("Product quantity: ");
        int enteredProductQuantity = in.nextInt();

        try {
            db.updateProduct(enteredProductID, enteredProductName, enteredProductType, enteredProductSupplier, enteredProductDescription, enteredProductCost, enteredProductQuantity);
        }

        catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Testing deleteProduct()
    private void testDeleteProduct() throws SQLException {
        System.out.print("Name of product to delete: ");
        String enteredProductName = in.nextLine();

        try {
            db.deleteProduct(enteredProductName);
        }

        catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Test Shipping Database
    private void shippingQueries() throws SQLException {
        String s;
        while (!"*".equals(s = readChoice().toLowerCase())) {
            switch (s) {
                default:
                    System.out.println("Unknown Command");
                    break;
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
                    break;
            }
        }
    }

}
