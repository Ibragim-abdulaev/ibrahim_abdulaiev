package ua.abdulaiev.hw12;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void methodG() {
        assertThrows(IOException.class, Task2::methodG);
    }

    @Test
    void methodF() {
        assertThrows(RuntimeException.class, Task2::methodF);
    }
}