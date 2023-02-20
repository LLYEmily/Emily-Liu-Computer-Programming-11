package com.example.library;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Book {
    static String title;
    static String author;
    static String genre;
    static String owner;
    public static boolean checkedOut;

    //Constructor
    //Requires: String, String, String, String, String
    //Modifies: none
    //Effects: creates Book object
    public Book(String title, String author, String genre, String owner) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.owner= owner;
        this.checkedOut = false;
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public String getOwner(){
        return owner;
    }
    public boolean getCheckedOut() {
        return checkedOut;
    }

    //Method to record the information in to file
    public void writeToFile () throws IOException {
        FileWriter fw = new FileWriter("Book.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(title + ",");
        bw.write(author + ",");
        bw.write(genre + ",");
        bw.write(owner + ",");
        bw.write(checkedOut + ";");
        bw.write("\n");
        bw.close();
    }

    //change the memory to String
    public String toString () {
        return title;
    }
}
