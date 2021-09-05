package ua.abdulaiev.hw7;

public class Task2 {
    public static void main(String[] args) {
        Vector[] vector = Vector.vectorArray(10);
        System.out.println("Vector1: " + vector[0]);
        System.out.print(System.lineSeparator());
        System.out.println("Vector2: " + vector[1]);
        System.out.print(System.lineSeparator());
        System.out.println("Length Vector: " + vector[0].lengthVector());
        System.out.print(System.lineSeparator());
        System.out.println("Scalar product vector: " + vector[0].scalarProductVector(vector[1]));
        System.out.print(System.lineSeparator());
        System.out.println("Vector product: " + vector[0].vectorProduct((vector[1])));
        System.out.print(System.lineSeparator());
        System.out.println("Vector cosine: " + vector[0].cosVector(vector[1]));
        System.out.print(System.lineSeparator());
        System.out.println("Vector sum: " + vector[0].sumVector(vector[1]));
        System.out.print(System.lineSeparator());
        System.out.println("Vector subtract: " + vector[0].subtractVector(vector[1]));
    }
}
