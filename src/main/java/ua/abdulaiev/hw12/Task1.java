package ua.abdulaiev.hw12;

public class Task1 {
    public static void main(String[] args) {
        Exception exception = new Exception("Text");
        try {
            throw exception;
        } catch (Exception e) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Block finally!");
        }
    }
}
