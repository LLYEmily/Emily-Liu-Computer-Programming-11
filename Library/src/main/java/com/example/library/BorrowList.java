package com.example.library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BorrowList {
    String bookName;
    String owner;
    String borrower;
    String date;
    //Constructor
    //Requires: String, String, String, String
    //Modifies: none
    //Effects: creates BorrowList object
    public BorrowList(String bookName, String owner, String borrower, String date){
        this.bookName = bookName;
        this.owner = owner;
        this.borrower = borrower;
        this.date = date;
    }

    //Getters
    public String getBorrower() {
        return borrower;
    }
    public String getOwner() {
        return owner;
    }
    public String getBookName() {
        return bookName;
    }
    public String getTime() {
        return date;
    }

    //Method to record the information in to file
    public void writeToFile () throws IOException {
        FileWriter fw = new FileWriter("BorrowList.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(bookName + ",");
        bw.write(owner + ",");
        bw.write(borrower + ",");
        bw.write(date + ";");
        bw.write("\n");
        bw.close();
    }

    //change the memory to String
    public String toString() {
        return "Book: " + bookName + "   Owner: " + owner + "    Borrower: " + borrower + "    Date: " + date;
    }
}
