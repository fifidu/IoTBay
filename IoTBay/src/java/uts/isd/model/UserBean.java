/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author chrisvuong
 */
public class UserBean implements java.io.Serializable {
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String password;
    private Boolean tos;

    public UserBean() {

    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public String getPassword() {
        return this.password;
    }

    public Boolean getTos() {
        return this.tos;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTos(Boolean tos) {
        this.tos = tos;
    }

}
