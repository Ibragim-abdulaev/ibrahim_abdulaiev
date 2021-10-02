package ua.abdulaiev.hw18;

import java.util.Date;

public class Box {
    private String from;
    private String material;
    private String color;
    private MaxLiftingCapacity maxLiftingCapacity;
    private Cargo cargo;
    private Date deliveryDate;

    public Box(String from, String material, String color, MaxLiftingCapacity maxLiftingCapacity, Cargo cargo, Date deliveryDate) {
        this.from = from;
        this.material = material;
        this.color = color;
        this.maxLiftingCapacity = maxLiftingCapacity;
        this.cargo = cargo;
        this.deliveryDate = deliveryDate;
    }

    public Box() {
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxLiftingCapacity(MaxLiftingCapacity maxLiftingCapacity) {
        this.maxLiftingCapacity = maxLiftingCapacity;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getFrom() {
        return from;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public MaxLiftingCapacity getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Box{" +
                "from='" + from + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", maxLiftingCapacity=" + maxLiftingCapacity +
                ", cargo=" + cargo +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
