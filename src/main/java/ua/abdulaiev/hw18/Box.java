package ua.abdulaiev.hw18;

import lombok.Data;

import java.util.Date;

@Data
public class Box {
    protected String from;
    protected String material;
    protected String color;
    protected MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
    protected Cargo cargo = new Cargo();
    protected Date deliveryDate;
}
