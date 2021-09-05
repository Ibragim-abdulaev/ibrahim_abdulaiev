package ua.abdulaiev.hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] initialArray = new int[2000];
        fillArray(initialArray);
        //int[] copiedArray = {1,2,3,4,5,6,7,8,9,10,11,12,120,121};
        int[] copiedArray = Arrays.copyOf(initialArray, initialArray.length);
        System.out.println(Arrays.toString(copiedArray));
        System.out.println("Replaced array with zero: " + Arrays.toString(replacingNumbersWithZeros(copiedArray)));
    }

    public static int[] fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 2001);
        }
        return array;
    }

    public static int[] replacingNumbersWithZeros(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
        return array;
    }
}
