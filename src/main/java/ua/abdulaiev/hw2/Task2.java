package ua.abdulaiev.hw2;

public class Task2 {
    public static void main(String[] args) {
        double square = Area();
        System.out.println(square);
    }

    public static double Area() {
        double square = 0.0;
        double x1 = 12, x2 = 65, x3 = 3.4;
        double y1 = 21, y2 = 54, y3 = 2.5;

        square = 0.5 * Math.abs(((x1 - x3) * (y2 - y3)) - ((y1 - y3) * (x2 - x3)));

        return square;
    }
}
