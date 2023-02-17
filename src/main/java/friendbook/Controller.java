package friendbook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

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
    public Button Save;
    public Button Load;
    public Button Export;
    public TextField textGetExportFile;
    public ListView<File> FileList = new ListView<>();
    public Button LoadAll;

    // Requires: action-event from button
    // Modifies: add person in list and display text
    // Effects: method to add friends from the list
    public void addFriend(ActionEvent actionEvent) {
        String name = textGetName.getText();
        int age = Integer.parseInt(textGetAge.getText());
        String birthday = textGetBirthday.getText();
        String FC = textGetFC.getText();
        Friend temp = new Friend(name, age, birthday, FC);
        FriendListD.getItems().add(temp);
        FriendListE.getItems().add(temp);
        textGetAge.clear();
        textGetName.clear();
        textGetBirthday.clear();
        textGetFC.clear();
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
    // Modifies: save all the friends into a file
    // Effects: method to save all the friends from a list to a file
    public void SaveFriend(ActionEvent actionEvent) throws IOException {
        // Get the list of friends from the "Edit Friend" list view
        ObservableList<Friend> myList = FriendListE.getItems();
        // For each friend in the list, write its information to a file
        for (Friend f : myList) {
            f.writeToFile();
        }
        // Add the file to the "File List" list view
        FileList.getItems().add(new File("Friend.txt"));
        // Clear the "Edit Friend" list view
        FriendListE.getItems().clear();
    }

    // Requires: action-event from button
    // Modifies: Load friends from a specific file and display it
    // Effects: method to load friends out from a file
    public void LoadFriend(ActionEvent actionEvent) throws IOException {
        FriendListD.getItems().clear();
        // Get the selected file from the "File List" list view
        File selectedFile = FileList.getSelectionModel().getSelectedItem();
        // Create a list of friends from the selected file
        ArrayList<Friend> friends = CreateFriend.createAllFriends(selectedFile);
        // Add each friend from the list to the "Display Friend" list view
        for (Friend f : friends) {
            FriendListD.getItems().add(f);
        }
    }

    // Requires: action-event from button
    // Modifies: add a friend in a specific file
    // Effects: method to export friends to a file
    public void ExportFriends(ActionEvent actionEvent) throws IOException {
        FriendListD.getItems().clear();
        // Get the selected friend from the "Edit Friend" list view
        Friend temp;
        temp = FriendListE.getSelectionModel().getSelectedItem();
        // Get the information for the selected friend
        String name = temp.name;
        int age = temp.age;
        String birthday = temp.birthday;
        String favouriteColor = temp.favouriteColor;
        // Get the name of the file to export to from the text field
        String fileName = textGetExportFile.getText();
        // Add the file to the "File List" list view
        FileList.getItems().add(new File(fileName + ".txt"));
        // Open the file and write the friend's information to it
        FileWriter fw = new FileWriter(fileName + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(age + ",\r");
        bw.write(birthday + ",\r");
        bw.write(favouriteColor + "\r");
        bw.write(";\r");
        bw.close();
    }

    // Requires: action-event from button
    // Modifies: Load all the friends and display it
    // Effects: method to load all the friends out from a file
    public void LoadAllFriend(ActionEvent actionEvent) throws IOException {
        FriendListE.getItems().clear();
        // Create a list of friends from the "Friend.txt" file
        ArrayList<Friend> friends = CreateFriend.createAllFriends(new File("Friend.txt"));
        // Add each friend from the list to the "Edit Friend" list view
        for (Friend f : friends) {
            FriendListE.getItems().add(f);
        }
    }
}
