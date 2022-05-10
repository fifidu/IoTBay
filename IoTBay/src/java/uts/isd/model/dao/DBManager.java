/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;
import java.sql.*;
import java.time.LocalDate;


/**
 *
 * @author chrisvuong
 */
public class DBManager {

    private final Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    /* Cart Database */
    // Create Cart (if automated only use customerID as parameter)
    public void createCart(int cartID, int customerID) throws SQLException {
        st.executeUpdate("INSERT INTO cart VALUES (" + cartID + "," + customerID + ")");
    }

    public void deleteCart(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM cart WHERE cartID = " + cartID);
    }

    // Show Customer Carts
    public void showCustomerCarts(int customerID) throws SQLException {
        String fetch = "SELECT * FROM cart WHERE customerID = " + customerID;
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Cart ID, Customer ID");
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int cusID = rs.getInt("customerID");
            System.out.println(cartID + ", " + cusID);
        }
    }
    // Show All Carts
    public void showAllCarts() throws SQLException {
        String fetch = "SELECT * FROM cart";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Cart ID, Customer ID");
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int customerID = rs.getInt("customerID");
            System.out.println(cartID + ", " + customerID);
        }
    }
    
    /* CartLine Database */
    // Add Item
    public void addOrderItem(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("INSERT INTO iotuser.cartline " + "VALUES (" + cartID + "," + productID + "," + quantity + ")");
        updateTotalCost(cartID);
        // Update Product Quantity
    }
    
    // Update Quantity
    public void updateOrderItemQuantity(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("UPDATE iotuser.cartline SET quantity = " + quantity + " WHERE cartID = " + cartID + " AND productID = " + productID);
        updateTotalCost(cartID);
        // Update Product Quantity
    }
    
    // Delete Item
    public void deleteOrderItem(int cartID, int productID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cartline WHERE cartID = " + cartID + " AND productID = " + productID);
        updateTotalCost(cartID);
        // Update Product Quantity
    }

    public void deleteAllOrderItems(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cartline WHERE cartID = " + cartID);
        updateTotalCost(cartID);
        // Update Product Quantity
    }

    public void cancelledOrderItems(int cartID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.cartline WHERE cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int productID = rs.getInt("productID");
            int quantity  = rs.getInt("quantity");
            // Update Product Quantity
        }

    }

    // Show Customer Cart Items
    public void showCustomerCartItems(int cartID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.cartline WHERE cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Product ID, Quantity");
        while (rs.next()) {
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            System.out.println(productID + ", " + quantity);
        }
    }

    // Show All Cart Items
    public void showAllCartItems() throws SQLException {
        String fetch = "SELECT * FROM cartline";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Cart ID, Product ID, Quantity");
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            System.out.println(cartID + ", " + productID + ", " + quantity);
        }
    }

    /* Customer Database */
    
    /* Order Database */
    // Create Order (if automated only use customerID as parameter)
    public void createOrder(int orderID, int cartID, int customerID) throws SQLException {
        createCart(cartID, customerID); // If automated only use customerID as parameter
        String orderStatus = "Active";
        LocalDate orderDate = LocalDate.now();
        double totalCost = 0.00;
        st.executeUpdate("INSERT INTO iotuser.orders " + "VALUES (" + orderID + ", " + cartID + ",'" + orderDate + "','" + orderStatus + "'," + totalCost + ")");
    }

    public void updateTotalCost(int cartID) throws SQLException {
        double totalCost = 0.00;
        String fetch = "SELECT * FROM cartline INNER JOIN product ON cartline.productID = product.productID WHERE cartid = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            double productCost = rs.getDouble("productCost") * rs.getInt("quantity");
            totalCost += productCost;
        }
        st.executeUpdate("UPDATE iotuser.orders SET totalCost = " + totalCost + " WHERE cartID = " + cartID);
    }


    // Update Order Status
    public void updateOrderStatus(int orderID, String orderStatus) throws SQLException {
        st.executeUpdate("UPDATE iotuser.orders SET orderStatus = '" + orderStatus + "' WHERE orderID = " + orderID);
    }

    public void cancelOrder(int orderID, int cartID) throws SQLException {
        cancelledOrderItems(cartID);         
        String cancel = "Cancelled";   
        updateOrderStatus(orderID, cancel);
    }

    public void submitOrder(int orderID) throws SQLException {
        updateOrderStatus(orderID, "Submitted");
    }

    /* Show Customer Orders */
    public void showCustomerOrders(int customerID) throws SQLException {
        String fetch = "SELECT * from orders INNER JOIN cart ON orders.cartID = cart.cartID WHERE customerID = " + customerID;
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }   
    }

    // Show All Orders
    public void showAllOrders() throws SQLException {
        String fetch = "SELECT * FROM orders";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }  
    }

    /* Search Orders */
    public void searchOrder(int customerID, String searchInput) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + "AND (iotuser.orders.orderid LIKE '%" + searchInput + "%' OR iotuser.orders.orderDate LIKE '%" + searchInput + "%')";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }

    /* Sort Orders */
    public void sortByOrderIDAsc(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + " ORDER BY iotuser.orders.orderid ASC";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }

    public void sortByOrderIDDesc(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + " ORDER BY iotuser.orders.orderid DESC";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }

    public void sortByOrderDateAsc(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + " ORDER BY iotuser.orders.orderdate ASC";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }

    public void sortByOrderDateDesc(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + " ORDER BY iotuser.orders.orderdate DESC";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }

    public void sortByTotalCostAsc(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + " ORDER BY iotuser.orders.totalcost ASC";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }

    public void sortByTotalCostDesc(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + " ORDER BY iotuser.orders.totalcost DESC";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Order ID, Cart ID, Order Date, Order Status, Total Cost");
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date orderDate = rs.getDate("orderDate");
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            System.out.println(orderID + ", " + cartID + ", " + orderDate + ", " + orderStatus + ", " + totalCost);
        }
    }
/* Payment Database */
/* Product Database */
/* Shipping Database */
/* Staff Database */

}
