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

    /* Order Class */
    /* Show Customer Orders */
    public void showOrders(int customerID) throws SQLException {
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

    public void showAllCarts() throws SQLException {
        String fetch = "SELECT * FROM iotuser.cart";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int customerID = rs.getInt("customerID");
            System.out.println(cartID + ", " + customerID);
        }
    }

    public void showCustomerCarts(int customerID) throws SQLException {
        String fetch = "SELECT * FROM iotuser.cart WHERE customerID = " + customerID + ";";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int cusID = rs.getInt("customerID");
            System.out.println(cartID + ", " + cusID);
        }
    }

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

    public void showAllCartItems() throws SQLException {
        String fetch = "SELECT * FROM iotuser.cartline";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            System.out.println(cartID + ", " + productID + ", " + quantity);
        }
    }


    /* Create Order */
    public void addOrder(int cartID) throws SQLException {
        String orderStatus = "Processing";
        LocalDate orderDate = LocalDate.now();
        double totalCost = 0.00;

        String fetch = "SELECT * FROM iotuser.cartline WHERE iotuser.cartline.cartid = " + cartID + ";";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            double productCost = rs.getDouble("productID") * rs.getInt("quantity");
            totalCost += productCost;
        }

        st.executeUpdate("INSERT INTO iotuser.orders (cartID, orderDate, orderStatus, totalCost) " + "VALUES (" + cartID + "," + orderStatus + "," + orderDate + "," + totalCost + ");");
    }
  
    public void createCart(int customerID) throws SQLException {
        st.executeUpdate("INSERT INTO iotuser.cart (customerID) " + "VALUES ('" + customerID + "')");
    }

    /* Update Order */
    public void addOrderItem(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("INSERT INTO iotuser.cartline (cartID, productID, quantity) " + "VALUES (" + cartID + "," + productID + "," + quantity + ");");
    }

    public void updateOrderItemQuantity(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("UPDATE iotuser.cartline SET quantity = " + quantity + " WHERE cartID = " + cartID + " AND productID = " + productID + ";");
    }

    public void deleteOrderItem(int cartID, int productID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cartline WHERE cartID = " + cartID + "AND productID = " + productID + ";");
    }

    public void updateOrderStatus(int orderID, String orderStatus) throws SQLException {
        st.executeUpdate("UPDATE iotuser.orders SET orderStatus = " + orderStatus + " WHERE orderID = " + orderID + ";");
    }

    /* Delete Order */
    public void deleteCart(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM iotuser.cart WHERE cartID = " + cartID + ";");
    }

    /* Search Orders */
    public void searchOrder(int customerID, String searchInput) throws SQLException {

    }

    /* Sort Orders */
    public void sortByOrderIDAscend(int customerID) throws SQLException {

    }

    public void sortByOrderIDDescend(int customerID) throws SQLException {

    }

    public void sortByDateAscend(int customerID) throws SQLException {

    }

    public void sortByDateDescend(int customeraID) throws SQLException {

    }

    public void sortByTotalCostAscend(int customerID) throws SQLException {

    }

    public void sortByTotalCostDescend(int customerID) throws SQLException {

    }

}
