package ua.abdulaiev.hw29.service;

import org.reflections.Reflections;
import ua.abdulaiev.hw29.maths.Mathematic;

import java.util.Set;

public class Helps {
    public static void run() {
        Reflections reflections = new Reflections(Mathematic.class.getPackage().getName());
        Set<Class<? extends Mathematic>> classes = reflections.getSubTypesOf(Mathematic.class);
        System.out.println("--------Begin help--------");
        System.out.println("Available functions:");
        classes.stream()
                .map(clas -> "'" + clas.getSimpleName().toLowerCase() + "' ")
                .forEach(System.out::print);
        System.out.println(System.lineSeparator() + System.lineSeparator() +
                "If your value is in degrees, type 'deg' in the end" + System.lineSeparator() +
                "e.g. 'sin 21 deg' 'cos(30) deg' 'tan 5.6' 'sec(78.42)'");
        System.out.println("--------End help--------" + System.lineSeparator());
    }
}