/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
public class Staff {

    private int staffID;
    private String staffFName;
    private String staffLName;
    private String staffEmailAddress;
    private String staffPass;
    private String staffContactNumber;

    public Customer(int staffID, String staffFName, String staffLName, String staffEmailAddress, String staffPass, String staffContactNumber) {
        this.staffrID = staffID;
        this.staffFName = staffFName;
        this.staffLName = staffLName;
        this.staffEmailAddress = staffEmailAddress;
        this.staffPass = staffPass;
        this.staffContactNumber = staffContactNumber;
    }

    public int getStaffID() {
        return this.staffID;
    }

    public String getStaffFName() {
        return this.staffFName;
    }

    public String getStaffLName() {
        return this.staffLName;
    }

    public String getStaffEmailAddress() {
        return this.staffEmailAddress;
    }

    public String getStaffPass() {
        return this.staffPass;
    }

    public String getStaffContactNumber() {
        return this.staffContactNumber;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStaffFName(String staffFName) {
        this.staffFName = staffFName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName = staffLName;
    }

    public void setStaffEmailAddress(String staffEmailAddress) {
        this.staffEmailAddress = staffEmailAddress;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }

    public void setStaffContactNumber(String staffContactNumber) {
        this.staffContactNumber = staffContactNumber;
    }
}
