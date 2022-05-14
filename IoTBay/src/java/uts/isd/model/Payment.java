/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment {

    private int paymentID;
    private int orderID;
    private int cardNumber;
    private String cardName;
    private String cardExpiryString;
    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime cardExpiry = LocalDateTime.parse(cardExpiryString, formattedDate);
    private int cvv;

    public Payment(int paymentID, int orderID, int cardNumber, String cardName, LocalDateTime cardExpiry, int cvv) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardExpiry = cardExpiry;
        this.cvv = cvv;
    }

    public int getPaymentID() {
        return this.paymentID;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public String getCardName() {
        return this.cardName;
    }

    public int getCvv() {
        return this.cvv;
    }

    public LocalDateTime getCardExpiry() {
        return this.cardExpiry;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardExpiry(LocalDateTime cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
