package ua.abdulaiev.hw18;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.abdulaiev.hw18.ServiceBox.boxMapper;

public class ServiceBoxXml {
    public static Box fillFromXmlFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("Task18_Box.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        Map<String, String> map = new HashMap<>();
        try {
            String str;
            Pattern froms = Pattern.compile("(from)=\"(.+?)\"");
            Pattern materials = Pattern.compile("(material)=\"(.+?)\"");
            Pattern colors = Pattern.compile("<(color)>(.+?)<");
            Pattern units = Pattern.compile("(unit)=\"(.+?)\"");
            Pattern values = Pattern.compile("(max-lifting-capacity).*?(\\d+).*<");
            Pattern names = Pattern.compile("<(name)>(.+?)<");
            Pattern cargoClass = Pattern.compile("<(class)>(.+?)<");
            Pattern dates = Pattern.compile("<(delivery-date)>(.+?)<");
            while ((str = reader.readLine()) != null) {
                Matcher mFroms = froms.matcher(str);
                Matcher mMaterials = materials.matcher(str);
                Matcher mColors = colors.matcher(str);
                Matcher mUnits = units.matcher(str);
                Matcher mValues = values.matcher(str);
                Matcher mNames = names.matcher(str);
                Matcher mCargoClass = cargoClass.matcher(str);
                Matcher mDates = dates.matcher(str);
                if (mFroms.find()) {
                    map.put(mFroms.group(1), mFroms.group(2));
                }
                if (mMaterials.find()) {
                    map.put(mMaterials.group(1), mMaterials.group(2));
                }
                if (mColors.find()) {
                    map.put(mColors.group(1), mColors.group(2));
                }
                if (mUnits.find()) {
                    map.put(mUnits.group(1), mUnits.group(2));
                }
                if (mValues.find()) {
                    map.put(mValues.group(1), mValues.group(2));
                }
                if (mNames.find()) {
                    map.put(mNames.group(1), mNames.group(2));
                }
                if (mCargoClass.find()) {
                    map.put(mCargoClass.group(1), mCargoClass.group(2));
                }
                if (mDates.find()) {
                    map.put(mDates.group(1), mDates.group(2));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return boxMapper().apply(map);
    }
}
