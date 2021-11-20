package ua.abdulaiev.hw29;

import ua.abdulaiev.hw29.service.Functions;
import ua.abdulaiev.hw29.service.Helps;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        System.out.println("<<< Trigonometric functions calculator >>>");
        System.out.println("Write 'help' for help" + System.lineSeparator()
                + "Write 'exit' for exit" + System.lineSeparator());
        do {
            System.out.println("Enter function:");
            String input = new Scanner(System.in).nextLine().toLowerCase().trim()
                    .replaceAll("[^ .,0-9a-zA-Z]", " ")
                    .replaceAll(",", ".")
                    .replaceAll(" +", " ");
            if (input.trim().equals("exit")) {
                break;
            }
            if (input.trim().equals("help")) {
                Helps.run();
                continue;
            }
            if (!input.contains(" ")) {
                System.out.println("!!!!! Error: no value !!!!!");
                continue;
            }
            String className = input.split(" ")[0];
            String valueAsString = input.split(" ")[1];
            double value;
            try {
                value = input.endsWith("deg") ?
                        Math.toRadians(Double.parseDouble(valueAsString)) : Double.parseDouble(valueAsString);
            } catch (NumberFormatException e) {
                System.out.println("!!!!! Error: Incorrect value !!!!!");
                continue;
            }
            Double result = Functions.calculate(value, className);
            System.out.printf("%.9f" + System.lineSeparator(), result);
        } while (true);
    }
}
