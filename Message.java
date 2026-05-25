package com.mycompany.registrationandlogin;

import java.io.FileWriter;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessages = 0;

    // Constructor for creating a message object
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        messageID = generateMessageID();
        messageHash = createMessageHash();

        totalMessages++;
    }

    // Generates a random 10 digit message ID
    private String generateMessageID() {

        Random random = new Random();

        long randomNumber = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(randomNumber);
    }

    // Checks if the message ID is valid
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Validates the recipient cellphone number
    public String checkRecipientCell() {

        if (recipient.matches("^\\+27\\d{9}$")
                || recipient.matches("^0\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted.";
        }
    }

    // Creates a message hash using message details
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord + lastWord;
    }

    // Checks whether the message is within the limit
    public String checkMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extraCharacters = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extraCharacters
                    + ", please reduce size.";
        }
    }

    // Handles send/store/delete options
    public String sentMessage(int choice) {

        switch (choice) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Message successfully stored.";

            case 3:
                return "Press 0 to delete message.";

            default:
                return "Invalid option.";
        }
    }

    // Displays message information
    public String printMessage() {

        return "\n-------------------------"
                + "\nMessage ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message
                + "\n-------------------------";
    }

    // Stores the message in a JSON file
    public void storeMessage() {

        try {

            FileWriter writer = new FileWriter("storedMessages.json", true);

            writer.write("{\n");
            writer.write("\"MessageID\":\"" + messageID + "\",\n");
            writer.write("\"MessageHash\":\"" + messageHash + "\",\n");
            writer.write("\"Recipient\":\"" + recipient + "\",\n");
            writer.write("\"Message\":\"" + message + "\"\n");
            writer.write("}\n\n");

            writer.close();

            System.out.println("Message stored successfully.");

        } catch (Exception e) {

            System.out.println("Error saving message.");
        }
    }

    // Returns the total number of messages created
    public static int returnTotalMessages() {

        return totalMessages;
    }

    // Getter for message ID
    public String getMessageID() {

        return messageID;
    }

    // Getter for recipient number
    public String getRecipient() {

        return recipient;
    }

    // Getter for message text
    public String getMessage() {

        return message;
    }

    // Getter for message hash
    public String getMessageHash() {

        return messageHash;
    }
}