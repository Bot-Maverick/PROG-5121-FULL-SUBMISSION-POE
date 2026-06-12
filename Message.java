package com.mycompany.mychatapp;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Message {

private String messageID;
private String recipientCell;
private String messageText;
private String messageHash;

private static ArrayList<Message> messages =
        new ArrayList<>();

private static ArrayList<Message> storedMessages =
        new ArrayList<>();

public Message(
        String messageID,
        String recipientCell,
        String messageText) {

    this.messageID = messageID;
    this.recipientCell = recipientCell;
    this.messageText = messageText;
}

// Validate Message ID
public boolean checkMessageID() {

    return messageID.matches("\\d{10}");
}

// Validate Recipient Number
public boolean checkRecipientCell() {

    return recipientCell.matches("\\+27\\d{9}");
}

// Validate Message Length
public boolean checkMessageText() {

    return !messageText.isEmpty()
            && messageText.length() <= 250;
}

// Create Hash
public String createMessageHash() {

    String firstTwo =
            messageID.substring(0, 2);

    String[] words =
            messageText.split(" ");

    String firstWord =
            words[0].toUpperCase();

    String lastWord =
            words[words.length - 1]
                    .toUpperCase();

    messageHash =
            firstTwo + ":"
                    + firstWord
                    + lastWord;

    return messageHash;
}

// QuickChat Menu
public boolean sentMessage(Scanner sc) {

    while (true) {

        System.out.println("===== QUICKCHAT =====");
        System.out.println("1. Send Message");
        System.out.println("2. Store Message");
        System.out.println("3. Show Recently Sent Messages");
        System.out.println("4. Stored Messages");
        System.out.println("5. Quit");

        int choice;

        try {

            choice =
                    Integer.parseInt(
                            sc.nextLine());

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter numbers only.");

            continue;
        }

        switch (choice) {

            case 1:

                messages.add(this);

                saveMessagesToJSON();

                System.out.println(
                        "Message Sent Successfully.");

                return true;

            case 2:

                storedMessages.add(this);

                System.out.println(
                        "Message Stored Successfully.");

                continue;

            case 3:

                System.out.println(
                        "===== FEATURE COMING SOON =====");

                printMessages();

                continue;

            case 4:

                StoredMessages stored =
                        new StoredMessages();

                boolean back = false;

                while (!back) {

                    System.out.println(
                            "===== STORED MESSAGES =====");

                    System.out.println(
                            "1. Display Sender and Recipient");

                    System.out.println(
                            "2. Display Longest Message");

                    System.out.println(
                            "3. Search Message ID");

                    System.out.println(
                            "4. Search Recipient");

                    System.out.println(
                            "5. Delete Message Using Hash");

                    System.out.println(
                            "6. Display Report");

                    System.out.println(
                            "7. Back");

                    int storedChoice;

                    try {

                        storedChoice =
                                Integer.parseInt(
                                        sc.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid input.");

                        continue;
                    }

                    switch (storedChoice) {

                        case 1:
                            stored.displaySenderRecipient();
                            break;

                        case 2:
                            stored.displayLongestMessage();
                            break;

                        case 3:

                            System.out.print(
                                    "Enter Message ID: ");

                            stored.searchMessageID(
                                    sc.nextLine());

                            break;

                        case 4:

                            System.out.print(
                                    "Enter Recipient Number: ");

                            stored.searchRecipient(
                                    sc.nextLine());

                            break;

                        case 5:

                            System.out.print(
                                    "Enter Message Hash: ");

                            stored.deleteMessage(
                                    sc.nextLine());

                            break;

                        case 6:

                            stored.displayReport();

                            break;

                        case 7:

                            back = true;

                            break;

                        default:

                            System.out.println(
                                    "Invalid option.");
                    }
                }

                continue;

            case 5:

                System.out.println(
                        "Application Closed.");

                return false;

            default:

                System.out.println(
                        "Invalid Option.");
        }
    }
}

// Save Sent Messages To JSON
public static void saveMessagesToJSON() {

    try {

        FileWriter writer =
                new FileWriter(
                        "messages.json");

        writer.write("[\n");

        for (int i = 0;
             i < messages.size();
             i++) {

            Message msg =
                    messages.get(i);

            writer.write("  {\n");

            writer.write(
                    "    \"MessageID\": \""
                            + msg.messageID
                            + "\",\n");

            writer.write(
                    "    \"Recipient\": \""
                            + msg.recipientCell
                            + "\",\n");

            writer.write(
                    "    \"Message\": \""
                            + msg.messageText
                            + "\",\n");

            writer.write(
                    "    \"MessageHash\": \""
                            + msg.messageHash
                            + "\"\n");

            if (i < messages.size() - 1) {

                writer.write("  },\n");

            } else {

                writer.write("  }\n");
            }
        }

        writer.write("]");

        writer.close();

    } catch (IOException e) {

        System.out.println(
                "Error saving JSON file.");
    }
}

// Display Sent Messages
public static void printMessages() {

    if (messages.isEmpty()) {

        System.out.println(
                "No sent messages available.");

    } else {

        for (Message msg : messages) {

            System.out.println(
                    "Message ID: "
                            + msg.messageID);

            System.out.println(
                    "Recipient: "
                            + msg.recipientCell);

            System.out.println(
                    "Message: "
                            + msg.messageText);

            System.out.println(
                    "Hash: "
                            + msg.messageHash);

            System.out.println(
                    "----------------------");
        }
    }
}

// Stored Messages Getter
public static ArrayList<Message> getStoredMessages() {

    return storedMessages;
}

// Total Messages
public static int returnTotalMessages() {

    return messages.size();
}

// Getters
public String getMessageID() {
    return messageID;
}

public String getRecipientCell() {
    return recipientCell;
}

public String getMessageText() {
    return messageText;
}

public String getMessageHash() {
    return messageHash;
}

}
