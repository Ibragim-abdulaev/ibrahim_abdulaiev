package ua.abdulaiev.hw9.task2;

public class Task2 {
    public static void main(String[] args) {
        Pow power = (num, pow) -> {
            int result = 1;
            for (int i = 0; i < pow; i++) {
                result *= num;
            }
            return result;
        };
        System.out.println(power.pow(2, 5));
    }
}
