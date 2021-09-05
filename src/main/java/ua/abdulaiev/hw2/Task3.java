package ua.abdulaiev.hw2;

public class Task3 {
    public static void main(String[] args) {
        evenOdd(0);
        evenOdd(1);
    }

    public static void evenOdd(int x) {
        if (x % 2 == 0) {
            System.out.println("Число: " + x + " - четное");
        } else {
            System.out.println("Число: " + x + " - нечетное");
        }
    }
}
