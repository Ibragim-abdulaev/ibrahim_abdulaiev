package ua.abdulaiev.hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[20];
        fillArray(numbers);
        System.out.println("Source array: " + Arrays.toString(numbers));
        System.out.print("Delete element: ");
        System.out.println("Modified array: " + Arrays.toString(removeItem(numbers, in.nextInt())));
        System.out.println(Arrays.toString(numbers));
    }

    public static void fillArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (1 + Math.random() * 10);
        }
    }

    public static int[] removeItem(int[] numbers, int index) {
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length - 1);
        if (index >= 0 && index <= numbers.length - 1) {
            System.arraycopy(numbers, index + 1, copiedNumbers, index, copiedNumbers.length - index);
        } else {
            return null;
        }
        return copiedNumbers;
    }
}