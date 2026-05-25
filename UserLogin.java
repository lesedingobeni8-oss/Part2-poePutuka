/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;

/**
 *
 * @author Student
 */
public class UserLogin{
    private String firstname;
    private String lastname;
    private String validUsername;
    private String validPassword;
    
    public static boolean checkUserName(String userName){
        return userName.contains("_") && userName.length()<=5 ;
    }
    
    public static boolean checkPasswordComplexity(String passWord){
        return passWord.length()>=8 &&
               passWord.matches(".*[A-Z].*") && 
               passWord.matches(".*[0-9].*") &&
               passWord.matches(".*[!@#$%^&].*") ;
    }
    
    public static boolean checkPhoneNumberComplexity(String cellPhoneNumber) {
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
    
    public String registerUser(String userName, String passWord, String firstName, String lastName) {
        if (!RegistrationAndLogin.checkUserName(userName)) {
        return "Username is incorrectly formatted.";
    }
        if (!RegistrationAndLogin.checkPasswordComplexity(passWord)) {
            return "Password does not meet the required conditions. ";
            
        }
        
        //store the data required for login
        this.firstname = firstName;
        this.lastname = lastName;
        this.validPassword = passWord;
        this.validUsername = userName;
        
        return "User successfully registered.";
        
    }
        //login user
    public boolean loginUser(String userName, String passWord ) {
        return userName.equals(validUsername) && passWord.equals(validPassword);
    }
     
    public String returnLoginStatus(boolean feedback) {
       if (feedback) {
           return "Welcome " + firstname + lastname + ", it is great to see you again!" ;
       }else {
           return " Username or Password is incorrect " ;
       }
    }

    boolean userRegistered(String userName, String passWord, String firstName, String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
    
    