package ua.abdulaiev.hw18;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServiceBoxXml {

    static void fillFromJSON(Box box) {
        FileInputStream fileInputStream = null;
        try {
            ClassLoader classLoader = ServiceBoxJson.class.getClassLoader();

            File configFile = new File(classLoader.getResource("Task18_Box.xml").getFile());

            fileInputStream = new FileInputStream(configFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((reader.readLine()) != null) {
                fillFromXmlFile(box, configFile);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void fillFromXmlFile(Box box, File file) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null)
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
