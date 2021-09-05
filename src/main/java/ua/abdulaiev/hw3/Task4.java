package ua.abdulaiev.hw3;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int number= 10;
        gameWithComputer(number);
    }

    public static void gameWithComputer(int number) {
        int secret = new Random().nextInt(number);
        while (true) {
            System.out.print("Enter the number: ");
            int guess = new Scanner(System.in).nextInt();
            if (guess > secret) {
                System.out.println("A lot of!");
            } else if (guess < secret) {
                System.out.println("Little!");
            } else {
                System.out.println("Guessed!");
                break;
            }
        }
    }
}