package ua.abdulaiev.modul2.modelclass;

import java.util.List;

public class Invoice {
    private List<Product> products;
    private Customer customer;
    private String type;

    public Invoice(Customer customer, String type, List<Product> products) {
        this.customer = customer;
        this.type = type;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "products=" + products +
                ", customer=" + customer +
                ", type='" + type + '\'' +
                '}';
    }
}