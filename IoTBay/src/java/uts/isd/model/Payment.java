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

public class Payment {

    private int paymentID;
    private int orderID;
    private int customerID;
    private String cardNumber;
    private String cardName;
    private String cardExpiry;
    private int cvv;
    private LocalDate paymentDate;

    public Payment(int paymentID, int orderID, int customerID, String cardNumber, String cardName, String cardExpiry, int cvv, LocalDate paymentDate) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.customerID = customerID;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardExpiry = cardExpiry;
        this.cvv = cvv;
        this.paymentDate = paymentDate;
    }

    public int getPaymentID() {
        return this.paymentID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getCardExpiry() {
        return this.cardExpiry;
    }

    public int getCvv() {
        return this.cvv;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
