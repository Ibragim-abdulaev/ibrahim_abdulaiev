package ua.abdulaiev.hw18;

public class Cargo {
    private String name;
    private String cargoClass;

    public Cargo(String name, String cargoClass) {
        this.name = name;
        this.cargoClass = cargoClass;
    }

    public Cargo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCargoClass() {
        return cargoClass;
    }

    public void setCargoClass(String cargoClass) {
        this.cargoClass = cargoClass;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "name='" + name + '\'' +
                ", cargoClass='" + cargoClass + '\'' +
                '}';
    }
}
