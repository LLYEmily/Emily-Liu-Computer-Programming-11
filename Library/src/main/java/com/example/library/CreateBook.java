package com.example.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Created but didn't make it word, because it always repeats the output

//Eg.
//Input Book
//The Great Gatsby,F. Scott Fitzgerald,Novel,false;
//Hamlet,William Shakespeare,Play,false;
//In Search of Lost Time,Marcel Proust,Philosophical fiction,false;

//Expect Output
//The Great Gatsby
//Hamlet
//In Search of Lost Time

//Actual Output
//In Search of Lost Time
//In Search of Lost Time
//In Search of Lost Time

public class CreateBook {
    private String title;
    private String author;
    private String genre;
    private String owner;
    private boolean checkedOut;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Book> books = new ArrayList<>();

    public static ArrayList<Book> createAllBooks(String file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Book> books = new ArrayList<>();
        String line;
        String bookString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                bookString += line;
            } else {
                String[] fields = bookString.split(",");
                String title = fields[0].trim();
                String author = fields[1].trim();
                String genre = fields[2].trim();
                String owner = fields[3].trim();
                boolean checkedOut = Boolean.parseBoolean(fields[4].trim());
                Book b = new Book(title, author, genre, owner);
                books.add(b);
                bookString = "";
            }
        }
        return books;
    }
}
