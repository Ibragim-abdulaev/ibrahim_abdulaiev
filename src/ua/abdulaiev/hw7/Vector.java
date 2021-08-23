package ua.abdulaiev.hw7;

import java.util.Random;

public class Vector {
    public double x;
    public double y;
    public double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double lengthVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector vectorProduct(Vector vector) {
        return new Vector(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    public double scalarProductVector(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public double cosVector(Vector vector) {
        return scalarProductVector(vector) / (lengthVector() * vector.lengthVector());
    }

    public Vector sumVector(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector subtractVector(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public static Vector[] vectorArray(int n) {
        Vector[] vectors = new Vector[n];
        Random random = new Random();
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(random.nextInt(25), random.nextInt(25), random.nextInt(25));
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
