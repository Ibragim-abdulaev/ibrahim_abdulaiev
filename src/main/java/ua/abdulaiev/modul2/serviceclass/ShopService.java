package ua.abdulaiev.modul2.serviceclass;

import ua.abdulaiev.modul2.modelclass.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopService {
    private List<Invoice> orders;
    private PersonService personService;
    private double priceLimit;
    private String logFilePath;

    public ShopService(double priceLimit, String logFilePath) {
        this.orders = new ArrayList<>();
        this.personService = new PersonService();
        this.priceLimit = priceLimit;
        this.logFilePath = logFilePath;
    }

    public void readOrders(String filePath) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        List<Product> products = new ArrayList<>();
        try {
            String str;
            reader.readLine();
            while ((str = reader.readLine()) != null) {
                try {
                    products.add(parseFromCSV(str));
                } catch (InvalidCSVException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 15; j++) {
                List<Product> products1 = new ArrayList<>();
                Invoice invoice = new Invoice();
                invoice.setProducts(products1);
                invoice.setCustomer(PersonService.generateCustomer());

                for (int i = 0; i <= ThreadLocalRandom.current().nextInt(1, 6); i++) {
                    products1.add(products.get(ThreadLocalRandom.current().nextInt(products.size())));
                }

                if (invoice.getProducts().stream().mapToDouble(Product::getPrice).sum() > priceLimit) {
                    invoice.setType("wholesale");
                } else {
                    invoice.setType("retail");
                }
                invoice.setCreated(new Date());
                orders.add(invoice);
                log(invoice.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Product parseFromCSV(String csvString) throws InvalidCSVException {
        List<String> params = Arrays
                .stream(csvString
                        .split(","))
                .collect(Collectors.toList());
        Product product = null;

        try {
            if (params.get(0).equals("Telephone")) {
                if (params.size() < 7 || params.stream().anyMatch(String::isEmpty)) {
                    throw new InvalidCSVException("Invalid CSV string at: " + csvString);
                }

                product = new Telephone(params.get(1), params.get(4), params.get(5), Double.parseDouble(params.get(6)));
            } else if (params.get(0).equals("Television")) {
                if (params.size() < 7 || params.stream().anyMatch(String::isEmpty)) {
                    throw new InvalidCSVException("Invalid CSV string at: " + csvString);
                }

                product = new Television(params.get(1), Double.parseDouble(params.get(3)), params.get(4), params.get(5), Double.parseDouble(params.get(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (product == null) {
            throw new InvalidCSVException("Invalid CSV string at: " + csvString);
        }

        return product;
    }

    public List<Invoice> getOrders() {
        return orders;
    }

    public void log(String message) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("[")
                .append(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()))
                .append("] ")
                .append("[")
                .append(message)
                .append("]\n");

        try {
            Files.writeString(Paths.get(logFilePath), stringBuilder.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

