package friendbook.friendbook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controller {
    public TextField textGetName;
    public TextField textGetAge;
    public Label lblName;
    public Label lblAge;
    public Label lblBirthday;
    public Label lblFC;
    public TextField textGetBirthday;
    public TextField textGetFC;
    public ListView<Friend> FriendListD = new ListView<>();
    public ListView<Friend> FriendListE = new ListView<>();

    // Requires: action-event from button
    // Modifies: add person in list and display text
    // Effects: method to add friends from the list
    public void addFriend(ActionEvent actionEvent) throws IOException{
        String name = textGetName.getText();
        int age = Integer.parseInt(textGetAge.getText());
        String birthday = textGetBirthday.getText();
        String FC = textGetFC.getText();
        Friend temp = new Friend (name, age, birthday, FC);
        FriendListD.getItems().add(temp);
        FriendListE.getItems().add(temp);
        textGetAge.clear();
        textGetName.clear();
        textGetBirthday.clear();
        textGetFC.clear();
        //copy it to Friend.txt
        ObservableList<Friend> myList = FriendListE.getItems();
        for (Friend f : myList) {
            f.writeToFile();
        }
    }
    // Requires: mouse-event from listview
    // Modifies: display text in the lbl
    // Effects: to view the Friends List
    public void viewList(MouseEvent mouseEvent) {
        Friend temp;
        temp = FriendListD.getSelectionModel().getSelectedItem();
        lblName.setText(temp.getName());
        lblAge.setText(Integer.toString(temp.getAge()));
        lblBirthday.setText(temp.getBirthday());
        lblFC.setText(temp.getFavouriteColor());
    }
    // Requires: action-event from button
    // Modifies: delete person in list and display text
    // Effects: method to remove friends from the list
    public void removeFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = FriendListE.getSelectionModel().getSelectedItem();
        FriendListD.getItems().remove(temp);
        FriendListE.getItems().remove(temp);
        lblName.setText("");
        lblAge.setText("");
        lblBirthday.setText("");
        lblFC.setText("");
    }
}