/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aavuz
 */
public class MessageTest {

    @Test
    public void testRecipientValid() {
        Messages msg = new Messages();

        assertTrue(msg.recipient("+27831234567"));
    }

    @Test
    public void testRecipientInvalid() {
        Messages msg = new Messages();

        assertFalse(msg.recipient("0831234567"));
    }

    @Test
    public void testLengthCheckValid() {
        Messages msg = new Messages();

        String text = "Hello, this is a test message.";
        assertTrue(msg.lengthCheck(text));
    }

    @Test
    public void testLengthCheckInvalid() {
        Messages msg = new Messages();

        String text = "A".repeat(251);
        assertFalse(msg.lengthCheck(text));
    }

    @Test
    public void testCreateMessageHash() {
        Messages msg = new Messages();

        msg.prepareMessage(
                1,
                "+27831234567",
                "Hello World"
        );

        String hash = msg.CreateMessageHash();

        assertNotNull(hash);
        assertTrue(hash.contains(":1:"));
        assertTrue(hash.endsWith("HELLO:WORLD"));
    }

    @Test
    public void testPrepareMessage() {
        Messages msg = new Messages();

        msg.prepareMessage(
                1,
                "+27831234567",
                "Test Message"
        );

        String hash = msg.CreateMessageHash();

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
    }

    @Test
    public void testReturnTotalMessagesSentInitiallyZero() {
        Messages msg = new Messages();

        assertEquals(0, msg.returnTotalMessagesSent());
    }

    @Test
    public void testRecentMessagesInitiallyEmpty() {
        Messages msg = new Messages();

        assertTrue(msg.getRecentMessages().isEmpty());
    }
@Test
public void testArraysArePopulated() {
    Message msg = new Message();
    msg.sentMessage("+27834557896", "Test message 1", 1);
    msg.sentMessage("+27838884567", "Test message 2", 2);
    msg.sentMessage("+27834484567", "Test message 3", 3);
    
    // Verify arrays are populated using reflection or getters
    // This assumes you add getter methods for testing
}

@Test
public void testDisplayLongestMessage() {
    // Create test messages of different lengths
    // Verify longest is correctly identified
    Message.displayLongestMessage(); // Should not throw exceptions
}

@Test
public void testSearchByMessageID() {
    Message.searchByMessageID("1234567890"); // Test with valid/invalid IDs
}

@Test
public void testSearchByRecipient() {
    Message.searchByRecipient("+27838884567"); // Test with test data
}

@Test
public void testDeleteByHash() {
    // Create a test message, get its hash, delete it
    // Verify it's removed
}

@Test
public void testDisplayReport() {
    Message.displayReport(); // Should display without errors
}

    @Test
    public void testRecipientValid() {
        assertTrue(msg.recipient("+27831234567"));
        assertTrue(msg.recipient("+27838884567"));
    }

    @Test
    public void testRecipientInvalid() {
        assertFalse(msg.recipient("0831234567"));
        assertFalse(msg.recipient("1234567890"));
        assertFalse(msg.recipient("+2783")); // Too short
    }

    @Test
    public void testLengthCheckValid() {
        String text = "Hello, this is a test message.";
        assertTrue(msg.lengthCheck(text));
        
        String exactLength = "A".repeat(250);
        assertTrue(msg.lengthCheck(exactLength));
    }

    @Test
    public void testLengthCheckInvalid() {
        String text = "A".repeat(251);
        assertFalse(msg.lengthCheck(text));
        
        String emptyMessage = "";
        assertFalse(msg.lengthCheck(emptyMessage));
    }

    @Test
    public void testCreateMessageHash() {
        String hash1 = msg.generateHash("Hello World");
        assertNotNull(hash1);
        assertTrue(hash1.length() > 0);
        
        // Same message should produce same hash
        String hash2 = msg.generateHash("Hello World");
        assertEquals(hash1, hash2);
        
        // Different message should produce different hash
        String hash3 = msg.generateHash("Different message");
        assertNotEquals(hash1, hash3);
    }
}
