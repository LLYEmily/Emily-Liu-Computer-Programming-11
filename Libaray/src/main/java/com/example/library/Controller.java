package com.example.library;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.time.LocalDate;

public class Controller {
    public ListView BBList; //Borrow Book List
    public ListView AccBList; //Account Borrow List
    public ListView AccBookList; //Account Book List
    public TextField textGetName;
    public TextField textGetABook;
    public TextField textGetAAuthor;
    public TextField textGetAGenre;
    public TextField textGetPassword;
    public TextField textGetLogPW;
    public TextField textGetLogName;
    public Label lbAName;
    public Label lbAPassword;
    public Label lbTitle;
    public Label lbAuthor;
    public Label lbGenre;
    public Label lbOwner;
    public Label lbLogInRemind;
    public Label Reminder;
    public Label Reminder1;

     // Requires: action-event from button, access to the GUI elements, Book class
     // Modifies: Books in Book.txt, contents of reminder
     // Effects: adds a new book to Book.txt with the information entered in the text fields
    public void AddBook(ActionEvent actionEvent) throws IOException {
        // Check if the name label is empty
        if (lbAName.getText().isEmpty()) {
            Reminder.setText("Please Log in or Sign Up first!");
            // Check if the book title field is empty
        } else if (textGetABook.getText().isEmpty()) {
            Reminder.setText("Please Enter Something");// Display a reminder message
        } else {
            // Get the book title, author, genre, and owner from the input fields
            String Title = textGetABook.getText();
            String Author = textGetAAuthor.getText();
            String Genre = textGetAGenre.getText();
            String Owner = lbAName.getText();
            // Create a new Book object with the provided information
            Book temp = new Book(Title, Author, Genre, Owner);
            // Write the new book to a file
            temp.writeToFile();
            // Clear the input fields
            textGetABook.clear();
            textGetAAuthor.clear();
            textGetAGenre.clear();
            // Clear the reminder message
            Reminder.setText("");
        }
    }

