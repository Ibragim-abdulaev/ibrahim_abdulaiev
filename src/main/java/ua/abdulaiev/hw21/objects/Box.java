package ua.abdulaiev.hw21.objects;

import ua.abdulaiev.hw21.annotation.AutoCreate;
import ua.abdulaiev.hw21.annotation.Init;
import ua.abdulaiev.hw21.annotation.Multiplier;

@AutoCreate()
public class Box {
    @Multiplier
    private final String name = "hello";
    @Multiplier
    private final double size = 6.0;
    private final int weight = 2;

    @Init
    public void printFields() {
        System.out.println(name + ", size= " + size + " weight= " + weight);
    }
}
