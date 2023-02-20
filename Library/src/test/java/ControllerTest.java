import com.example.library.BorrowList;
import com.example.library.Controller;
import javafx.collections.FXCollections;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testAddBook() {
        //Set up the input fields with valid data
        controller.lbAName.setText("John");
        controller.textGetABook.setText("The Great Gatsby");
        controller.textGetAAuthor.setText("F. Scott Fitzgerald");
        controller.textGetAGenre.setText("Fiction");

        //call the AddBook method
        try {
            controller.AddBook(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // assert that the input fields have been cleared
        assertEquals("", controller.textGetABook.getText());
        assertEquals("", controller.textGetAAuthor.getText());
        assertEquals("", controller.textGetAGenre.getText());

        // assert that the Reminder label is empty
        assertEquals("", controller.Reminder.getText());
    }

    @Test
    public void testAddBookEmptyFields() {
        // set up the input fields with empty book title
        controller.lbAName.setText("John");
        controller.textGetABook.setText("");
        controller.textGetAAuthor.setText("F. Scott Fitzgerald");
        controller.textGetAGenre.setText("Fiction");

        // call the AddBook method
        try {
            controller.AddBook(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // assert that the input fields have not been cleared
        assertEquals("", controller.textGetABook.getText());
        assertEquals("F. Scott Fitzgerald", controller.textGetAAuthor.getText());
        assertEquals("Fiction", controller.textGetAGenre.getText());

        // assert that the Reminder label displays the correct message
        assertEquals("Please Enter Something", controller.Reminder.getText());
    }
    @Test
    public void testBorrowBook() throws IOException {
        Controller controller = new Controller();
        File testBookFile = new File("testBook.txt");
        File testBorrowListFile = new File("testBorrowList.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(testBookFile));
        writer.write("Test Book,Test Author,Test Genre,Test Owner,false\n");
        writer.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(testBorrowListFile));
        bw.write("Test Book,Test Owner,Test Borrower,2023-02-10\n");
        bw.close();
        // Set up the GUI elements needed for the test
        List<String> bbListItems = new ArrayList<>();
        bbListItems.add("Test Book");
        controller.BBList.setItems(FXCollections.observableList(bbListItems));
        controller.lbAName.setText("Test Borrower");
        // Call the BorrowBook method
        controller.BorrowBook(null);
        // Verify that the book file was modified correctly
        BufferedReader bookReader = new BufferedReader(new FileReader(testBookFile));
        String bookLine = bookReader.readLine();
        Assertions.assertEquals("Test Book,Test Author,Test Genre,Test Borrower,true", bookLine);
        bookReader.close();
        //Verify that the borrow list file was updated correctly
        BufferedReader borrowListReader = new BufferedReader(new FileReader(testBorrowListFile));
        String borrowListLine = borrowListReader.readLine();
        Assertions.assertEquals("Test Book,Test Owner,Test Borrower," + LocalDate.now().toString(), borrowListLine);
        borrowListReader.close();
        Assertions.assertEquals(1, controller.AccBList.getItems().size());
        BorrowList borrowedBook = (BorrowList) controller.AccBList.getItems().get(0);
        Assertions.assertEquals("Test Book", borrowedBook.getBookName());
        Assertions.assertEquals("Test Owner", borrowedBook.getOwner());
        Assertions.assertEquals("Test Borrower", borrowedBook.getBorrower());
        Assertions.assertEquals(LocalDate.now().toString(), borrowedBook.getTime());
        // Verify that the labels were cleared
        Assertions.assertTrue(controller.BBList.getItems().isEmpty());
        Assertions.assertTrue(controller.lbTitle.getText().isEmpty());
        Assertions.assertTrue(controller.lbAuthor.getText().isEmpty());
        Assertions.assertTrue(controller.lbGenre.getText().isEmpty());
        Assertions.assertTrue(controller.lbOwner.getText().isEmpty());
    }


    @Test
    public void testViewBList() throws IOException {
        // Set up a test file with a book
        String testBookTitle = "Test Book";
        String testBookAuthor = "Test Author";
        String testBookGenre = "Test Genre";
        String testBookOwner = "Test Owner";
        File testBookFile = new File("testBook.txt");
        FileWriter testBookWriter = new FileWriter(testBookFile);
        testBookWriter.write(testBookTitle + ", " + testBookAuthor + ", " + testBookGenre + ", " + testBookOwner + "\n");
        testBookWriter.close();
        // Add the test book to the Borrowed Books list
        controller.BBList.getItems().add(testBookTitle);
        // Call the ViewBList method with the test book selected
        controller.ViewBList(null);
        // Check that the book details labels have been updated
        assertEquals(testBookTitle, controller.lbTitle.getText());
        assertEquals(testBookAuthor, controller.lbAuthor.getText());
        assertEquals(testBookGenre, controller.lbGenre.getText());
        assertEquals(testBookOwner, controller.lbOwner.getText());
    }

    @Test
    public void testLogIn_shouldLogInSuccessfully() throws IOException {
        // Set up test data
        String username = "user1";
        String password = "password1";
        Path accountFilePath = Paths.get("Account.txt");
        Files.write(accountFilePath, "user1,password1,false;\nuser2,password2,false;\n".getBytes());

        // Call the method under test
        controller.textGetLogName.setText(username);
        controller.textGetLogPW.setText(password);
        controller.LogIn(null);

        // Check the results
        assertEquals("Login successful", controller.lbLogInRemind.getText());
        assertEquals(username, controller.lbAName.getText());
        assertEquals(password, controller.lbAPassword.getText());

        // Check that the login status has been updated in the Account.txt file
        String accountFileContents = Files.readString(accountFilePath);
        assertTrue(accountFileContents.contains("user1,password1,true;"));
    }

    @Test
    public void testLogIn_shouldShowErrorMessage() throws IOException {
        // Set up test data
        String username = "user1";
        String password = "password1";
        Path accountFilePath = Paths.get("Account.txt");
        Files.write(accountFilePath, "user2,password2,false;\n".getBytes());

        // Call the method under test
        controller.textGetLogName.setText(username);
        controller.textGetLogPW.setText(password);
        controller.LogIn(null);

        // Check the results
        assertEquals("Incorrect username or password", controller.lbLogInRemind.getText());
        assertEquals("", controller.lbAName.getText());
        assertEquals("", controller.lbAPassword.getText());

        // Check that the login status has not been updated in the Account.txt file
        String accountFileContents = Files.readString(accountFilePath);
        assertFalse(accountFileContents.contains("user1,password1,true;"));
    }
}


