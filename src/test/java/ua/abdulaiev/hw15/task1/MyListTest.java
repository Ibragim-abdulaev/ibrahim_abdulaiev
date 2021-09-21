package ua.abdulaiev.hw15.task1;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyListTest {
    MyList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyList<>();
        list.add("8"); // head
        list.add("6");
        list.add("7");
        list.add("5");
        list.add("4"); // tail
    }

    @Test
    void addValueTest() {
        list.add("3");
    }

    @Test
    void getFromLastTest() {
        Assertions.assertEquals("5", list.getFromLast("5"));
    }

    @Test
    void exceptionTest() {
        Assert.assertThrows(NullPointerException.class, ()-> list.getFromLast("213"));
        Assert.assertThrows(NullPointerException.class, ()-> list.getFromLast(null));
    }
}