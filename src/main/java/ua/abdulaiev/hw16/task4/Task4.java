package ua.abdulaiev.hw16.task4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ivan", "KIT-1", 1, 2.9));
        list.add(new Student("Dmitry", "KIT-2", 3, 3.1));
        list.add(new Student("Alexei", "KIT-3", 6, 3.6));
        list.add(new Student("Oleg", "KIT-4", 2, 1.8));
        list.add(new Student("Nikita", "KIT-4", 2, 3.7));
        list.add(new Student("Stas", "KIT-4", 2, 2.5));
        list.add(new Student("Artem", "KIT-5", 5, 5));
        list.add(new Student("Inna", "KIT-6", 4, 4.5));

        Student.printStudyThisCourse(list);
        Student.removeStudent(list);
        System.out.println("****DELETE STUDENT****" + System.lineSeparator());
        Student.printStudyThisCourse(list);
        System.out.println("****MOVES NEXT COURSE****" + System.lineSeparator());
        Student.movesNextCourse(list);
        Student.printStudyThisCourse(list);
    }
}
