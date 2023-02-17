package friendbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    String name;
    int age;
    String birthday;
    String favouriteColor;

    //Constructor
// Requires: string, int, string, string
// Modifies: none
// Effects: creates friend object
    Friend(String n, int a, String b, String fC) {
        name = n;
        age = a;
        birthday = b;
        favouriteColor = fC;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    //Method to record the information in to file
    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("Friend.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(age + ",\r");
        bw.write(birthday + ",\r");
        bw.write(favouriteColor + "\r");
        bw.write(";\r");
        bw.close();
    }

    //change the memory to String
    public String toString() {
        return name;
    }

}
