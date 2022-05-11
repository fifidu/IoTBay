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
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressCountry;
    private String addressPostal;
    private String orderStatus;
    private String currentLocation;
    private LocalDate estDelivery;

    public Shipping(int trackingID, int orderID, String addressStreet, String addressCity, String addressState, String addressCountry, String addressPostal, String orderStatus, String currentLocation, LocalDate estDelivery) {
        this.trackingID = trackingID;
        this.orderID = orderID;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressState = addressState;
        this.addressCountry = addressCountry;
        this.addressPostal = addressPostal;
        this.orderStatus = orderStatus;
        this.currentLocation = currentLocation;
        this.estDelivery = estDelivery;
    }

    public int getTrackingID() {
        return this.trackingID;
    }

    public int getOrderID() {
        return this.orderID;
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

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public LocalDate getEstDelivery() {
        return this.estDelivery;
    }

    public void setTrackingID(int trackingID) {
        this.trackingID = trackingID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setEstDelivery(LocalDate estDelivery) {
        this.estDelivery = estDelivery;
    }
    
}
