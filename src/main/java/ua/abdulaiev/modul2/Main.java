package ua.abdulaiev.modul2;

import ua.abdulaiev.modul2.modelclass.*;
import ua.abdulaiev.modul2.serviceclass.ShopService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final double PRICE_LIMIT = confirmLimit();
    static ShopService shopService = new ShopService(PRICE_LIMIT, "src\\main\\resources\\OrdersLogs.log");

    public static void main(String[] args) {
        shopService.readOrders("Orders1.csv");
        //shopService.readOrders("Orders2.csv");
        //shopService.readOrders("Orders3.csv");

        printSoldTelephone();
        printSoldTelevision();
        printSmallestOrders();
        printAllSum();
        printRetailCount();
        printOneTypeOfProduct();
        printFirstThreeOrders();
        printOrdersAgeSmallerighteenAndChangeType();
        printSortOrders();
    }

    public static void printSoldTelephone() {
        System.out.print("Sold Telephone: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getProducts().stream().anyMatch(product -> product.getType() == Type.PHONE))
                .count()
        );
        System.out.println();
    }

    public static void printSoldTelevision() {
        System.out.print("Sold Television: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getProducts().stream().anyMatch(product -> product.getType() == Type.TV))
                .count()
        );
        System.out.println();
    }

    public static void printSmallestOrders() {
        shopService
                .getOrders()
                .stream()
                .min(Comparator.comparingDouble(invoice -> invoice.getProducts().stream().mapToDouble(Product::getPrice).sum()))
                .ifPresent(smallestOrder -> {
                    System.out.println("Smallest order: ");
                    System.out.println(" - Sum: " + smallestOrder.getProducts().stream().mapToDouble(Product::getPrice).sum());
                    System.out.println(" - Customer: " + smallestOrder.getCustomer());
                });

        System.out.println();
    }

    public static void printAllSum() {
        System.out.print("All sum: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .mapToDouble(invoice -> invoice.getProducts().stream().mapToDouble(Product::getPrice).sum())
                .sum()
        );
        System.out.println();
    }

    public static void printRetailCount() {
        System.out.print("Retail count: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getType().equals("retail"))
                .count()
        );
        System.out.println();
    }

    public static void printOneTypeOfProduct() {
        System.out.print("One type of product for invoice count: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getProducts().stream().allMatch(product -> product.getType() == Type.PHONE) || invoice.getProducts().stream().allMatch(product -> product.getType() == Type.TV))
                .collect(Collectors.toList())
        );
        System.out.println();
    }

    public static void printFirstThreeOrders() {
        if (shopService.getOrders().size() >= 3) {
            System.out.print("First 3 orders: ");
            List<Invoice> collect = shopService
                    .getOrders()
                    .stream()
                    .sorted(Comparator.comparing((Invoice invoice) -> invoice.getCreated().getTime()))
                    .limit(3)
                    .collect(Collectors.toList());
            System.out.println(collect);
            System.out.println();
        }
    }

    public static void printOrdersAgeSmallerighteenAndChangeType() {
        System.out.print("Orders age < 18: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getCustomer().getAge() < 18)
                .peek(invoice -> invoice.setType("low_age"))
                .count()
        );
        System.out.println();
    }

    public static void printSortOrders() {
        System.out.print("Sort");
        List<Invoice> collect = shopService
                .getOrders()
                .stream()
                .sorted(Comparator.comparing((Invoice invoice) -> invoice.getCustomer().getAge()).reversed()
                        .thenComparing(invoice -> invoice.getProducts().size())
                        .thenComparing(invoice -> invoice.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum()))
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println();
    }

    public static double confirmLimit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Price limit: ");

        return scanner.nextDouble();
    }
}