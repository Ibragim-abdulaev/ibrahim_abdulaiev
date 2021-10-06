package ua.abdulaiev.hw18;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceBoxJson {
    static void fillFromJSON(Box box) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("Task18_Box.json");
        if (input == null) {
            throw new IllegalArgumentException("file not found! ");
        } else {
            fillFromJsonFile(box, input);
        }
    }


    static void fillFromJsonFile(Box box, InputStream file) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null)
                list.add(line.replaceAll("[\",{}]", "").trim().split(": "));
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        box.setFrom(list.get(1)[1]);
        box.setMaterial(list.get(2)[1]);
        box.setColor(list.get(3)[1]);
        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity(list.get(5)[1], Integer.parseInt(list.get(6)[1]));
        box.setMaxLiftingCapacity(maxLiftingCapacity);
        Cargo cargo = new Cargo(list.get(9)[1], list.get(10)[1]);
        box.setCargo(cargo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            box.setDeliveryDate(simpleDateFormat.parse(list.get(12)[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
