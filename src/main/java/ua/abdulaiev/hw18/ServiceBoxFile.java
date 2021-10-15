package ua.abdulaiev.hw18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.abdulaiev.hw18.ServiceBox.boxMapper;

public class ServiceBoxFile {
    public static Box fillFromFile(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        Map<String, String> map = new HashMap<>();

        List<Pattern> patterns;
        if (fileName.endsWith("json")) {
            patterns = ServiceBox.getJsonPattern();
        } else if (fileName.endsWith("xml")) {
            patterns = ServiceBox.getXmlPattern();
        } else {
            throw new IllegalArgumentException(fileName);
        }

        try {
            String str;
            while ((str = reader.readLine()) != null) {
                for (Pattern pattern : patterns) {
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        map.put(matcher.group(1), matcher.group(2));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return boxMapper().apply(map);
    }
}