    // Requires: action-event from button, the BorrowBookList (BBList) is not null, the book file "Book.txt" is present and accessible
    // Modifies: the book file "Book.txt", the AccBList, the selection and labels in the BorrowBook section
    // Effects: updates the book availability status, adds a new entry to the borrower's list, and clears the selection and labels in the BorrowBook section
    public void BorrowBook(ActionEvent actionEvent) throws IOException {
        // Get the selected item from the Borrowed Books List
        String temp = (String) BBList.getSelectionModel().getSelectedItem();
        // Get the current date as a string
        String date = String.valueOf(LocalDate.now());
        // Open the Book.txt file for reading
        FileReader fr = new FileReader("Book.txt");
        BufferedReader br = new BufferedReader(fr);
        // Use a StringBuilder to build the modified file contents
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            String[] book = line.split(";");
            for (String Books : book) {
                String[] BookFields = Books.split(",");
                String Title = BookFields[0];
                String Owner = BookFields[3];
                // If the selected book matches the current book being read from the file
                if (temp.equals(Title)) {
                    // Set the "borrowed" field to true in the file
                    line = line.replace("false", "true");
                    // Create a new BorrowList object and add it to the Borrowed Books list
                    BorrowList temp1 = new BorrowList(temp, Owner, lbAName.getText(), date);
                    AccBList.getItems().add(temp1);
                    temp1.writeToFile();
                }
            }
            // Add the modified line to the StringBuilder
            sb.append(line).append("\n");
        }
        br.close();
        // Write the modified contents back to the Book.txt file
        BufferedWriter writer = new BufferedWriter(new FileWriter("Book.txt"));
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        // Clear the Borrowed Books list and reset the book details labels
        BBList.getItems().clear();
        lbTitle.setText("");
        lbAuthor.setText("");
        lbGenre.setText("");
        lbOwner.setText("");
    }

    // Requires: mouseEvent for viewBList, access to the GUI elements, Book.txt
    // Modifies: read contents in Book.txt, labels in the BookList section
    // Effects: show the detail information of the book that get from the Book.txt by clicking the listview
    public void ViewBList(MouseEvent mouseEvent) throws IOException {
        //Get the object being clicked
        String temp = (String) BBList.getSelectionModel().getSelectedItem();
        //read the Book.txt
        FileReader fr = new FileReader("Book.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            //check if each line in Book.txt starts with the object being clicked
            if (line.startsWith(temp)) {
                String[] fields = line.split(",");
                String title = fields[0].trim();
                String author = fields[1].trim();
                String genre = fields[2].trim();
                String owner = fields[3].trim();
                //set the label to the information get in the Book.txt
                this.lbTitle.setText(title);
                this.lbAuthor.setText(author);
                this.lbGenre.setText(genre);
                this.lbOwner.setText(owner);
            }
        }
    }

    // Requires: action-event from button, Book.txt
    // Modifies: add an object in to the book List
    // Effects: read the file in the Book.txt and add it in to the Book list
    public void LoadBook(ActionEvent actionEvent) throws IOException {
        BBList.getItems().clear();
        //read the Book.txt file
        FileReader fr = new FileReader("Book.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            String title = fields[0].trim();
            //if not borrowed, add to the Book List
            if (line.endsWith(",false;")) {
                BBList.getItems().add(title);
            }
        }
    }

    // Requires: action-event from button, access to the GUI elements, specifically the AccBList, lbAName
    // Modifies: add the list of books borrowed by the user in to the AccBList by searching and reading the BorrowList.txt file and display it
    // Effects: loads and displays the list of books borrowed by the user in the AccBList in the GUI
    public void LoadAccB(ActionEvent actionEvent) throws IOException {
        AccBList.getItems().clear();
        //read file borrowList
        FileReader fr = new FileReader("BorrowList.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        //read through each line
        while ((line = br.readLine()) != null) {
            //search and create variable with each info between each ","
            String[] fields = line.split(",");
            String bookName = fields[0].trim();
            String owner = fields[1].trim();
            String borrower = fields[2].trim();
            String time = fields[3].trim();
            //if the person log in now is same with the borrower, if yes, add the book they borrowed to the AccBList
            if (lbAName.getText().equals(borrower)) {
                AccBList.getItems().add("Book Name: " + bookName + " Owner: " + owner + " Borrower: " + borrower + "Date: " + time);
            }
        }
    }

    // Requires: action-event from button, access to the GUI elements, Book.txt, BorrowList.txt
    // Modifies: Add book into AccBookList
    // Effects: Add the book that the user added into AccBookList so that the user can see the book they uploaded and can check who borrowed it
    public void LoadAccBook(ActionEvent actionEvent) throws IOException {
        AccBookList.getItems().clear();
        //read Book.txt
        FileReader fr = new FileReader("Book.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            //split every book in line with ";"
            String[] book = line.split(";");
            for (String Books : book) {
                //split the info of the book with ","
                String[] fields = Books.split(",");
                String bookName = fields[0].trim();
                String owner = fields[3].trim();
                boolean checkedOut = Boolean.parseBoolean(fields[4].trim());
                //check the person that logged in is the owner of the book
                if (lbAName.getText().equals(owner)) {
                    //if yes, check if the book has been borrowed already
                    if(!checkedOut) {
                        //if not add the book to the Book List in my account with the notice that it is still available to borrow it
                        AccBookList.getItems().add("Book Name: " + bookName + "    Available to Borrow");
                    } else {
                        //if the book is already borrowed, read through the borrowList.txt
                        FileReader f = new FileReader("BorrowList.txt");
                        BufferedReader b = new BufferedReader(f);
                        String line1;
                        while ((line1 = b.readLine()) != null) {
                            //separate each info with ","
                            String[] parts = line1.split(",");
                            String bookTitle = parts[0].trim();
                            String bookOwner = parts[1].trim();
                            String borrower = parts[2].trim();
                            String time = parts[3].trim();
                            //check if the book title in the BorrowList.txt and the Book.txt is the same
                            if (bookTitle.equals(bookName)) {
                                //if yes, add the book in to the Book List in my account and display who borrow it and what time
                                String temp = "Book: " + bookTitle + "  Borrowed by: " + borrower + " on " + time;
                                AccBookList.getItems().add(temp);
                            }
                        }
                    }
                }
            }
        }
    }
    // Requires: action-event from button, access to the GUI elements, Account.txt
    // Modifies: Add an account in to the Account.txt
    // Effects: Get the information on in the text fields and create a new user and save it in to the Account file
    public void SignUp(ActionEvent actionEvent) throws IOException {
        //get the information in the text fields
        String name = textGetName.getText();
        String password = textGetPassword.getText();
        //create a new account with the name and password
        Account temp = new Account(name, password);
        //person logged in
        temp.loggedIn = true;
        //write the info into the Account.txt
        temp.writeToFile();
        //set label in my account to this name and password
        lbAName.setText(name);
        lbAPassword.setText(password);
        //clear the text field
        textGetName.clear();
        textGetPassword.clear();
    }
    // Requires: action-event from button, access to the GUI elements, Account.txt
    // Modifies: Get info in the text fields and compare it with the info in the Account.txt and log in
    // Effects: login into and Account, and compare the password and username
    public void LogIn(ActionEvent actionEvent) throws IOException {
        //get the username and password in the text field
        String username = textGetLogName.getText();
        String password = textGetLogPW.getText();
        textGetLogName.clear();
        textGetLogPW.clear();
        //use the login method to check if the password and username is in the Account.txt and correct
        if (login(username, password, "Account.txt")) {
            //if yes, display login successful
            lbLogInRemind.setText("Login successful");
            lbAName.setText(username);
            lbAPassword.setText(password);
            //read Account.txt
            FileReader fr = new FileReader("Account.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                String[] accounts = line.split(";");
                for (String account : accounts) {
                    String[] accountFields = account.split(",");
                    //check through each line and name to find the same with the logged-in user now
                    if ((lbAName.getText()).equals(accountFields[0])) {
                        //change the login status from false to true
                        line = line.replace("false", "true");
                    }
                }
                sb.append(line).append("\n");
            }
            br.close();
            //rewrite the info to the Account.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt"));
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        } else {
            //if logged in method return false
            lbLogInRemind.setText("Incorrect username or password");
        }
    }

    // Requires: String name, String password, String fileName
    // Modifies: check if the login username is correct with the password
    // Effects: return boolean if the login is used
    public boolean login(String name, String password, String fileName) throws IOException {
        // Start a new fileReader to read the specified fileName
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] accounts = line.split(";");
            for (String account : accounts) {
                String[] accountFields = account.split(",");
                //check if the username and password in one line is same with the username and password entered
                if (name.equals(accountFields[0]) && password.equals(accountFields[1])) {
                    //if yes, return true
                    br.close();
                    return true;
                }
            }
        }
        br.close();
        //else, return false
        return false;
    }
    // Requires: action-event from button, access to the GUI elements, Account.txt
    // Modifies: change the user status in the Account.txt and the label
    // Effects: change the status of the user to logged out
    public void LogOut(ActionEvent actionEvent) throws IOException {
        //read through the Account.txt
        FileReader fr = new FileReader("Account.txt");
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            //check if the line contains the user that logged in now
            if (line.contains(lbAName.getText())) {
                //if yes, change the status from true(logged in) to false(logged out)
                line = line.replace(",true", ",false");
            }
            sb.append(line).append("\n");
        }
        br.close();
        //rewrite the info in to Account.txt with the new status
        BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt"));
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        //reset the label in my account
        lbAName.setText(" ");
        lbAPassword.setText(" ");
        AccBookList.getItems().clear();
        AccBList.getItems().clear();
    }
}