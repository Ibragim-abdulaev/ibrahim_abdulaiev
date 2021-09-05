package ua.abdulaiev.hw7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AspirantTest {
    protected Aspirant aspirant1;
    protected Aspirant aspirant2;
    protected Aspirant aspirant3;
    protected Aspirant aspirant4;
    protected Aspirant aspirant5;
    protected Aspirant aspirant6;
    protected Aspirant aspirant7;
    protected Aspirant aspirant8;

    @BeforeEach
    void setUp() {
        aspirant1 = new Aspirant("", "", "", 3, "");
        aspirant2 = new Aspirant("", "", "", 4, "");
        aspirant3 = new Aspirant("", "", "", 2, "");
        aspirant4 = new Aspirant("", "", "", 5, "");
        aspirant5 = new Aspirant("", "", "", 5.1, "");
        aspirant6 = new Aspirant("", "", "", 5.0, "");
        aspirant7 = new Aspirant("", "", "", 3.9, "");
        aspirant8 = new Aspirant("", "", "", 0.5, "");
    }

    @Test
    void testGetScholarshipWithInteger() {
        Assertions.assertEquals(180, aspirant1.getScholarship());
        Assertions.assertEquals(180, aspirant2.getScholarship());
        Assertions.assertEquals(180, aspirant3.getScholarship());
        Assertions.assertEquals(200, aspirant4.getScholarship());
    }

    @Test
    void testGetScholarshipWithDouble() {
        Assertions.assertEquals(180, aspirant5.getScholarship());
        Assertions.assertEquals(200, aspirant6.getScholarship());
        Assertions.assertEquals(180, aspirant7.getScholarship());
        Assertions.assertEquals(180, aspirant8.getScholarship());
    }
}