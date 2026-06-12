package com.mycompany.mychatapp;

import java.util.Scanner;

class Login {

private final String storedUsername;
private final String storedPassword;

// Constructor receives registered data
public Login(String username, String password) {
this.storedUsername = username;
this.storedPassword = password;
}

public void login(Scanner sc) {

System.out.println("=== LOGIN ===");

int attempts = 0;

//User will have only 3 attempts to enter correct information
while (attempts < 3) {

System.out.print("Enter Username: ");
String username = sc.nextLine();

System.out.print("Enter Password: ");
String password = sc.nextLine();

if (username.equals(storedUsername) && password.equals(storedPassword)) {
System.out.println("Login Successful. Welcome Back " + username);
return;
} else {
attempts++;
System.out.println("Incorrect. Attempts Left: " + (3 - attempts));
}
}

System.out.println("Too Many Attempts, Account Locked.");
}
}