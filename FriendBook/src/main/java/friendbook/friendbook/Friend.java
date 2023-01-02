package friendbook.friendbook;

public class Friend {
    String name;
    int age;
    String birthday;
    String favouriteColor;
//Constructor
    Friend(String n, int a, String b, String fC){
        name = n;
        age = a;
        birthday = b;
        favouriteColor = fC;
    }
//getters
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
//change the memory to String
    public String toString () {
        return name;
    }

}
