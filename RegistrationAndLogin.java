 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class RegistrationAndLogin {
    //method to check user name
    public static boolean checkUserName(String userName){
        return userName.contains("_") && userName.length()<=5 ;
    }
    
    //method to check user's password
    public static boolean checkPasswordComplexity(String passWord){
        return passWord.length()>=8 &&
               passWord.matches(".*[A-Z].*") && 
               passWord.matches(".*[0-9].*") &&
               passWord.matches(".*[!@#$%^&].*") ;
                
    }
    
    //method to check user's cellphone number
    public static boolean checkPhoneNumberComplexity(String cellPhoneNumber) {
        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
                
                
                public static void main(String[] args) {
                System.out.println("\n_____Register User______");
               
                Scanner input = new Scanner(System.in);

                System.out.print("Enter your First Name:");
                String firstName = input.nextLine();

                System.out.print("Enter your Last Name: ");
                String lastName = input.nextLine(); 

                
                //loop is added for the user to place in their accurate Username.
                 String userName;
                 boolean checkUserName;
                 //to check whether the username is valid or not
     do {
            System.out.print("Enter your Username: ");
            userName = input.nextLine();
            
            if (!checkUserName(userName)) {
                System.out.println("Username is not correctly formatted; please ensure that your Username contains an underscore and no more than five charcters in length. ");
            }
             
        } while (!checkUserName(userName));
        System.out.println("Useranme succesffully captured");
     

        //loop is added for the user to enter their accurate password requirments
       String passWord ; 
       boolean checkPasswordComplexity ;
   
        
        do{
                System.out.print("Enter your Password: ");
                passWord =input.nextLine();

                checkPasswordComplexity = checkPasswordComplexity(passWord);
                
            if (!checkPasswordComplexity(passWord)) {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character . ");
            }
    
        } while(!checkPasswordComplexity(passWord));
                System.out.println("Password successfully captured.");

    
        
    String cellPhoneNumber ;
    boolean checkPhoneNumber ;
        
        do{ 
                System.out.println("Enter your Cellphone Number: ");
                cellPhoneNumber = input.nextLine();
                checkPhoneNumber = checkPhoneNumberComplexity(cellPhoneNumber);
                
            if (!checkPhoneNumberComplexity(cellPhoneNumber)) {
                System.out.println("Cell Phoner numeber incorrectly formatted or does not contain international code. ");
            }

        }while(!checkPhoneNumberComplexity(cellPhoneNumber));
                System.out.println("Cell phone number successfully added");
                
                //login object
                UserLogin login = new UserLogin();
                
                //User Registered
                System.out.println(login.registerUser(userName, passWord,  firstName,  lastName));
                  //LOGIN SECTION
                    
                System.out.println("\n______Login User:______");
                
                
                //
                String usernameLogin;
                String passwordLogin;
                boolean feedback;
                
                do{

                System.out.print("Enter your Username: ");
                usernameLogin = input.nextLine();

                System.out.print("Enter your Password: ");
                passwordLogin = input.nextLine();

                feedback = login.loginUser(usernameLogin, passwordLogin);
                
                if (!feedback) {
                    System.out.println("Username or password is incorrect; please try again.");
                }
                
                }while(!feedback);
               
    
               System.out.println(login.returnLoginStatus(feedback));
               
  ArrayList<Message> sentMessages = new ArrayList<>();

System.out.println("\n_______ QUICKCHAT _______");
System.out.println("Welcome to QuickChat! " + firstName + " " + lastName);

System.out.print("How many messages would you like to send? ");

int totalMessages = input.nextInt();
input.nextLine();

int messageCount = 0;

// program keeps running until the user reaches the message limit
while (messageCount < totalMessages) {

    System.out.println("\nChoose an option:");
    System.out.println("1. Send Messages");
    System.out.println("2. Show recently sent messages");
    System.out.println("3. Quit");

    int option = input.nextInt();
    input.nextLine();

    switch (option) {

        case 1:

            // checks if the user already reached the limit
            if (messageCount >= totalMessages) {

                System.out.println("Message limit reached.");
                break;
            }

            System.out.print("Enter recipient number: ");
            String recipient = input.nextLine();

            System.out.print("Enter your message: ");
            String text = input.nextLine();

            // creating the message object
            Message msg = new Message(
                    messageCount + 1,
                    recipient,
                    text
            );

            // shows whether the cellphone number is valid
            System.out.println(msg.checkRecipientCell());

            // checks if the message length is acceptable
            String messageFeedback = msg.checkMessageLength();
            System.out.println(messageFeedback);

            // only continues if the message is valid
            if (messageFeedback.equals("Message ready to send.")) {

                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Send Message");
                System.out.println("2. Store Message");
                System.out.println("3. Delete Message");

                int choice = input.nextInt();
                input.nextLine();

                System.out.println(msg.sentMessage(choice));

                // stores sent or saved messages in the array list
                if (choice == 1 || choice == 2) {

                    sentMessages.add(msg);

                    messageCount++;

                    // displays message details back to the user
                    System.out.println(msg.printMessage());

                    System.out.println(
                            "Messages completed: "
                            + messageCount
                            + " of "
                            + totalMessages
                    );
                }
            }

            break;

        case 2:

            // feature still needs to be added
            System.out.println("Coming Soon.");
            break;

        case 3:

            // exits the application completely
            System.out.println("Exiting QuickChat...");

            System.out.println(
                    "Total messages sent: "
                    + Message.returnTotalMessages()
            );

            System.exit(0);
            break;

        default:

            // handles invalid menu choices
            System.out.println("Invalid option selected.");
    }
}
    
        input.close();
               
    }
}
                

            
        
        
        
        
    
       


        
 