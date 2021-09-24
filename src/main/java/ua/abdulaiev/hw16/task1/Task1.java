package ua.abdulaiev.hw16.task1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    private final static int N = 1000000;
    private final static int M = 100000;

    public static void main(String[] args) {
        List<Double> arrayList = new ArrayList<>();
        List<Double> linkedList = new LinkedList<>();
        System.out.println("Start arrayList: " + LocalTime.now());
        getRandomElement(arrayList);
        System.out.println("End arrayList: " + LocalTime.now());
        System.out.println("Start linkedList: " + LocalTime.now());
        getRandomElement(linkedList);
        System.out.println("End linkedList: " + LocalTime.now());

    }

    public static void fillArray(List<Double> list) {
        for (int i = 0; i < N; i++) {
            list.add(Math.random());
        }
    }

    public static void getRandomElement(List<Double> list) {
        fillArray(list);
        for (int i = 0; i < M; i++) {
            list.get((int) (Math.random() * (N - 1)));
        }
    }
}
