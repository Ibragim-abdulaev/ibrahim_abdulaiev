package ua.abdulaiev.hw18;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(ServiceBoxXml.fillFromXmlFile());
        System.out.println();
        System.out.println(ServiceBoxJson.fillFromJsonFile());
    }
}
