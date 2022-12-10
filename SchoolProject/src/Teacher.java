//This class create Teacher object(teacher info)
public class Teacher {
    private String FirstName;
    private String LastName;
    private String Subject;

    //Convert teacher info to String
    public String toString() {
        return "Name: " + this.FirstName + " " + this.LastName + " Subject: " + this.Subject;
    }
    //Constructor
     Teacher (String FirstName,String LastName,String Subject){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Subject = Subject;
    }

    //Getter&Setter
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

}
