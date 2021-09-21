package ua.abdulaiev.hw15.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

class BoxComparatorTest {

    Set<Box> boxSet;
    Box box1;
    Box box2;
    Box box3;
    Box box4;
    Box box5;
    BoxComparator boxComparator;

    @BeforeEach
    void setUp() {
        box1 = new Box(0);
        box2 = new Box(0);
        box3 = new Box(3);
        box4 = new Box(5);
        box5 = new Box(-10);
        boxSet = new TreeSet<>(new BoxComparator());
        boxComparator = new BoxComparator();
    }

    @Test
    void comparatorEqualsZeroNumberTest() {
        Assertions.assertEquals(-1, boxComparator.compare(box1, box2));
    }

    @Test
    void comparatorEqualsNegNumberAndPosNumberTest() {
        Assertions.assertEquals(1, boxComparator.compare(box5, box4));
    }

    @Test
    void comparatorEqualsPosNumber() {
        Assertions.assertEquals(0, boxComparator.compare(box3, box3));
    }

    @Test
    void comparatorEqualsDiferentPosNumberTest() {
        Assertions.assertEquals(1, boxComparator.compare(box3, box4));
    }

    @Test
    void comparatorEqualsPosNumberAndNegNumberTest() {
        Assertions.assertEquals(-1, boxComparator.compare(box4, box5));
    }
}