/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
public class Customer {

    private int customerID;
    private String cusFName;
    private String cusLName;
    private String cusEmailAddress;
    private String cusPass;
    private String cusContactNumber;

    public Customer(int customerID, String cusFName, String cusLName, String cusEmailAddress, String cusPass, String cusContactNumber) {
        this.customerID = customerID;
        this.cusFName = cusFName;
        this.cusLName = cusLName;
        this.cusEmailAddress = cusEmailAddress;
        this.cusPass = cusPass;
        this.cusContactNumber = cusContactNumber;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCusFName() {
        return this.cusFName;
    }

    public String getCusLName() {
        return this.cusLName;
    }

    public String getCusEmailAddress() {
        return this.cusEmailAddress;
    }

    public String getCusPass() {
        return this.cusPass;
    }

    public String getCusContactNumber() {
        return this.cusContactNumber;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCusFName(String cusFName) {
        this.cusFName = cusFName;
    }

    public void setCusLName(String cusLName) {
        this.cusLName = cusLName;
    }

    public void setCusEmailAddress(String cusEmailAddress) {
        this.cusEmailAddress = cusEmailAddress;
    }

    public void setCusPass(String cusPass) {
        this.cusPass = cusPass;
    }

    public void setCusContactNumber(String cusContactNumber) {
        this.cusContactNumber = cusContactNumber;
    }

}
