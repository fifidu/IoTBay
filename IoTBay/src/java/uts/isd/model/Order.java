/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

import java.time.LocalDate;

/**
 *
 * @author chrisvuong
 */
public class Order {

    private int orderID;
    private int cartID;
    private LocalDate orderDate;
    private String orderStatus;
    private double totalCost;

    public Order(int orderID, int cartID, LocalDate orderDate, String orderStatus, double totalCost) {
        this.orderID = orderID;
        this.cartID = cartID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalCost = totalCost;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getCartID() {
        return this.cartID;
    }

    public LocalDate getOrderDate() {
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

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
