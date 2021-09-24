package ua.abdulaiev.hw16.task4;

import java.util.List;

class Student {
    private static final int COURSE = 6;
    private final String name;
    private final String group;
    private int course;
    private final double grade;

    Student(String name, String group, int course, double grade) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grade = grade;
    }

    public static void removeStudent(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).grade < 3 || list.get(i).course == 7) {
                list.remove(i);
                i--;
            }
        }
    }

    public static void movesNextCourse(List<Student> list) {
        for (Student student : list) {
            if (student.grade >= 3) {
                student.course++;
            }
        }
    }

    public static void printStudyThisCourse(List<Student> list) {
        for (int i = 1; i <= COURSE; i++) {
            System.out.println("Course " + i +  ": ");
            Student.printStudents(list, i);
            System.out.println();
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name + " " + student.group);
            }
        }
    }

}
