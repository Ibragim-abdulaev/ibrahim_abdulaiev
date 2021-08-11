package ua.abdulaiev.hw4;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] initialArray = new int[400];
        fillArray(initialArray);
        int[] copiedArray = Arrays.copyOf(initialArray, initialArray.length);
        System.out.println(Arrays.toString(copiedArray));
        System.out.println("Arithmetic mean: " + arithmeticMean(copiedArray));
        System.out.println("Geometric mean: " + geometricMean(copiedArray));
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }
        return array;
    }

    public static double arithmeticMean(int[] array) {
        double average = 0;
        double sum = 0;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            average = sum / array.length;
        }
        return average;
    }

    public static double geometricMean(int[] array) {
        double average = 0;
        double sum = 0;
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            average = Math.sqrt(sum);
        }
        return average;
    }
}
