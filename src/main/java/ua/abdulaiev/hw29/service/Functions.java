package ua.abdulaiev.hw29.service;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Functions {
    public static Double calculate(double value, String className) {
        try {
            Class<?> classes;
            Method method;
            className = className.substring(0, 1).toUpperCase() + className.substring(1);
            classes = Class.forName("ua.abdulaiev.hw29.maths." + className);
            method = classes.getDeclaredMethod("calculate", double.class);
            return (double) method.invoke(classes.newInstance(), value);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                InstantiationException | IllegalAccessException e) {
            System.out.println("Error: Incorrect function");
            return null;
        }
    }
}
