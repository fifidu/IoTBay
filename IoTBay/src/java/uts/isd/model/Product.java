/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
public class Product {
    private int productID;
    private String productName;
    private String productType;
    private String productSupplier;
    private String productDescription;
    private double productCost;
    private int quantityAvailable;
    private int quantitySold;

    public Product(int productID, String productName, String productType, String productSupplier, String productDescription, double productCost, int quantityAvailable, int quantitySold) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productSupplier = productSupplier;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.quantityAvailable = quantityAvailable;
        this.quantitySold = quantitySold;
    }

    public int getProductID() {
        return this.productID;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getProductSupplier() {
        return this.productSupplier;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public double getProductCost() {
        return this.productCost;
    }

    public int getQuantityAvailable() {
        return this.quantityAvailable;
    }

    public int getQuantitySold() {
        return this.quantitySold;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    
}
