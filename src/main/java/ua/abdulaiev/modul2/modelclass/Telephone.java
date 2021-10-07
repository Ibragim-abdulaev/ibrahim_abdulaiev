package ua.abdulaiev.modul2.modelclass;

public class Telephone extends Product {
    private String model;

    public Telephone(String series, String screenType, double price, String model) {
        super(series, screenType, price);

        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}