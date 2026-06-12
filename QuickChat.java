package com.mycompany.mychatapp;

import java.util.Scanner;

public class QuickChat {

    public void startChat(Scanner sc) {

        System.out.println("Welcome to QuickChat");

        int totalMessages;

        // Ask user how many messages they want to send
        while (true) {

            try {

                System.out.print("How many messages would you like to send? ");

                totalMessages =
                        Integer.parseInt(
                                sc.nextLine()
                        );

                if (totalMessages > 0) {

                    break;

                } else {

                    System.out.println("Enter a number greater than 0.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter numbers only.");
            }
        }

        // Loop only for selected amount
        for (int count = 1;count <= totalMessages;count++) {

            System.out.println("===== MESSAGE "+ count+ " =====");

            // MESSAGE ID
            String id;

            while (true) {

                System.out.print(
                        "Enter Message ID (10 digits): "
                );

                id = sc.nextLine();

                if (id.matches("\\d{10}")) {

                    break;

                } else {

                    System.out.println("Invalid Message ID.");
                }
            }

            // RECIPIENT NUMBER
            String recipient;

            while (true) {

                System.out.print("Enter Recipient Number (+27): ");

                recipient = sc.nextLine();

                if (recipient.matches("\\+27\\d{9}")) {

                    System.out.println("Cell number successfully captured.");

                    break;

                } else {

                    System.out.println("Cell number incorrectly formatted.");
                }
            }

            // MESSAGE TEXT
            String text;

            while (true) {

                System.out.print("Enter Message (max 250 characters): ");

                text = sc.nextLine();

                if (!text.isEmpty()
                        && text.length() <= 250) {

                    break;

                } else {

                    System.out.println("Message must not be empty.");
                }
            }

            // CREATE MESSAGE OBJECT
            Message msg =
                    new Message(
                            id,
                            recipient,
                            text
                    );

            // DISPLAY RESULTS
            System.out.println("Valid Message ID: "+ msg.checkMessageID());

            System.out.println("Valid Recipient Number: "+ msg.checkRecipientCell());

            System.out.println("Message Hash: "+ msg.createMessageHash());

            // SEND MESSAGE
            boolean continueApp =
                    msg.sentMessage(sc);

            if (!continueApp) {

                break;
            }

            // DISPLAY ALL MESSAGES
            System.out.println("===== ALL SENT MESSAGES =====");

            Message.printMessages();

            // TOTAL
            System.out.println("Total Messages: "+ Message.returnTotalMessages());
        }

        System.out.println("Program Finished.");
    }
}