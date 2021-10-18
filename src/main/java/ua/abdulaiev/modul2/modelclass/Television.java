package ua.abdulaiev.modul2.modelclass;

public class Television extends Product {
    private double diagonal;
    private String country;

    public Television(String series, double diagonal, String screenType, String country, double price) {
        super(series, screenType, price, Type.TV);

        this.diagonal = diagonal;
        this.country = country;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", diagonal=" + diagonal +
                ", country='" + country + '\'' +
                '}';
    }
}