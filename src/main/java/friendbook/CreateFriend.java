package friendbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static int age;
    private static String birthday;
    private static String favouriteColor;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();
    /*
     * Reads a file containing a list of Friends and creates Friend objects from the data
     * @return an ArrayList of Friend objects created from the data in the file
     * @throws IOException if there is an error reading the file
     */
    public static ArrayList<Friend> createAllFriends(File file) throws IOException {
        // Create FileReader and BufferedReader objects for reading the file
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        // Create an empty ArrayList to store the Friend objects
        ArrayList<Friend> friends = new ArrayList<>();
        String line;
        String friendString = "";
        // Read each line of the file
        while ((line = br.readLine()) != null) {
            // If the line is not the end-of-Friend marker(;), add it to the current friendString
            if (!line.equals(";")) {
                friendString += line;
            } else {
                // Split the friendString into fields using commas as delimiters
                String[] fields = friendString.split(",");
                // Extract the fields and create a new Friend object with them
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                String birthday = fields[2];
                String favouriteColor = fields[3];
                Friend f = new Friend(name.trim(), age, birthday.trim(), favouriteColor.trim());
                // Add the Friend object to the ArrayList
                friends.add(f);
                // Reset the friendString to prepare for the next Friend
                friendString = "";
            }
        }
        // Return the ArrayList of Friend objects
        return friends;
    }
}
