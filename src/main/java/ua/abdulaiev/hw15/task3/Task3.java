package ua.abdulaiev.hw15.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        String line = "Hello";
        String line2 = "Hello  ";
        String line3 = "Hello    ";
        List<String> list = new ArrayList<>();

        list.add(line);
        list.add(line2);
        list.add(line3);
        Map<String, Integer> map = listToMap(list);
        System.out.println(map);
    }

    static Map<String, Integer> listToMap(List<String> list) {
        if (list == null) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>(list.size());
        for (String string : list) {
            if (string != null) {
                map.put(string, string.length());
            }
        }
        return map;
    }
}
