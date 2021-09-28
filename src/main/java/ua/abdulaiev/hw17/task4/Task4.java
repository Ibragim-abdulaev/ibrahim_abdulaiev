package ua.abdulaiev.hw17.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        fillArray(numbers);
        System.out.println("Source array: " + numbers);
        System.out.println("Min numbers of List: " + minNumbersOfList(numbers));
    }

    public static void fillArray(List<Integer> numbers) {
        Collections.addAll(numbers, -1,4,-10,40,32,85,0,500);
        Collections.shuffle(numbers);
    }

    public static int minNumbersOfList(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);
    }
}
