/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

import java.time.LocalDateTime;
/**
 *
 * @author chrisvuong
 */
public class OrderBean implements java.io.Serializable {

    private int orderID;
    private int customerID;
    private int cartID;
    private int paymentID;
    private int shippingID;
    private LocalDateTime orderDate;
    private String paymentStatus;
    private String fulfillmentStatus;
    private double totalCost;

    public OrderBean() {

    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public int getCartID() {
        return this.cartID;
    }

    public int getPaymentID() {
        return this.paymentID;
    }

    public int getShippingID() {
        return this.shippingID;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public String getFulfillmentStatus() {
        return this.fulfillmentStatus;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
}
