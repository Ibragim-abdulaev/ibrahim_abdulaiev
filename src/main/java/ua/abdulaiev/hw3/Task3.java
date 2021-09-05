package ua.abdulaiev.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Write a line: ");
        String line = in.nextLine();
        System.out.println("Number of words in line: " + wordCount(line));
    }

    public static int wordCount(String line) {
        return Arrays.stream(line.split(" ")).filter(e -> !e.isEmpty()).toArray().length;
    }
}