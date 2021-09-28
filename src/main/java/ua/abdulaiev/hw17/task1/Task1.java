package ua.abdulaiev.hw17.task1;

import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        String text = "Block Abdulaev Abcissa Hello Abdulaev abdulaev abcissa hello Hello";
        sortAndPrintArray(text);
    }

    public static void sortAndPrintArray(String text) {
        String[] texts = text.split(" ");
        Stream.of(texts).sorted().forEach(System.out::println);
    }
}
