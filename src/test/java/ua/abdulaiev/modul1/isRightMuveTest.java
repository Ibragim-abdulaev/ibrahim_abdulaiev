package ua.abdulaiev.modul1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class isRightMuveTest {

    @Test
    void testRightStep() {
        assertTrue(Task2.isRightMuve('d', 4, 'c', 6));
        assertTrue(Task2.isRightMuve('d', 4, 'b', 5));
        assertTrue(Task2.isRightMuve('d', 4, 'b', 3));
        assertTrue(Task2.isRightMuve('d', 4, 'c', 2));
        assertTrue(Task2.isRightMuve('d', 4, 'e', 2));
        assertTrue(Task2.isRightMuve('d', 4, 'f', 3));
        assertTrue(Task2.isRightMuve('d', 4, 'f', 5));
        assertTrue(Task2.isRightMuve('d', 4, 'e', 6));
    }

    @Test
    void testLeavingTheField() {
        assertFalse(Task2.isRightMuve('d', 4, 'z', 6));
        assertFalse(Task2.isRightMuve('d', 4, 'C', 12));
        assertFalse(Task2.isRightMuve('Z', 4, 'c', 6));
        assertFalse(Task2.isRightMuve('d', -1, 'c', 6));
    }

    @Test
    void testNumberInsteadOfLater() {
        assertFalse(Task2.isRightMuve('4', 4, 'c', 6));
        assertFalse(Task2.isRightMuve('d', 4, '4', 6));
    }

    @Test
    void moveHorseZeroPoint() {
        assertFalse(Task2.isRightMuve(' ',' ', ' ', ' '));
    }

    @Test
    void moveHorseWithExceptionsBecauseOnePointIsEmpty() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Task2.run("b2-2"));
        //assertThrows(StringIndexOutOfBoundsException.class, () -> Task2.run("test"));
    }

    @Test
    public void testIncorrectInputKnightsMove() {
        assertFalse(Task2.isRightMuve('+', 500,'/',-1312));
        assertFalse(Task2.isRightMuve('1', 1, '-', 0));
        assertFalse(Task2.isRightMuve('(', 98631143, '*',8324));
    }

}
