package ua.abdulaiev.hw15.task2;

import java.util.TreeSet;

public class Task2 {
    public static void main(String[] args) {
        BoxComparator boxComparator = new BoxComparator();
        TreeSet<Box> treeSet = new TreeSet<>(boxComparator);
        treeSet.add(new Box(0));
        treeSet.add(new Box(4));
        treeSet.add(new Box(12));
        treeSet.add(new Box(2));
        treeSet.add(new Box(0));

        for (Box box: treeSet) {
            System.out.println(box.value);
        }
    }
}
