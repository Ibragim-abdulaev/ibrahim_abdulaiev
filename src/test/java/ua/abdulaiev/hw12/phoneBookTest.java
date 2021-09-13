package ua.abdulaiev.hw12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.abdulaiev.hw12.phoneBook.findIndexByPhoneNumber;

class phoneBookTest {
    private static String[] phoneBook = new String[3];

    @BeforeEach
    void setUp() {
        phoneBook[0] = "016/161616";
        phoneBook[1] = "016/161617";
        phoneBook[2] = "016/161618";
    }

    @Test
    void findIndexByPhoneNumberTrue() {
        assertEquals(Optional.of(0), findIndexByPhoneNumber(phoneBook, "016/161616"));
        assertEquals(Optional.of(1), findIndexByPhoneNumber(phoneBook, "016/161617"));
        assertEquals(Optional.of(2), findIndexByPhoneNumber(phoneBook, "016/161618"));
    }

    @Test
    public void findIndexByPhoneNumberFalse() {
        assertEquals(Optional.empty(), findIndexByPhoneNumber(phoneBook, "110/443255"));
        assertEquals(Optional.empty(), findIndexByPhoneNumber(phoneBook, "yrsjmfjew"));
        assertEquals(Optional.empty(), findIndexByPhoneNumber(phoneBook, " ().-(=)(> "));
    }

    @Test
    public void findIndexByPhoneNumberWithEmpty() {
        assertEquals(Optional.empty(), findIndexByPhoneNumber(phoneBook, ""));
    }
}