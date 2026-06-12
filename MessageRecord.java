package com.mycompany.mychatapp;

public class MessageRecord {

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private String flag;

    public MessageRecord(
            String messageID, String recipient, String message, String flag, String messageHash) {

        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        this.flag = flag;
        this.messageHash = messageHash;
    }

    MessageRecord() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getFlag() {
        return flag;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getHash() {
        return messageHash;
    }
}