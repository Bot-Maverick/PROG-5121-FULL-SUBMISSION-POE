package com.mycompany.mychatapp;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
class Register {
    

   //Stores the information that will be registered
    private String storedFirstName;
    private String storedLastName;
    private String storedUsername;
    private String storedPassword;
    private String storedPhone;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {

        if (password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    public boolean checkPhone(String phone) {

        if (!phone.startsWith("+27")) return false;
        if (phone.length() != 12) return false;

        for (int i = 3; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public void register(Scanner sc) {

        System.out.println("=== REGISTRATION ===");

        //Will capture first name and last name of user
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("First Name Succesfully Captured");

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Last Name Successfully Captured");

        //If username does not meet requirements, will ask user to try again
        while (true) {
            System.out.print("Create Username: ");
            String username = sc.nextLine();

            if (checkUserName(username)) {
             System.out.println("Username Successfully Created");
                storedUsername = username;
                break;
            } else {
                System.out.println("Invalid Username, Try Again...");
            }
        }
       //If password does not meet requirements, will ask user to try again
        while (true) {
            System.out.print("Create Password: ");
            String password = sc.nextLine();

            if (checkPassword(password)) {
              System.out.println("Password Successfully Created");
                storedPassword = password;
                break;
            } else {
                System.out.println("Invalid Password, Try Again...");
            }
        }

         //If phone number does not meet requirements, will ask user to try again
        while (true) {
            System.out.print("Enter Phone Number (+27): ");
            String phone = sc.nextLine();

            if (checkPhone(phone)) {
            System.out.println("Phone Number Successfully Captured");
                storedPhone = phone;
                break;
            } else {
                System.out.println("Invalid Phone Number, Try Again...");
            }
        }

        System.out.println("Registration Successful!");
    }

    // Getters to pass data to login
    public String getUsername() {
        return storedUsername;
    }

    public String getPassword() {
        return storedPassword;
    }

    public String getFirstName() {
        return storedFirstName;
        
    }
    }