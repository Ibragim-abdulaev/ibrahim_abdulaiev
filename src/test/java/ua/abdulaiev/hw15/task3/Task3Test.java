package ua.abdulaiev.hw15.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ua.abdulaiev.hw15.task3.Task3.listToMap;

class Task3Test {
    private static Map<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>(4);
        map.put("", 0);
        map.put("World", 5);
        map.put("World  ", 7);
        map.put("World   ", 8);
    }

    @Test
    void CorrectWorkTest() {
        List<String> list = Arrays.asList("", "World", "World  ", "World   ");
        assertEquals(listToMap(list), map);
    }

    @Test
    void IncorrectWorkTest() {
        List<String> list = Arrays.asList("World ", "World", "World  ", "World   ");
        assertNotEquals(listToMap(list), map);
    }

    @Test
    void ListWithNullValueTest() {
        List<String> list = Arrays.asList("", "World", null, "World  ", "World   ");
        assertEquals(listToMap(list), map);
    }

    @Test
    void NullListTest() {
        assertNull(listToMap(null));
    }
}