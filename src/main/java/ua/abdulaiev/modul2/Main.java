package ua.abdulaiev.modul2;

import ua.abdulaiev.modul2.modelclass.Invoice;
import ua.abdulaiev.modul2.modelclass.Product;
import ua.abdulaiev.modul2.modelclass.Telephone;
import ua.abdulaiev.modul2.modelclass.Television;
import ua.abdulaiev.modul2.serviceclass.ShopService;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final double PRICE_LIMIT = confirmLimit();
    static ShopService shopService = new ShopService(PRICE_LIMIT, "src\\main\\resources\\OrdersLogs.log");

    public static void main(String[] args) {
        shopService.readOrders("src\\main\\resources\\Orders1.csv");

        prinSoldTelephone();
        printSoldTelevision();
        printSmallestOrders();
        printAllSum();
        printRetailCount();
        printOneTypeOfProduct();
        printFirstThreeOrders();
        printOrdersAgeSmallerighteenAndChangeType();
        printSortOrders();
    }

    public static void prinSoldTelephone() {
        System.out.print("Sold Telephone: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getProducts().stream().anyMatch(product -> product instanceof Telephone))
                .count()
        );
        System.out.println();
    }

    public static void printSoldTelevision() {
        System.out.print("Sold Television: ");
        System.out.println(shopService
                .getOrders()
                .stream()
                .filter(invoice -> invoice.getProducts().stream().anyMatch(product -> product instanceof Television))
                .count()
        );
        System.out.println();
    }

    public static void printSmallestOrders() {
        Invoice smallestOrder = shopService
                .getOrders()
                .stream()
                .min(Comparator.comparingDouble(invoice -> invoice.getProducts().stream().mapToDouble(Product::getPrice).sum()))
                .orElse(null);

        if (smallestOrder != null) {
            System.out.println("Smallest order: ");
            System.out.println(" - Sum: " + smallestOrder.getProducts().stream().mapToDouble(Product::getPrice).sum());
            System.out.println(" - Customer: " + smallestOrder.getCustomer());
        }
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
                .filter(invoice -> invoice.getProducts().stream().allMatch(product -> product instanceof Telephone) || invoice.getProducts().stream().allMatch(product -> product instanceof Television))
                .collect(Collectors.toList())
        );
        System.out.println();
    }

    public static void printFirstThreeOrders() {
        if (shopService.getOrders().size() >= 3) {
            System.out.print("First 3 orders: ");
            System.out.println(shopService
                    .getOrders()
                    .subList(0, 3)
            );
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
        shopService
                .getOrders()
                .stream()
                .sorted(Comparator.comparingInt((Invoice invoice) -> invoice.getCustomer().getAge()).reversed())
                .sorted(Comparator.comparingInt(invoice -> invoice.getProducts().size()))
                .sorted(Comparator.comparingDouble(invoice -> invoice.getProducts().stream().mapToDouble(Product::getPrice).sum()));
        System.out.println(shopService.getOrders());
        System.out.println();
    }

    public static double confirmLimit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Price limit: ");

        return scanner.nextDouble();
    }
}