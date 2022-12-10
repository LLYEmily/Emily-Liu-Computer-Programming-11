//Insert Arraylist
import java.util.ArrayList;

public class School {
    //Create Arraylist
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();

    private String Name;
    private String Address;
    private int NumberOfStudents;

    //Set school info (constructor)
    School(String Name, String Address, int NumberOfStudents) {
        this.Name = Name;
        this.Address = Address;
        this.NumberOfStudents = NumberOfStudents;
    }

    //print teacher
    public String listTeachers() {
        String output = "";
        for (Teacher teacher : teachers) {
            output = output + "\n" + teacher;
        }
        return output;
    }

    //Print Students
    public String listStudents() {
        String output = "";
        for (Student student : students) {
            output = output + "\n" + student;
        }
        return output;
    }
    //Getter&Setter
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getNumberOfStudents() {
        return NumberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        NumberOfStudents = numberOfStudents;
    }

    //Add and remove teachers or students
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

}

