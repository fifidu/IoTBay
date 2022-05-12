/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */

public class CartLine {

    private int cartID;
    private int productID;
    private String productName;
    private String orderStatus;
    private double productCost;
    private int quantity;
    private double itemTotal;
    private double totalCost;

    // Initial Constructor for database purposes
    public CartLine(int cartID, int productID, int quantity) {
        this.cartID = cartID;
        this.productID = productID;
        this.quantity = quantity;
    }

    // Constructor for displaying information to JSP
    public CartLine(int cartID, int productID, String productName, String orderStatus, double productCost, int quantity, double itemTotal, double totalCost) {
        this.cartID = cartID;
        this.productID = productID;
        this.productName = productName;
        this.orderStatus = orderStatus;
        this.productCost = productCost;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
        this.totalCost = totalCost;
    }

    public int getCartID() {
        return this.cartID;
    }

    public int getProductID() {
        return this.productID;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public double getProductCost() {
        return this.productCost;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getItemTotal() {
        return this.itemTotal;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
