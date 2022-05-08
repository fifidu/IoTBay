/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
public class Cart {

    private int cartID;
    private int customerID;

    public Cart(int cartID, int customerID) {
        this.cartID = cartID;
        this.customerID = customerID;
    }

    public int getCartID() {
        return this.cartID;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

}
