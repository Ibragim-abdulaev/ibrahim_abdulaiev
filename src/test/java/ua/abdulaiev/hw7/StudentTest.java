package ua.abdulaiev.hw7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {

    protected Student student1;
    protected Student student2;
    protected Student student3;
    protected Student student4;
    protected Student student5;
    protected Student student6;
    protected Student student7;
    protected Student student8;

    @BeforeEach
    void setUp() {
        student1 = new Student("", "", "", 2);
        student2 = new Student("", "", "", 1);
        student3 = new Student("", "", "", 0);
        student4 = new Student("", "", "", 5);
        student5 = new Student("", "", "", 4.2);
        student6 = new Student("", "", "", 3.7);
        student7 = new Student("", "", "", 1.0);
        student8 = new Student("", "", "", 5.0);
    }

    @Test
    void testGetScholarshipWithInteger() {
        Assertions.assertEquals(80, student1.getScholarship());
        Assertions.assertEquals(80, student2.getScholarship());
        Assertions.assertEquals(80, student3.getScholarship());
        Assertions.assertEquals(100, student4.getScholarship());
    }

    @Test
    void testGetScholarshipWithDouble() {
        Assertions.assertEquals(80, student5.getScholarship());
        Assertions.assertEquals(80, student6.getScholarship());
        Assertions.assertEquals(80, student7.getScholarship());
        Assertions.assertEquals(100, student8.getScholarship());
    }
}