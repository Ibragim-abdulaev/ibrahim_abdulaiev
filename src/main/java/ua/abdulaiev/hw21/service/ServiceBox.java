package ua.abdulaiev.hw21.service;

import org.reflections.Reflections;
import ua.abdulaiev.hw21.Task;
import ua.abdulaiev.hw21.annotation.AutoCreate;
import ua.abdulaiev.hw21.annotation.Multiplier;
import ua.abdulaiev.hw21.objects.Operation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ServiceBox {
    public static Map<String, Object> search() {
        Reflections reflections = new Reflections(Task.class.getPackage().getName());
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(AutoCreate.class);
        Map<String, Object> map = new HashMap<>();
        for (Iterator<Class<?>> iterator = classSet.iterator(); iterator.hasNext(); ) {
            Class<?> clas = iterator.next();
            Object obj = null;
            Field[] field = clas.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                Field fields = field[i];
                fields.setAccessible(true);
                if (!fields.isAnnotationPresent(Multiplier.class)) {
                    continue;
                }
                try {
                    obj = clas.newInstance();
                    if (fields.get(obj) instanceof Number) {
                        System.out.println(fields.getName() + ": " + fields.get(obj));
                        if (!fields.getAnnotation(Multiplier.class).value().equals(Operation.ADD)) {
                            fields.set(obj, ((Number) fields.get(obj)).intValue() * 3);
                            System.out.println("Multiply: " + fields.get(obj));
                        } else {
                            fields.set(obj, ((Number) fields.get(obj)).intValue() +
                                    ((Number) fields.get(obj)).intValue());
                            System.out.println("Addition: " + fields.get(obj));
                        }
                    }
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            map.put(clas.getName(), obj);
        }
        return map;
    }
}
