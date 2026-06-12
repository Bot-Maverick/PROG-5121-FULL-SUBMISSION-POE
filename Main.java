package com.mycompany.mychatapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Register register = new Register();
        register.register(sc);

        Login login = new Login(
                register.getUsername(),
                register.getPassword());

        login.login(sc);

        QuickChat quickChat = new QuickChat();
        quickChat.startChat(sc);

        sc.close();
    }
}