package ua.abdulaiev.hw29.maths;

public class Ctg implements Mathematic {
    @Override
    public double calculation(double num) {
        return 1 / Math.tan(num);
    }
}
