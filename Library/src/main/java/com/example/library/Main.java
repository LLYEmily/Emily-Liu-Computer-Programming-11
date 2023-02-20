package com.example.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /*
    Purpose:
        The purpose of this project is to act like an online library and to have the function to add book to it
        and borrow book from it. I want to create this project because I have lots of books myself, but I
        already read them all and don't have new books. So, I want to create this project to share with my friends
        and share our books on the app. By having this app, I can create an account, and add books in to the book
        list, same with my friends. In addition, I can also borrow this book from the book list and see
        who is the owner is and ask he/she to borrow the book. Then, when I returned it to them, they can upload
        the book again. However, because of my lack of knowledge and we are not able to use databases, when I tried
        to create a return and a remove button, I'm not able to make it work, and the arraylist doesn't work. So I
        decide to remove these functions. As a result, this app allows people to share their books online and borrow
        it for others, but it can still be improved.

        *****Not a big app that work with large community
        *****Only work between friends and classmate to exchange books
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Library.fxml"));
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root, 600,450));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}