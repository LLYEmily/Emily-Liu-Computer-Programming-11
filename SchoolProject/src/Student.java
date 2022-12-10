//This class create Student object(Student info)
public class Student {
    private String FirstName;
    private String LastName;
    private String Grade;
    static int modelNumber = 1;
    private int StudentID;

    //convert Student info to string
    public String toString() {
        return "Name: " + this.FirstName + " " + this.LastName + " Grade: " + this.Grade;
    }
    //Constructor
     Student(String FirstName, String LastName, String Grade){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Grade = Grade;
        this.StudentID = modelNumber;
        modelNumber++;
    }

    //Getter&Setter
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        this.Grade = grade;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        this.StudentID = studentID;
    }

}
