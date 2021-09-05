package ua.abdulaiev.hw7;

public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Ivan", "Ivanov", "Group1", 4.5);
        Aspirant aspirant1 = new Aspirant("Petr", "Petrov", "Group2", 5, "Work1");
        Student aspirant2 = new Aspirant("Petr", "Sidorov", "Group3", 4.8, "Work2");
        Student[] students = {student, aspirant1,aspirant2};
        for (Student s: students) {
            System.out.println(s.getScholarship());
        }
    }
}
