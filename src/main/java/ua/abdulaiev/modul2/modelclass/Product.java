package ua.abdulaiev.modul2.modelclass;

public class Product {
    protected String series;
    protected String screenType;
    protected double price;

    public Product(String series, String screenType, double price) {
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                '}';
    }
}