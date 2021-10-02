package ua.abdulaiev.hw18;

import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        Box boxJson = new Box();
        ServiceBoxJson.fillFromJSON(boxJson);
        System.out.println(boxJson + System.lineSeparator());
        Box boxXml = new Box();
        ServiceBoxXml.fillFromJSON(boxXml);
        System.out.println(boxXml);
    }
}
