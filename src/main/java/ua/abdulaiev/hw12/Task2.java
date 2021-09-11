package ua.abdulaiev.hw12;

import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        try {
            methodF();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    static void methodG() throws IOException {
        throw new IOException("Исключение 1 в methodG()");
    }

    static void methodF() {
        try {
            methodG();
        } catch (IOException exception) {
            throw new RuntimeException("Исключение 2 в methodF()");
        }
    }
}
