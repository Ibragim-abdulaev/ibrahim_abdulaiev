package ua.abdulaiev.hw17.task5;

import lombok.Value;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Value
public class BoxService {
    public static String randomString() {
        final int MAX_STRING_LEN = 7;
        char[] chars = "abcdefghefgijklmnoprstuvwxyz".toCharArray();
        String randStr = "";

        for (int i = MAX_STRING_LEN; i > 0; i--) {
            randStr += chars[new Random().nextInt(chars.length)];
        }

        return randStr;
    }

    public static double randomDouble() {
        final double MAX_DOUBLE = 999.9;
        Random r = new Random();

        return 0 + (MAX_DOUBLE) * r.nextDouble();
    }

    public static Item randomItem() {
        return new Item(randomString(), randomDouble());
    }

    public static Box randomBox() {
        final int MAX_ITEMS = 3;
        Box box = new Box();

        for (int i = MAX_ITEMS; i > 0; i--) {
            box.addItem(randomItem());
        }

        return box;
    }

    public static List<Item> filterBoxes(List<Box> boxes, int limit) throws IndexOutOfBoundsException {
        if (limit < 0 || limit > boxes.size()) {
            throw new IndexOutOfBoundsException();
        }

        return boxes
                .subList(0, limit)
                .stream()
                .flatMap(box -> box.getItems().stream())
                .collect(Collectors.toList());
    }

    public static void printItemsList(List<Item> items) {

    }
}
