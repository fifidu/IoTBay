/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;
import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


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
        st.executeUpdate("INSERT INTO IOTUSER.cart VALUES (" + cartID + "," + customerID + ")");
    }

    public int countCarts() throws SQLException {
        String fetch = "SELECT COUNT(*) FROM IOTUSER.cart";
        ResultSet rs = st.executeQuery(fetch);
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public void deleteCart(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.cart WHERE cartID = " + cartID);
    }

    // Show Customer Carts
    public void showCustomerCarts(int customerID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cart WHERE customerID = " + customerID;
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
        String fetch = "SELECT * FROM IOTUSER.cart";
        ResultSet rs = st.executeQuery(fetch);
        System.out.println("Cart ID, Customer ID");
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int customerID = rs.getInt("customerID");
            System.out.println(cartID + ", " + customerID);
        }
    }

    public ArrayList<Cart> fetchCarts() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cart";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Cart> temp = new ArrayList();
        while (rs.next()) {
            int cartID = rs.getInt("cartID");
            int customerID = rs.getInt("customerID");
            temp.add(new Cart(cartID, customerID));
        }
        return temp;
    }

    /* CartLine Database */
    // Add Item
    public void addOrderItem(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.cartline " + "VALUES (" + cartID + "," + productID + "," + quantity + ")");
        updateTotalCost(cartID);
        decreaseProductQuantity(productID, quantity);
    }
    
    // Update Quantity
    public void updateOrderItemQuantity(int cartID, int productID, int quantity /* 4 */) throws SQLException {
        int quantityDiff;
        String fetch = "SELECT * FROM IOTUSER.cartline WHERE cartID = " + cartID + " AND productID = " + productID; 
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int oldQuantity = rs.getInt("quantity");
            if (quantity /* 4 */ > oldQuantity /* 3 */) {
                quantityDiff = quantity - oldQuantity;
                decreaseProductQuantity(productID, quantityDiff);
                st.executeUpdate("UPDATE IOTUSER.cartline SET quantity = " + quantity + " WHERE cartID = " + cartID + " AND productID = " + productID);
                updateTotalCost(cartID);
            } else if (quantity /* 2 */ < oldQuantity /* 3 */) {
                quantityDiff = oldQuantity - quantity;
                increaseProductQuantity(productID, quantityDiff);
                st.executeUpdate("UPDATE ITOUSER.cartline SET quantity = " + quantity + " WHERE cartID = " + cartID + " AND productID = " + productID);
                updateTotalCost(cartID);
            } else {
                System.out.println("Product ID " + productID + " already has Quantity " + quantity);
            }
        }
    }
    
    // Delete Item
    public void deleteOrderItem(int cartID, int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cartline WHERE cartID " + cartID + " AND productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int quantity = rs.getInt("quantity");
            increaseProductQuantity(productID, quantity);
        }
        st.executeUpdate("DELETE FROM IOTUSER.cartline WHERE cartID = " + cartID + " AND productID = " + productID);
        updateTotalCost(cartID);
    }

    public void deleteAllOrderItems(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.cartline WHERE cartID = " + cartID);
        updateTotalCost(cartID);
        // Update Product Quantity
    }

    public void cancelledOrderItems(int cartID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cartline WHERE cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int productID = rs.getInt("productID");
            int quantity  = rs.getInt("quantity");
            // Update Product Quantity
        }

    }

    // Show Customer Cart Items
    public void showCustomerCartItems(int cartID) throws SQLException {
        ArrayList<CartLine> cartList = fetchCartItems(cartID);
        for (CartLine cl: cartList) {
            System.out.println(cl.getProductID() + ", " + cl.getProductName() + ", " + cl.getQuantity()); 
        }
    }

    public ArrayList<CartLine> fetchCartItems(int cartID) throws SQLException {
        String fetch = "SELECT * FROM ((IOTUSER.cartline INNER JOIN IOTUSER.orders ON cartline.cartID = orders.cartID) INNER JOIN IOTUSER.product ON cartline.productID = product.productID) WHERE cartline.cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<CartLine> temp = new ArrayList();
        while (rs.next()) {
            int productID = rs.getInt("productID");
            String productName = rs.getString("productName");
            String orderStatus = rs.getString("orderStatus");
            double productCost = rs.getDouble("productCost");
            int quantity = rs.getInt("quantity");
            double itemTotal = productCost * quantity;
            double totalCost = rs.getDouble("totalCost");
            temp.add(new CartLine(cartID, productID, productName, orderStatus, productCost, quantity, itemTotal, totalCost));
        }
        return temp;
    }

    public double calculateTotalCost(int cartID) throws SQLException {
        String fetch = "SELECT productCost, quantity FROM ((IOTUSER.cartline INNER JOIN IOTUSER.orders ON cartline.cartID = orders.cartID) INNER JOIN IOTUSER.product ON cartline.productID = product.productID) WHERE cartline.cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        double totalCost = 0.00;
        while (rs.next()) {
            double productCost = rs.getDouble("productCost");
            int quantity = rs.getInt("quantity");
            totalCost += productCost * quantity;
        }
        return totalCost;
    }

    public int countCartItems(int cartID) throws SQLException {
        int count = 0;
        String fetch = "SELECT COUNT(*) FROM IOTUSER.cartline WHERE cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
    // Show All Cart Items
    public void showAllCartItems() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cartline";
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
    public void addCustomer(int customerID, String cusEmailAddress, String cusPass ) throws SQLException {
        st.executeUpdate("INSERT INTO customer (customerID, cusEmailAddress, cusPass) VALUES (" + customerID + ", " + cusEmailAddress + ", " + cusPass + ")");
    }
    
    public void deleteCustomer (int customerID) throws SQLException {
        st.executeUpdate("DELETE FROM customer WHERE customerID = " + customerID);
    }
    
//    public void updateCustomer (int customerID, String cusEmailAddress, String cusFName, String cusLName, cusPass, cusContactNumber ) throws SQLException{
//        st.executeUpdate("UPDATE ")
//    }
    
    /* Order Database */
    // Create New Order for Customer
    public Order createOrder(int customerID) throws SQLException {
        int orderID = countOrders() + 1;
        int cartID = countCarts() + 1;
        String orderStatus = "Active";
        LocalDate orderDate = LocalDate.now();
        double totalCost = 0.00;
        createCart(cartID, customerID);

        st.executeUpdate("INSERT INTO IOTUSER.orders " + "VALUES (" + orderID + ", " + cartID + ",'" + orderDate + "','" + orderStatus + "'," + totalCost + ")");

        return new Order(orderID, cartID, orderDate, orderStatus, totalCost);
    }

    // Count number of orders in Orders database
    public int countOrders() throws SQLException {
        String fetch = "SELECT COUNT(*) FROM IOTUSER.orders";
        ResultSet rs = st.executeQuery(fetch);
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public boolean checkActiveOrders(int customerID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.orders INNER JOIN IOTUSER.cart ON orders.cartID = cart.cartID WHERE customerID = " + customerID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String orderStatus = rs.getString("orderStatus");
            if (orderStatus.equals("Active")) {
                return true;
            }
        }
        return false;
    }

    public void updateTotalCost(int cartID) throws SQLException {
        double totalCost = 0.00;
        String fetch = "SELECT * FROM IOTUSER.cartline INNER JOIN product ON cartline.productID = product.productID WHERE cartid = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            double productCost = rs.getDouble("productCost") * rs.getInt("quantity");
            totalCost += productCost;
        }
        st.executeUpdate("UPDATE IOTUSER.orders SET totalCost = " + totalCost + " WHERE cartID = " + cartID);
    }


    // Update Order Status
    public void updateOrderStatus(int orderID, String orderStatus) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.orders SET orderStatus = '" + orderStatus + "' WHERE orderID = " + orderID);
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
        ArrayList<Order> orderList = fetchCustomerOrders(customerID);
        for (Order ord: orderList) {
            System.out.println(ord.getOrderID() + ", " + ord.getCartID() + ", " + ord.getOrderDate() + ", " + ord.getOrderStatus() + ", " + ord.getTotalCost());
        }
    }

    public ArrayList<Order> fetchCustomerOrders(int customerID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.orders INNER JOIN IOTUSER.cart ON orders.cartID = cart.cartID WHERE customerID = " + customerID + " ORDER BY orders.orderDate DESC";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date sqlOrderDate = rs.getDate("orderDate");
            LocalDate javaOrderDate = sqlOrderDate.toLocalDate();
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            temp.add(new Order(orderID, cartID, javaOrderDate, orderStatus, totalCost));
        }  
        return temp;
    }
    // Show All Orders
    public void showAllOrders() throws SQLException {
        ArrayList<Order> orderList = fetchOrders();
        for (Order ord: orderList) {
            System.out.println(ord.getOrderID() + ", " + ord.getCartID() + ", " + ord.getOrderDate() + ", " + ord.getOrderStatus() + ", " + ord.getTotalCost());
        }   
    }

    public ArrayList<Order> fetchOrders() throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.orders";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date sqlOrderDate = rs.getDate("orderDate");
            LocalDate javaOrderDate = sqlOrderDate.toLocalDate();
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            temp.add(new Order(orderID, cartID, javaOrderDate, orderStatus, totalCost));
        }  
        return temp;
    }


    /* Search Orders */
    public void searchOrder(int customerID, String searchInput) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.orders WHERE orders.customerid = " + customerID + "AND (orders.orderid LIKE '%" + searchInput + "%' OR orders.orderDate LIKE '%" + searchInput + "%')";
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
        String fetch = "SELECT * FROM IOTUSER.orders WHERE orders.customerid = " + customerID + " ORDER BY orders.orderid ASC";
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
        String fetch = "SELECT * FROM IOTUSER.orders WHERE orders.customerid = " + customerID + " ORDER BY orders.orderid DESC";
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
        String fetch = "SELECT * FROM IOTUSER..orders WHERE orders.customerid = " + customerID + " ORDER BY orders.orderdate ASC";
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
        String fetch = "SELECT * FROM IOTUSER.orders WHERE orders.customerid = " + customerID + " ORDER BY orders.orderdate DESC";
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
        String fetch = "SELECT * FROM IOTUSER.orders WHERE orders.customerid = " + customerID + " ORDER BY orders.totalcost ASC";
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
        String fetch = "SELECT * FROM IOTUSER.orders WHERE orders.customerid = " + customerID + " ORDER BY orders.totalcost DESC";
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
    // Create details (links to orderID)
    public void createPayment(int paymentID, int orderID, String cardNumber, String cardName, String cardExpiry, int cvv) throws SQLException {
    st.executeUpdate("INSERT INTO IOTUSER.payment VALUES (" + paymentID + ", " + orderID + ", '" + cardNumber + "', '" + cardName + "', '" + cardExpiry + "', '" + cvv + "')");
    }

    // View saved order payment details

    // View order history list

    // Search payment records based on paymentID and date

    // Update details

    // Delete details

