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

    public int nextAvailableCartID() throws SQLException {
        int nextID = 0;

        String fetch = "SELECT * FROM IOTUSER.cart";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            nextID = rs.getInt("cartID");
        }
        return nextID + 1;
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
    }

    public void addQuantityToExistingItem(int cartID, int productID, int quantity) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cartline WHERE cartID = " + cartID + " AND productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);
        int newQuantity = 0;
        while (rs.next()) {
            newQuantity = rs.getInt("quantity") + quantity;
        }

        st.executeUpdate("UPDATE IOTUSER.cartline SET quantity = " + newQuantity + " WHERE cartID = " + cartID + " AND productID = " + productID);
        updateTotalCost(cartID);
    }

    // Update Quantity
    public void updateOrderItemQuantity(int cartID, int productID, int quantity) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.cartline SET quantity = " + quantity + " WHERE cartID = " + cartID + " AND productID = " + productID);
        updateTotalCost(cartID);
    }

    // Delete Item
    public void deleteOrderItem(int cartID, int productID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.cartline WHERE cartID = " + cartID + " AND productID = " + productID);
        updateTotalCost(cartID);
    }

    public void deleteAllOrderItems(int cartID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.cartline WHERE cartID = " + cartID);
        updateTotalCost(cartID);
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

    public boolean checkItemInCart(int cartID, int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.cartline WHERE cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int returnedProductID = rs.getInt("productID");
            if (returnedProductID == productID) {
                return true;
            }
        }
        return false;
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
// Checks if email exists in customer table
    public boolean checkCustomer(String emailAddress) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.customer WHERE cusEmailAddress = '" + emailAddress + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String cusEmailAddress = rs.getString("cusEmailAddress");
            if (cusEmailAddress.equals(emailAddress)) {
            return true;
            }
        }
        return false;
}

    // Checks if email and password match
    public Customer findCustomer(String emailAddress, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.customer WHERE cusEmailAddress = '" + emailAddress + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String cusEmailAddress = rs.getString("cusEmailAddress");
            String cusPass = rs.getString("cusPass");

            if (cusEmailAddress.equals(emailAddress) && cusPass.equals(password)) {
                int customerID = rs.getInt("customerID");
                String cusFName = rs.getString("cusFName");
                String cusLName = rs.getString("cusLName");
                String cusContactNumber = rs.getString("cusContactNumber");
                return new Customer(customerID, cusFName, cusLName, cusEmailAddress, cusPass, cusContactNumber);
            }
        }
        return null;
    }

   // Finds the next available customerID
    public int nextAvailableCustomerID() throws SQLException {
        int nextID = 0;
        String fetch = "SELECT * FROM IOTUSER.customer";
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            nextID = rs.getInt("customerID");
        }
        return nextID + 1;
    }

    // Adds new customer to database and creates Customer object to store information for display on the website
    public Customer addCustomer(String cusFName, String cusLName, String cusEmailAddress, String cusPass, String cusContactNumber) throws SQLException {
        int customerID = nextAvailableCustomerID();

        st.executeUpdate("INSERT INTO IOTUSER.customer VALUES (" + customerID + ", '" + cusFName + "', '" + cusLName + "', '"+ cusEmailAddress + "', '" + cusPass + "', '" + cusContactNumber + "')");

        return new Customer(customerID, cusFName, cusLName, cusEmailAddress, cusPass, cusContactNumber);
    }

    public void deleteCustomer (int customerID) throws SQLException {
        st.executeUpdate("DELETE FROM customer WHERE customerID = " + customerID);
    }

    public Customer updateCustomer (int customerID, String cusFName, String cusLName, String cusEmailAddress, String cusPass, String cusContactNumber) throws SQLException{
        st.executeUpdate("UPDATE IOTUSER.customer SET cusEmailAddress = '" + cusEmailAddress + "', cusFName= '" + cusFName + "', cusLName = '" + cusLName + "', cusPass = '" + cusPass + "', cusContactNumber = '" + cusContactNumber + "' WHERE customerID = " + customerID);
        return new Customer(customerID, cusFName, cusLName, cusEmailAddress, cusPass, cusContactNumber);
    }

    /* Order Database */
    // Create New Order for Customer
    public Order createOrder(int customerID) throws SQLException {
        int orderID = nextAvailableOrderID();
        int cartID = nextAvailableCartID();
        String orderStatus = "Active";
        LocalDate orderDate = LocalDate.now();
        double totalCost = 0.00;

        saveActiveOrder(customerID);
        createCart(cartID, customerID);

        st.executeUpdate("INSERT INTO IOTUSER.orders " + "VALUES (" + orderID + ", " + cartID + ",'" + orderDate + "','" + orderStatus + "'," + totalCost + ")");

        return new Order(orderID, cartID, orderDate, orderStatus, totalCost);
    }

   // Finds the next available orderID
    public int nextAvailableOrderID() throws SQLException {
        int nextID = 0;
        String fetch = "SELECT * FROM IOTUSER.orders";
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            nextID = rs.getInt("orderID");
        }
        return nextID + 1;
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

    public Order findActiveOrder(int customerID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.orders INNER JOIN IOTUSER.cart ON orders.cartID = cart.cartID WHERE customerID = " + customerID + " AND orderStatus = 'Active'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            int cartID = rs.getInt("cartID");
            Date sqlOrderDate = rs.getDate("orderDate");
            LocalDate javaOrderDate = sqlOrderDate.toLocalDate();
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            return new Order(orderID, cartID, javaOrderDate, orderStatus, totalCost);
        }
        return null;
    }


    public Order findOrder(int cartID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.orders WHERE cartID = " + cartID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int orderID = rs.getInt("orderID");
            Date sqlOrderDate = rs.getDate("orderDate");
            LocalDate javaOrderDate = sqlOrderDate.toLocalDate();
            String orderStatus = rs.getString("orderStatus");
            double totalCost = rs.getDouble("totalCost");
            return new Order(orderID, cartID, javaOrderDate, orderStatus, totalCost);
        }
        return null;
    }

    public void saveActiveOrder(int customerID) throws SQLException {
        Order activeOrder = findActiveOrder(customerID);
        String orderStatus = "Saved";
        if (activeOrder != null) {
            updateOrderStatus(activeOrder.getOrderID(), orderStatus);
        }
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

    public void cancelOrder(int orderID) throws SQLException {
        String orderStatus = "Cancelled";
        updateOrderStatus(orderID, orderStatus);
    }

    public void submitOrder(int orderID) throws SQLException {
        Order submittedOrder = findOrder(orderID);
        String fetch = "SELECT * FROM IOTUSER.cartline WHERE cartID = " + submittedOrder.getCartID();
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            decreaseProductQuantity(productID, quantity);
        }
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
    public void createPayment(int paymentID, int orderID, int customerID, String cardNumber, String cardName, String cardExpiry, int cvv, String paymentDate) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.payment VALUES (" + paymentID + ", " + orderID + ", " + customerID + ", '" + cardNumber + "', '" + cardName + "', '" + cardExpiry + "', '" + cvv + "', '" + paymentDate + "')");
    }

    // View saved order payment details
    public ArrayList<Payment> viewPaymentDetails(int orderID) throws SQLException {
        String fetch = "SELECT * from IOTUSER.payment WHERE orderID = " + orderID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> temp = new ArrayList();

        while (rs.next()) {
            int returnedOrderID = rs.getInt(2);
                if (returnedOrderID==orderID) {
                    int paymentID = rs.getInt(1);
                    int customerID = rs.getInt(3);
                    String cardNumber = rs.getString(4);
                    String cardName = rs.getString(5);
                    String cardExpiry = rs.getString(6);
                    int cvv = rs.getInt(7);
                    String paymentDate = rs.getString(8);
                    temp.add(new Payment(paymentID, returnedOrderID, customerID, cardNumber, cardName, cardExpiry, cvv, paymentDate));
            }
        }
        return temp;
    }

    // View order history list
    public ArrayList<Payment> viewOrderHistory(int customerID) throws SQLException {
        String fetch = "SELECT * from IOTUSER.payment WHERE customerID = " + customerID;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> temp = new ArrayList();

        while (rs.next()) {
            int returnedCustomerID = rs.getInt(3);
            if (returnedCustomerID==customerID) {
                int paymentID = rs.getInt(1);
                int orderID = rs.getInt(2);
                String cardNumber = rs.getString(4);
                String cardName = rs.getString(5);
                String cardExpiry = rs.getString(6);
                int cvv = rs.getInt(7);
                String paymentDate = rs.getString(8);
                temp.add(new Payment(paymentID,orderID,returnedCustomerID,cardNumber,cardName,cardExpiry,cvv,paymentDate));
            }
        }
        return temp;
    }

    // Search payment records based on paymentID and date
    public ArrayList<Payment> searchPaymentRecords(int paymentID, String paymentDate) throws SQLException {
        String fetch = "SELECT * from IOTUSER.payment WHERE paymentID = " + paymentID + " OR paymentDate = '" + paymentDate + "'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> temp = new ArrayList();

        while (rs.next()) {
            int returnedPaymentID = rs.getInt(1);
            String returnedPaymentDate = rs.getString(8);
            if (returnedPaymentID==paymentID && returnedPaymentDate.equals(paymentDate)) {
                int orderID = rs.getInt(2);
                int customerID = rs.getInt(3);
                String cardNumber = rs.getString(4);
                String cardName = rs.getString(5);
                String cardExpiry = rs.getString(6);
                int cvv = rs.getInt(7);
                temp.add(new Payment(returnedPaymentID,orderID,customerID,cardNumber,cardName,cardExpiry,cvv,returnedPaymentDate));
            }
        }
        return temp;
    }

    // Update details
    public void updatePayment(int paymentID, String cardNumber, String cardName, String cardExpiry, int cvv, String paymentDate) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.payment WHERE paymentID = " + paymentID + " SET cardnumber = '" + cardNumber + "', cardname = '" + cardName + "', cardexpiry = '" + cardExpiry + "', cardcvv = '" + cvv + "', '" + paymentDate + "'");
    }

    // Delete details
    public void deletePayment(int paymentID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.payment WHERE paymentID = " + paymentID);
    }

