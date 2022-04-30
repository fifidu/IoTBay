/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
public class CartBean implements java.io.Serializable {

    private int cartID;
    private int customerID;

    public CartBean() {

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
