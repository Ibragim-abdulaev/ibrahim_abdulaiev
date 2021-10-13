package ua.abdulaiev.hw18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

public class ServiceBox {
    final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static Function<Map<String, String>, Box> boxMapper() {
        return (sourceMap) -> {
            Box box = new Box();
            for (Map.Entry<String, String> entry : sourceMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equals("from")) {
                    box.setFrom(value);
                }
                if (key.equals("material")) {
                    box.setMaterial(value);
                }
                if (key.equals("color")) {
                    box.setColor(value);
                }
                if (key.equals("unit")) {
                    box.getMaxLiftingCapacity().setUnit(value);
                }
                if (key.equals("value")) {
                    box.getMaxLiftingCapacity().setValue(Integer.parseInt(value));
                }
                if (key.equals("max-lifting-capacity")) {
                    box.getMaxLiftingCapacity().setValue(Integer.parseInt(value));
                }
                if (key.equals("name")) {
                    box.getCargo().setName(value);
                }
                if (key.equals("class")) {
                    box.getCargo().setCargoClass(value);
                }
                if (key.equals("delivery-date")) {
                    try {
                        box.setDeliveryDate(SIMPLE_DATE_FORMAT.parse(value));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
            return box;
        };
    }
}
