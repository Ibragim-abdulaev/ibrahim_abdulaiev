package ua.abdulaiev.hw5;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][2];
        fillMatrix(matrix);
        int[][] copiedArray = changeColumnsAndRows(matrix);
        System.out.println("Source array: " + Arrays.deepToString(matrix));
        System.out.println("Modified array: " + Arrays.deepToString((copiedArray)));
    }

    public static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random()*101);
            }
        }
    }

    public static int[][] changeColumnsAndRows(int[][] matrix) {
        int[][] array = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[j][i] = matrix[i][j];
            }
        }
        return array;
    }
}