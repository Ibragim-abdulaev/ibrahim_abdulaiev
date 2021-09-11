package ua.abdulaiev.hw12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.abdulaiev.hw12.Task3.throwThreeException;


class Task3Test {


    @Test
    public void throwExceptionZeroNumberTest() {
        assertThrows(OneException.class, () -> throwThreeException(0));
    }

    @Test
    public void throwExceptionNaturalNumberTest() {
       assertThrows(TwoException.class, () ->throwThreeException(1));
    }

    @Test
    public void throwExceptionNegativeNumberTest() {
        assertThrows(ThreeException.class, () ->throwThreeException(-1));
    }
}