package ua.abdulaiev.hw2;

public class Task4 {
    public static void main(String[] args) {
        module(10, 20, 30);
    }

    public static void module(int x, int y, int z) {
        int min = (x <= y) ? ((x <= z) ? x : z) : ((y <= z) ? y : z);
        System.out.println(min);
    }
}
