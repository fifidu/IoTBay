/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
import java.util.HashMap;

public class CartLine {

    private int cartID;
    private int productID;
    private int quantity;
    private HashMap<Integer, Integer> cartItems;

    public CartLine(int cartID) {
        this.cartID = cartID;
        cartItems = new HashMap<>();
    }

    public int getCartID() {
        return this.cartID;
    }

    public int getProductID() {
        return this.productID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
