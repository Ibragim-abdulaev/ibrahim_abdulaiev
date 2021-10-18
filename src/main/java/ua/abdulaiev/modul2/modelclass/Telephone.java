package ua.abdulaiev.modul2.modelclass;

public class Telephone extends Product {
    private String model;

    public Telephone(String series, String model, String screenType, double price) {
        super(series, screenType, price, Type.PHONE);

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