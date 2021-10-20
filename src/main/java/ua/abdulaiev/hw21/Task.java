package ua.abdulaiev.hw21;

import ua.abdulaiev.hw21.annotation.Init;
import ua.abdulaiev.hw21.service.ServiceBox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Task {
    public static void main(String[] args) {
        Map<String, Object> map = ServiceBox.searchClasses();
        for (Object o : map.values()) {
            accept(o);
        }
    }

    private static void accept(Object obj) {
        for (Method x : obj.getClass().getDeclaredMethods()) {
            if (x.isAnnotationPresent(Init.class)) {
                x.setAccessible(true);
                try {
                    x.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

