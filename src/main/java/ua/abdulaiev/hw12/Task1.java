package ua.abdulaiev.hw12;

public class Task1 {
    public static void main(String[] args) {
        Exception exception = new Exception("Text");
        try {
            throw exception;
        } catch (Exception e) {
            System.out.println(exception);
        } finally {
            System.out.println("Block finally!");
        }
    }
}
