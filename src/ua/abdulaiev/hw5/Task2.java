package ua.abdulaiev.hw5;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(isOrderedArray(array));
    }

    public static boolean isOrderedArray(int[] array) {
        boolean ordered = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                ordered = true;
            } else {
                ordered = false;
                return ordered;
            }
        }
        return ordered;
    }
}
