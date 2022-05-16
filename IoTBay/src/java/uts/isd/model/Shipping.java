/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
import java.time.LocalDate;

public class Shipping {
    private int trackingID;
    private int orderID;
    private String carrierCode;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressCountry;
    private String addressPostal;
    private String orderStatus;
    private LocalDate receivedDate;
    private LocalDate despatchDate;
    private LocalDate deliveryDate;

    public Shipping(int trackingID, int orderID, String carrierCode, String addressStreet, String addressCity, String addressState, String addressCountry, String addressPostal, String orderStatus, LocalDate receivedDate, LocalDate despatchDate, LocalDate deliveryDate) {
        this.trackingID = trackingID;
        this.orderID = orderID;
        this.carrierCode = carrierCode;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressCountry = addressCountry;
        this.addressPostal = addressPostal;
        this.orderStatus = orderStatus;
        this.receivedDate = receivedDate;
        this.despatchDate = despatchDate;
        this.deliveryDate = deliveryDate;
    }

    public int getTrackingID() {
        return this.trackingID;
    }

    public int getOrderID() {
        return this.orderID;
    }
    
    public String getCarrierCode() {
        return this.carrierCode;
    }
    
    public String getCarrierName() {
        if (this.carrierCode.equals("AUP")){
            return "Australia Post";
        } else if (this.carrierCode.equals("DHL")){
            return "DHL";
        } else if (this.carrierCode.equals("FDX")){
            return "FedEX";
        } else {
            return null;
        }
    }

    public String getAddressStreet() {
        return this.addressStreet;
    }

    public String getAddressCity() {
        return this.addressCity;
    }

    public String getAddressState() {
        return this.addressState;
    }

    public String getAddressCountry() {
        return this.addressCountry;
    }

    public String getAddressPostal() {
        return this.addressPostal;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public LocalDate getReceivedDate() {
        return this.receivedDate;
    }
    
    public LocalDate getDespatchDate() {
        return this.despatchDate;
    }
    
    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setTrackingID(int trackingID) {
        this.trackingID = trackingID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public void setAddressPostal(String addressPostal) {
        this.addressPostal = addressPostal;
    }

    public void setorderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }
    
    public void setDespatchDate(LocalDate despatchDate) {
        this.despatchDate = despatchDate;
    }
    
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
