package ua.abdulaiev.hw6;

public class Task2 {
//Программа выдает ошибку в строке 28, for (int j = 0; i < triangle[i].length; j++)
//Я исправил в этой строке условие i на j for (int j = 0; j < triangle[i].length; j++)
//Ошибка состоит в том что мы выходим за предел массива, программа пытается обратится к
//несуществующему индексу j = 1 при длинне массива triangle[i] = 1
    public static void main(String[] args) {
        int[][] triangle = new int[5][];

        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];

        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }

        }

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }

    }
}

