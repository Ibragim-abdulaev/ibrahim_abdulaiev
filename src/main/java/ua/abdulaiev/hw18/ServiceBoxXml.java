package ua.abdulaiev.hw18;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceBoxXml {

    static void fillFromJSON(Box box) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("Task18_Box.xml");
        BufferedReader reader = null;
        if (input != null) {
            reader = new BufferedReader(new InputStreamReader(input));
        }
        if (reader != null) {
            fillFromXmlFile(box, reader);
        }
    }

    static void fillFromXmlFile(Box box, BufferedReader file) {
        List<String[]> list = new ArrayList<>();
        try {
            String str;
            while ((str = file.readLine()) != null)
                list.add(str.replaceAll("[<>/\"=]", " ").trim().split(" +"));
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        box.setFrom(list.get(1)[2]);
        box.setMaterial(list.get(1)[4]);
        box.setColor(list.get(2)[1]);
        MaxLiftingCapacity maxLiftingCapacity =
                new MaxLiftingCapacity((list.get(3)[2]), Integer.parseInt(list.get(3)[3]));
        box.setMaxLiftingCapacity(maxLiftingCapacity);
        Cargo cargo = new Cargo(list.get(5)[1], list.get(6)[1]);
        box.setCargo(cargo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            box.setDeliveryDate(simpleDateFormat.parse(list.get(8)[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
