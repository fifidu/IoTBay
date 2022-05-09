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

    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    /* Cart Database */
    // Create Cart
    public void createCart(int customerID) throws SQLException {
        String fetch = "SELECT COUNT(*) FROM iotuser.cart;";
        ResultSet rs = st.executeQuery(fetch);
      
        st.executeUpdate("INSERT INTO iotuser.cart (customerID) " + "VALUES ('" + customerID + "');");
    }
    
    // Delete Cart
    public void deleteCart(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cart WHERE cartID = " + cartID + ";");
    }
    
    // Show Customer Carts
    public void showCustomerCarts(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.cart WHERE customerID = " + customerID + ";";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int cusID = rs.getInt("customerID");
            System.out.println(cartID + ", " + cusID);
        }
    }
    // Show All Carts
    public void showAllCarts() throws SQLException {
        String fetch = "SELECT * FROM iotuser.cart";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int customerID = rs.getInt("customerID");
            System.out.println(cartID + ", " + customerID);
        }
    }
    
    /* CartLine Database */
    // Add Item
    public void addOrderItem(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("INSERT INTO iotuser.cartline (cartID, productID, quantity) " + "VALUES (" + cartID + "," + productID + "," + quantity + ");");
    }
    
    // Update Quantity
    public void updateOrderItemQuantity(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("UPDATE iotuser.cartline SET quantity = " + quantity + " WHERE cartID = " + cartID + " AND productID = " + productID + ";");
    }
    
    // Delete Item
    public void deleteOrderItem(int cartID, int productID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cartline WHERE cartID = " + cartID + "AND productID = " + productID + ";");
    }

    public void deleteAllOrderItems(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cartline WHERE cartID = " + cartID);
    }

    // Show Customer Cart Items
    public void showCustomerCartItems(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.cartline INNER JOIN iotuser.cart ON iotuser.cartline.cartid = iotuser.cart.cartid WHERE iotuser.cart.customerID = " + customerID + ";";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            System.out.println(cartID + ", " + productID + ", " + quantity);
        }
    }

    // Show All Cart Items
    public void showAllCartItems() throws SQLException {
        String fetch = "SELECT * FROM iotuser.cartline;";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            System.out.println(cartID + ", " + productID + ", " + quantity);
        }
    }

    /* Customer Database */
    
    /* Order Database */
    // Create Order
    public void createOrder(int cartID) throws SQLException {
        String orderStatus = "Processing";
        LocalDate orderDate = LocalDate.now();
        double totalCost = 0.00;

        String fetch = "SELECT * FROM iotuser.cartline WHERE iotuser.cartline.cartid = " + cartID + ";";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            double productCost = rs.getDouble("productID") * rs.getInt("quantity");
            totalCost += productCost;
        }

        st.executeUpdate("INSERT INTO iotuser.orders " + "VALUES (" + cartID + "," + orderStatus + "," + orderDate + "," + totalCost + ");");
    }

    // Update Order Status
    public void updateOrderStatus(int orderID, String orderStatus) throws SQLException {
        st.executeUpdate("UPDATE iotuser.orders SET orderStatus = " + orderStatus + " WHERE orderID = " + orderID + ";");
    }

    /* Show Customer Orders */
    public void showCustomerOrders(int customerID) throws SQLException {
        String fetch = "SELECT * from iotuser.orders INNER JOIN iotuser.cart ON iotuser.orders.cartID = iotuser.cart.cartID WHERE customerID = '" + customerID + "';";
        ResultSet rs = st.executeQuery(fetch);

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
        String fetch = "SELECT * FROM iotuser.orders";
        ResultSet rs = st.executeQuery(fetch);

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
        String fetch = "SELECT * FROM iotuser.orders WHERE iotuser.orders.customerid = " + customerID + "AND (iotuser.orders.orderid LIKE '%" + searchInput + "%' OR iotuser.orders.orderDate LIKE '%" + searchInput + "%');";
        ResultSet rs = st.executeQuery(fetch);

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
