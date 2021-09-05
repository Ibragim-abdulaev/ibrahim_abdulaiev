package ua.abdulaiev.modul1;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[20];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortArray(array)));
        System.out.println(countUnique(sortArray(array)));
    }

    public static int[] fillArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(11);
        }
        return array;
    }

    public static int[] sortArray(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);
        return arrayCopy;
    }

    public static int countUnique(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != array[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
