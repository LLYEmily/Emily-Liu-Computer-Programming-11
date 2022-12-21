module com.example.guilesson {
    requires javafx.controls;
    requires javafx.fxml;


    opens GuessingGame to javafx.fxml;
    exports GuessingGame;
}