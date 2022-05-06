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
    private LocalDateTime orderDate;
    private String orderStatus;
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

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public String getOrderStatus() {
        return this.orderStatus;
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

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String paymentStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
