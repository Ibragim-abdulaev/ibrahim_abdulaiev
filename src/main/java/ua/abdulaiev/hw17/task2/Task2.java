package ua.abdulaiev.hw17.task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        fillArray(numbers);
        System.out.println(numbers);
        printIntSummaryStatistic(numbers);
    }

    public static void fillArray(List<Integer> numbers) {
        for (int i = 0; i < 10; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
    }

    public static void printIntSummaryStatistic(List<Integer> list) {
        IntSummaryStatistics statistics = list.stream()
                .filter(x -> x >= 0)
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println(statistics);
    }
}