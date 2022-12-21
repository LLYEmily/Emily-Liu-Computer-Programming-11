package GuessingGame;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;

public class Controller {

    public TextField textGetNumber;
    public Label lblRandomNum;
    public Label lblResult;
    public int points = 0;
    public int RN;
    public int number;
    public Label Points;


    public void rollNumber(ActionEvent actionEvent) {
        Random random = new Random();
        RN = random.nextInt(6) + 1;
        lblRandomNum.setText(Integer.toString(RN));
        number = Integer.parseInt(textGetNumber.getText());

        if (number > 6 || number < 1) {
            lblResult.setText("Error, check your input");
        } else if (number == RN) {
            lblResult.setText("Win");
            points++;
            Points.setText(Integer.toString(points));
        } else {
            lblResult.setText("Lose");
        }

    }
}

