package ua.abdulaiev.hw31.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        fillNumber(numbers);
        List<Integer> list1 = numbers.subList(0, numbers.size() / 2);
        ThreadPrimeCounterNumber t1 = new ThreadPrimeCounterNumber(list1);
        List<Integer> list2 = numbers.subList(numbers.size() / 2, numbers.size());
        ThreadPrimeCounterNumber t2 = new ThreadPrimeCounterNumber(list2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.print("Prime numbers: " + (t1.getCount() + t2.getCount()));
    }

    private static void fillNumber(List<Integer> numbers) {
        for (int i = 1; i < 5000_000; i++) {
            numbers.add(i);
        }
    }
}
