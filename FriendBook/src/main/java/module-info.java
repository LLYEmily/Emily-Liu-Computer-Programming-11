module friendbook.friendbook {
    requires javafx.controls;
    requires javafx.fxml;


    opens friendbook.friendbook to javafx.fxml;
    exports friendbook.friendbook;
}