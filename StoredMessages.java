package com.mycompany.mychatapp;

import java.util.ArrayList;

public class StoredMessages {

    private ArrayList<MessageRecord> sentMessages =
            new ArrayList<>();

    private ArrayList<MessageRecord> storedMessages =
            new ArrayList<>();

    private ArrayList<MessageRecord> disregardedMessages =
            new ArrayList<>();

    public StoredMessages() {

        loadUserStoredMessages();
    }

    private void loadUserStoredMessages() {

        for (Message msg :
                Message.getStoredMessages()) {

            MessageRecord record =
                    new MessageRecord(
                            msg.getMessageID(),
                            msg.getRecipientCell(),
                            msg.getMessageText(),
                            "Stored",
                            msg.getMessageHash());

            storedMessages.add(record);
        }
    }

    public void displaySenderRecipient() {

        System.out.println("===== STORED MESSAGES =====");

        for (MessageRecord msg : storedMessages) {

            System.out.println("Sender: Developer");
            System.out.println("Recipient: "
                    + msg.getRecipient());
            System.out.println("Message: "
                    + msg.getMessage());
            System.out.println("-------------------");
        }
    }

    public void displayLongestMessage() {

        String longest = "";

        for (MessageRecord msg : storedMessages) {

            if (msg.getMessage().length()
                    > longest.length()) {

                longest = msg.getMessage();
            }
        }

        System.out.println(
                "\nLongest Message:\n"
                        + longest);
    }

    public void searchMessageID(
            String messageID) {

        for (MessageRecord msg :
                storedMessages) {

            if (msg.getMessageID()
                    .equals(messageID)) {

                System.out.println(
                        "Recipient: "
                                + msg.getRecipient());

                System.out.println(
                        "Message: "
                                + msg.getMessage());

                return;
            }
        }

        System.out.println(
                "Message ID not found.");
    }

    public void searchRecipient(
            String recipient) {

        boolean found = false;

        for (MessageRecord msg :
                storedMessages) {

            if (msg.getRecipient()
                    .equals(recipient)) {

                System.out.println(
                        msg.getMessage());

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No messages found.");
        }
    }

    public void deleteMessage(
            String hash) {

        for (int i = 0;
             i < storedMessages.size();
             i++) {

            if (storedMessages.get(i)
                    .getHash()
                    .equals(hash)) {

                System.out.println(
                        "Message: "
                                + storedMessages.get(i)
                                .getMessage()
                                + "Successfully deleted.");

                storedMessages.remove(i);

                return;
            }
        }

        System.out.println(
                "Hash not found.");
    }

    public void displayReport() {

        System.out.println(
                "===== STORED MESSAGE REPORT =====");

        for (MessageRecord msg :
                storedMessages) {

            System.out.println(
                    "Message Hash: "
                            + msg.getHash());

            System.out.println(
                    "Recipient: "
                            + msg.getRecipient());

            System.out.println(
                    "Message: "
                            + msg.getMessage());

            System.out.println(
                    "------------------------");
        }
    }
}
