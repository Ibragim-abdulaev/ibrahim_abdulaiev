package ua.abdulaiev.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Task2Test {
    @Test
    void isBiggerThenPastGood() {
        assertTrue(Task2.isOrderedArray(new int[]{100, 77, 23, 1, 1, -33}));
        assertTrue(Task2.isOrderedArray(new int[]{1, 0, -1, -1254, -125456, Integer.MIN_VALUE}));
        assertTrue(Task2.isOrderedArray(new int[]{0, 0, 0, 0, 0, -1}));
    }

    @Test
    void isBiggerThenPastBad() {
        assertFalse(Task2.isOrderedArray(new int[]{-124, 100, 77, 23, 1, 1, -33}));
        assertFalse(Task2.isOrderedArray(new int[]{-125, 1, 0, -1, -1254, -125456, Integer.MIN_VALUE}));
        assertFalse(Task2.isOrderedArray(new int[]{-124, 0, 0, 0, 0, 0, -1}));
    }

    @Test
    void isBiggerThenPastOneNumber() {
        assertFalse(Task2.isOrderedArray(new int[]{1}));
        assertFalse(Task2.isOrderedArray(new int[]{Integer.MIN_VALUE}));
        assertFalse(Task2.isOrderedArray(new int[]{Integer.MAX_VALUE}));
    }

    @Test
    void isBiggerThenPastNullArray() {
        assertFalse(Task2.isOrderedArray(new int[]{}));
        assertFalse(Task2.isOrderedArray(new int[]{}));
        assertFalse(Task2.isOrderedArray(new int[]{}));
    }

    @Test
    void isBiggerThenPastSameNumbers() {
        assertTrue(Task2.isOrderedArray(new int[]{1, 1, 1, 1, 1, 1, 1}));
        assertTrue(Task2.isOrderedArray(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
        assertTrue(Task2.isOrderedArray(new int[]{-1, -1, -1, -1, -1, -1}));
    }
}