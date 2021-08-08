package ua.abdulaiev.hw1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String num = in.nextLine();
        String reverse = new StringBuffer(num).reverse().toString();
        System.out.println("Number in reverse order: " + reverse);

    }
}