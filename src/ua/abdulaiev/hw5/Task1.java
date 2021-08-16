package ua.abdulaiev.hw5;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[][] matrix = new int[6][3];
        fillMatrix(matrix);
        System.out.println("Source array: " + Arrays.deepToString(matrix));
        fillNegativeNumbers(matrix);
        System.out.println("Modified array: " + Arrays.deepToString(matrix));
    }

    public static void fillMatrix(int[][] matrix) {
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter++;
            }
        }
    }

    public static void fillNegativeNumbers(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i+1) % 2 == 0) {
                    matrix[i][j] *= -1;
                }
            }
        }
    }
}