/* Product Database */
/* Shipping Database */
/* Staff Database */

    /* Product*/
    //Create product (staff only)
    public void createProduct(int productID, String productName, String productType, String productSupplier, String productDescription, double productCost, int quantityAvailable) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.product " + "VALUES (" + productID + ", '" + productName + "', '" + productType + "', '" + productSupplier + "', '" + productDescription + "', " + productCost + ", " + quantityAvailable + ")");
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
    public ArrayList<Product> findProduct(String searchedString) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE upper(productName) LIKE '%" + searchedString.toUpperCase() + "%' OR upper(productType) LIKE '%" + searchedString.toUpperCase() + "%'";
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

    public ArrayList<Product> fetchIndividualProduct(int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();

        while (rs.next()) {
            String productName = rs.getString(2);
            String productType = rs.getString(3);
            String productSupplier = rs.getString(4);
            String productDescription = rs.getString(5);
            double productCost = rs.getDouble(6);
            int quantityAvailable = rs.getInt(7);
            temp.add(new Product(productID, productName, productType, productSupplier, productDescription, productCost, quantityAvailable));
        }
        return temp;
    }
    //Update product
    public void updateProduct(int productID, String productName, String productType, String productSupplier, String productDescription, double productCost, int quantityAvailable) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.product SET productName = '" + productName + "', productType = '" + productType + "', productSupplier = '" + productSupplier + "', productDescription = '" + productDescription + "', productCost = " + productCost + ", quantityAvailable = " + quantityAvailable + " WHERE productID = " + productID);
    }

    // Increase product quantity available
    public void increaseProductQuantity(int productID, int quantity) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int newQuantity = rs.getInt("quantityAvailable") + quantity;
            st.executeUpdate("UPDATE IOTUSER.product SET quantityAvailable = " + newQuantity + " WHERE productID = " + productID);
        }
    }

    // Decrease product quantity available 
    public void decreaseProductQuantity(int productID, int quantity) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int newQuantity = rs.getInt("quantityAvailable") - quantity;
            st.executeUpdate("UPDATE IOTUSER.product SET quantityAvailable = " + newQuantity + " WHERE productID = " + productID);
        }
    }

    //Delete product
    public void deleteProduct(String productName) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.product WHERE productName = '" + productName + "'");
    }

}
