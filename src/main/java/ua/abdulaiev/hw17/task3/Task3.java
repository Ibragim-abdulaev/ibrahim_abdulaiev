package ua.abdulaiev.hw17.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> date = Arrays.asList("1998/04/23", "2005/01/01", "2010/07/30", "2025/11/10", "2021/10/13");
        printAndCheckDate(date);
    }

    public static void printAndCheckDate(List<String> date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(date.stream()
                .map(d -> LocalDate.parse(d, dateTimeFormatter))
                .anyMatch(y -> y.getYear() == 2021));
    }
}

