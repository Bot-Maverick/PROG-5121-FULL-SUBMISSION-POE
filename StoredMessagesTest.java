/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author TEBOGO
 */
public class StoredMessagesTest {
    
    public StoredMessagesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of displaySenderRecipient method, of class StoredMessages.
     */
    @Test
    public void testDisplaySenderRecipient() {
        System.out.println("displaySenderRecipient");
        StoredMessages instance = new StoredMessages();
        instance.displaySenderRecipient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class StoredMessages.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        StoredMessages instance = new StoredMessages();
        instance.displayLongestMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMessageID method, of class StoredMessages.
     */
    @Test
    public void testSearchMessageID() {
        System.out.println("searchMessageID");
        String messageID = "";
        StoredMessages instance = new StoredMessages();
        instance.searchMessageID(messageID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRecipient method, of class StoredMessages.
     */
    @Test
    public void testSearchRecipient() {
        System.out.println("searchRecipient");
        String recipient = "";
        StoredMessages instance = new StoredMessages();
        instance.searchRecipient(recipient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMessage method, of class StoredMessages.
     */
    @Test
    public void testDeleteMessage() {
        System.out.println("deleteMessage");
        String hash = "";
        StoredMessages instance = new StoredMessages();
        instance.deleteMessage(hash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayReport method, of class StoredMessages.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        StoredMessages instance = new StoredMessages();
        instance.displayReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
