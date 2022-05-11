/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;
import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.*;

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
    /* Find Customer Orders */
    public void findOrder(int customerID) throws SQLException {

    }

    /* Create Order */
    public void addOrder(int customerID, int cartID) throws SQLException {
        
    }
  
    public void createOrder(int customerID) throws SQLException {

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

    /* Product*/
    //Create product (staff only)
    public void createProduct(int productID, String productName, String productType, String productSupplier, String productDescription, double productCost, int quantityAvailable) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.product " + "VALUES ('" + productID + "', '" + productName + "', '" + productType + "', '" + productSupplier + "', '" + productDescription + "', '" + productCost + "', '" + quantityAvailable + "', '0'"); //0 being the quantity sold
    }

    //Read/Find a product (customer or staff)
    //List all device records
    public ArrayList<Product> fetchProducts() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();

        while (rs.next()) {
            int returnedProductID = rs.getInt(1);
            String returnedProductName = rs.getString(2);
            String returnedProductType = rs.getString(3);
            String returnedProductSupplier = rs.getString(4);
            String returnedProductDescription = rs.getString(5);
            double returnedProductCost = rs.getDouble(6);
            int returnedQuantityAvailable = rs.getInt(7);
            temp.add(new Product(returnedProductID, returnedProductName, returnedProductType, returnedProductSupplier, returnedProductDescription, returnedProductCost, returnedQuantityAvailable));
        }
        return temp;
    }

    //Search for device based on name or type
    public Product findProduct(String searchedString) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE productName = '" + searchedString + "' OR productType = '" + searchedString + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String actualProductName = rs.getString(2);
            String actualProductType = rs.getString(3);

            if (actualProductName.equals(searchedString) || actualProductType.equals(searchedString)) {
                int returnedProductID = rs.getInt(1);
                String returnedProductName = rs.getString(2);
                String returnedProductType = rs.getString(3);
                String returnedProductSupplier = rs.getString(4);
                String returnedProductDescription = rs.getString(5);
                double returnedProductCost = rs.getDouble(6);
                int returnedQuantityAvailable = rs.getInt(7);
                return new Product(returnedProductID, returnedProductName, returnedProductType, returnedProductSupplier, returnedProductDescription, returnedProductCost, returnedQuantityAvailable);
            }
        }
        return null;
    }

    //Update product
    public void updateProduct(int productID, String productName, String productType, String productSupplier, String productDescription, double productCost, int quantityAvailable) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.product SET productName = '" + productName + "', productType = '" + productType + "', productSuppler = '" + productSupplier + "', productDescription = '" + productDescription + "', productCost = '" + productCost + "', quantityAvailable = '" + quantityAvailable + "' WHERE productID = '" + productID + "'");
    }

    //Delete product
    public void deleteProduct(String productName) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.product WHERE productName = '" + productName + "'");
    }

}
