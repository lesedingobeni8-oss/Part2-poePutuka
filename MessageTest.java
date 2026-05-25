package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckMessageID() {

        Message msg = new Message(1,"0821234567","Hello");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testRecipientSuccess() {

        Message msg = new Message(1,"0821234567", "Hello");

        assertEquals("Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testRecipientFailure() {

        Message msg = new Message(
                1,
                "12345",
                "Hello"
        );

        assertEquals(
                "Cell phone number is incorrectly formatted.",
                msg.checkRecipientCell()
        );
    }

    // Test message length success
    @Test
    public void testMessageLengthSuccess() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello Mike"
        );

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength()
        );
    }

    @Test
    public void testMessageLengthFailure() {

        String longText = "";

        for (int i = 0; i < 260; i++) {

            longText += "A";
        }

        Message msg = new Message(1,"0821234567",longText);

        assertTrue(msg.checkMessageLength().contains("Message exceeds 250 characters"));
    }

    @Test
    public void testMessageHash() {

        Message msg = new Message(1,"0821234567","Hi World");

        String hash = msg.getMessageHash();

        assertTrue(hash.contains(":1:HIWORLD"));
    }

    @Test
    public void testSendMessage() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello"
        );

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage(1)
        );
    }

    @Test
    public void testStoreMessage() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello"
        );

        assertEquals(
                "Message successfully stored.",
                msg.sentMessage(2)
        );
    }

    @Test
    public void testDiscardMessage() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello"
        );

        assertEquals(
                "Press 0 to delete message.",
                msg.sentMessage(3)
        );
    }

    @Test
    public void testInvalidOption() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello"
        );

        assertEquals(
                "Invalid option.",
                msg.sentMessage(99)
        );
    }

    @Test
    public void testPrintMessage() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello"
        );

        String output = msg.printMessage();

        assertTrue(output.contains("Message ID"));
        assertTrue(output.contains("Recipient"));
        assertTrue(output.contains("Message"));
    }

    @Test
    public void testGetters() {

        Message msg = new Message(
                1,
                "0821234567",
                "Hello"
        );

        assertNotNull(msg.getMessageID());

        assertEquals(
                "0821234567",
                msg.getRecipient()
        );

        assertEquals(
                "Hello",
                msg.getMessage()
        );

        assertNotNull(msg.getMessageHash());
    }
}