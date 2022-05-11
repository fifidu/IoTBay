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
    private double productCost;
    private int quantity;
    private double total;

    public CartLine(int cartID, int productID, int quantity) {
        this.cartID = cartID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public CartLine(int cartID, int productID, String productName, double productCost, int quantity, double total) {
        this.cartID = cartID;
        this.productID = productID;
        this.productName = productName;
        this.productCost = productCost;
        this.quantity = quantity;
        this.total = total;
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

    public double getProductCost() {
        return this.productCost;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotal() {
        return this.total;
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

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
