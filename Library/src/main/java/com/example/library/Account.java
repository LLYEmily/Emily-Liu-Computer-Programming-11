package com.example.library;
import java.io.*;

public class Account {
    String name;
    String password;
    boolean loggedIn;
    //Constructor
    //Requires: String, String
    //Modifies: none
    //Effects: creates Account object
    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.loggedIn = false;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean getLoggedIn() {
        return loggedIn;
    }

    //Method to record the information in to file
    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("Account.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",");
        bw.write(password + ",");
        bw.write(loggedIn + ";");
        bw.write("\n");
        bw.close();
    }

    //change the memory to String
    public String toString () {
        return name;
    }
}