/* Product Database */
/* Shipping Database */
/* Staff Database */

     public boolean checkStaff(String emailAddress) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.staff WHERE staffEmailAddress = '" + emailAddress + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffEmailAddress = rs.getString("staffEmailAddress");
            if (staffEmailAddress.equals(emailAddress)) {
            return true;
            }
        }
        return false;
}

    // Checks if email and password match
    public Staff findStaff(String emailAddress, String password) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.staff WHERE staffEmailAddress = '" + emailAddress + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffEmailAddress = rs.getString("staffEmailAddress");
            String staffPass = rs.getString("staffPass");

            if (staffEmailAddress.equals(emailAddress) && staffPass.equals(password)) {
                int staffID = rs.getInt("staffID");
                String staffFName = rs.getString("staffFName");
                String staffLName = rs.getString("staffLName");
                String staffContactNumber = rs.getString("staffContactNumber");
                return new Staff(staffID, staffFName, staffLName, staffEmailAddress, staffPass, staffContactNumber);
            }
        }
        return null;
    }

    public Staff updateStaff (int staffID, String staffFName, String staffLName, String staffEmailAddress, String staffPass, String staffContactNumber) throws SQLException{
        st.executeUpdate("UPDATE IOTUSER.staff SET staffFName= '" + staffFName + "', staffLName = '" + staffLName + "', staffPass = '" + staffPass + "', staffContactNumber = '" + staffContactNumber + "' WHERE staffID = " + staffID );
        return new Staff(staffID, staffFName, staffLName, staffEmailAddress, staffPass, staffContactNumber);
    }

    /* Product*/
    //Create product (staff only)
    public void createProduct(int productID, String productName, String productType, String productSupplier, String productDescription, double productCost, int quantityAvailable) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.product " + "VALUES (" + productID + ", '" + productName + "', '" + productType + "', '" + productSupplier + "', '" + productDescription + "', " + productCost + ", " + quantityAvailable + ")");
        //return new Product(productID, productName, productType, productSupplier, productDescription, productCost, quantityAvailable);
    }

    //Read/Find a product (customer or staff)
    //List all device records
    public boolean checkProduct(int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int existingProductID = rs.getInt(1);
            if (productID == existingProductID) {
                return true;
            }
        }
        return false;
    }

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

    public Product fetchIndividualProduct(int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String productName = rs.getString("productName");
            String productType = rs.getString("productType");
            String productSupplier = rs.getString("productSupplier");
            String productDescription = rs.getString("productDescription");
            double productCost = rs.getDouble("productCost");
            int quantityAvailable = rs.getInt("quantityAvailable");
            return new Product(productID, productName, productType, productSupplier, productDescription, productCost, quantityAvailable);
        }
        return null;
    }

    public Product getIndividualProduct(int productID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.product WHERE productID = " + productID;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            String productName = rs.getString(2);
            String productType = rs.getString(3);
            String productSupplier = rs.getString(4);
            String productDescription = rs.getString(5);
            double productCost = rs.getDouble(6);
            int quantityAvailable = rs.getInt(7);
            Product individualProduct = new Product(productID, productName, productType, productSupplier, productDescription, productCost, quantityAvailable);
            return individualProduct;
        }
        return null;
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
