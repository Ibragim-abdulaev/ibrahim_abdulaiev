package ua.abdulaiev.hw16.task2;

import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        String text = "Block Abdulaev Abcissa Hello Abdulaev abdulaev abcissa hello Hello";
        treeMap(text);
    }

    public static void treeMap(String text) {
        String[] st = text.replaceAll("[^ a-zA-Zа-яА-ЯёЁ]", " ").split(" +");
        Map<String, Integer> map = new TreeMap<>();
        for (String value : st) {
            Integer count = map.get(value);
            if (count == null) {
                count = 0;
            }
            map.put(value, ++count);
        }
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
