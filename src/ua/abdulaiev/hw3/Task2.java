package ua.abdulaiev.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Write a line: ");
        String line = in.nextLine();
        line = removeSpace(line);
        System.out.println("Line without space: " + line);
        System.out.println("Reverse line: " + ReverseString(line));
        System.out.println("isPalindrome: " + isPalindrome(line, ReverseString(line)));
    }

    public static String removeSpace(String line) {
        return  line.replaceAll("\\s", "");
    }

    public static String ReverseString(String line) {
        String reverse = new StringBuffer(line).reverse().toString();
        return reverse;
    }

    public static boolean isPalindrome(String line, String reverse) {
        if (line.equalsIgnoreCase(reverse))
            return true;
        else
            return false;
    }
}
