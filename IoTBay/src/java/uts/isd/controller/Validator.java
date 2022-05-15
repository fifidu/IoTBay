/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.controller;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fifidu
 */
public class Validator implements Serializable {
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "[A-Z][a-z]*";       
    private String passwordPattern = "[a-z0-9]{4,}"; 
    private String contactNumberPattern = "[0-9]{10,}";
    private String cardNumberPattern = "[0-9]{16}";
    private String cardNamePattern = "([A-Z][a-z]*+[\\s])+[A-Z][a-z]*";
    private String paymentDatePattern = "202+[0-9]{1}+-+[0-1]{1}+[0-9]{1}+-+[0-3]{1}+[0-9]{1}";
    private String cvvPattern = "[0-9]{4}";

    public Validator(){}

    public boolean validate(String pattern, String input){       
        Pattern regEx = Pattern.compile(pattern);       
        Matcher match = regEx.matcher(input);       

        return match.matches(); 

    }       

    public boolean checkEmpty(String email, String password){       
        return  email.isEmpty() || password.isEmpty();   
    }

    public boolean validateEmail(String email){                       
        return validate(emailPattern,email);   
    }

    public boolean validateName(String name){
        return validate(namePattern,name); 
    }       
   
    public boolean validatePassword(String password){
        return validate(passwordPattern,password); 
    }

    public boolean validateContactNumber(String contactNumber) {
        return validate(contactNumberPattern, contactNumber);
    }

    public void clear(HttpSession session) {
        session.setAttribute("emailFormatErr", "");
        session.setAttribute("passFormatErr", "");
        session.setAttribute("confirmPassErr", "");
        session.setAttribute("nameFormatErr", "");
        session.setAttribute("contactFormatErr", "");
        session.setAttribute("existingAccountErr", "");
        session.setAttribute("incorrectPassErr", "");
        session.setAttribute("unregisteredErr", "");
    }

    //Validations for Product-related inputs
    public boolean validateID(String enteredID) {
        try {
            Integer.parseInt(enteredID);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validateCost(String enteredCost) {
        try {
            Double.parseDouble(enteredCost);
            return true;
        }
        catch (NumberFormatException | NullPointerException ex) {
            return false;
        }
    }

    public void clearProduct(HttpSession session) {
        session.setAttribute("prodIDFormatErr", "");
        session.setAttribute("prodCostFormatErr", "");
        session.setAttribute("prodQuantityFormatErr", "");
        session.setAttribute("existingProductErr", "");
        session.setAttribute("prodEditSuccess", "");
        session.setAttribute("prodCreateSuccess", "");
        session.setAttribute("prodDelSuccess", "");
    }

    // Validations for adding item to order


    // Validations for payment related stuff
    public boolean validateCardNumber(String enteredCardNo) {
        return validate(cardNumberPattern,enteredCardNo);
    }

    public boolean validateCardName(String enteredCardName) {
        return validate(cardNamePattern,enteredCardName);
    }

    public boolean validatePaymentDatePattern(String enteredDate) {
        return validate(paymentDatePattern,enteredDate);
    }

    public boolean validateCvv(String enteredCvv) {
        return validate(cvvPattern,enteredCvv);
    }

    public void clearPayment(HttpSession session) {
        session.setAttribute("payIDFormatErr", "");
        session.setAttribute("ordIDFormatErr", "");
        session.setAttribute("cusIDFormatErr", "");
        session.setAttribute("cardNoFormatErr", "");
        session.setAttribute("cardNameFormatErr", "");
        session.setAttribute("cardExpFormatErr", "");
        session.setAttribute("cvvFormatErr", "");
        session.setAttribute("existingPaymentErr", "");
        session.setAttribute("paymentDetailsCreated", "");
        session.setAttribute("paymentDelSuccess", "");
        session.setAttribute("nonexistentPaymentErr", "");
    }

}
