public class Main {
    public static void main(String[] args) {
        //Set the school, students, and teachers' name and info
        School LB = new School("Lord Byng", "16th Crown", 2000);
        Student studentA = new Student("Emily","Liu", "Ten");
        Student studentB = new Student("Melanie","Li", "Twelve");
        Student studentC = new Student("Amy","Chen", "Three");
        Student studentD = new Student("Alex","Wang", "Three");
        Student studentE = new Student("Sophia","Song", "Ten");
        Student studentF = new Student("Kevin","Li", "Ten");
        Student studentG = new Student("YanNi","Gu", "Ten");
        Student studentH = new Student("Celeste","Cao", "Eleven");
        Student studentI = new Student("Vivian","Wang", "Eleven");
        Student studentJ = new Student("Iris","Guo", "Eleven");
        Teacher teacherA = new Teacher("Ke", "Hu", "Math");
        Teacher teacherB = new Teacher("YuJia", "Bai", "Mandarin");
        Teacher teacherC = new Teacher("Jessica", "Erwin", "English");

        //add student and teacher
        LB.addStudent(studentA);
        LB.addStudent(studentB);
        LB.addStudent(studentC);
        LB.addStudent(studentD);
        LB.addStudent(studentE);
        LB.addStudent(studentF);
        LB.addStudent(studentG);
        LB.addStudent(studentH);
        LB.addStudent(studentI);
        LB.addStudent(studentJ);
        LB.addTeacher(teacherA);
        LB.addTeacher(teacherB);
        LB.addTeacher(teacherC);

        //print
        System.out.println(LB.listTeachers());
        System.out.println(LB.listStudents());

        //remove
        LB.removeStudent(studentB);
        LB.removeStudent(studentJ);
        LB.removeTeacher(teacherA);

        //print
        System.out.println(LB.listTeachers());
        System.out.println(LB.listStudents());
    }
}
