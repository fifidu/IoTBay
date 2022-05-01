/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;
import java.sql.Connection;

/**
 *
 * @author chrisvuong
 */
public class DBManager {

    private statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    /* Order Class */
    /* Find Customer Orders */
    public void findOrder(int customerID) throws SQLException {

    }

    /* Create Order */
    public void addOrder(int customerID, int cartID) throws SQLException {

    }

    /* Update Order */
    public void addOrderItem(int cartID, int productID, int quantity) throws SQLException {

    }

    public void updateOrderItem(int cartID, int productID, int quantity) throws SQLException {

    }

    public void deleteOrderItem(int cartID, int productID) throws SQLException {

    }

    public void updateOrderStatus(int orderID, String newStatus) throws SQLException {
      
    }

    /* Delete Order */
    public void deleteOrder(int cartID) throws SQLException {

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
