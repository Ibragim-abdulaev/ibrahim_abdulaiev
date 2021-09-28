package ua.abdulaiev.hw17.task5;

import java.util.ArrayList;
import java.util.List;

import static ua.abdulaiev.hw17.task5.BoxService.filterBoxes;
import static ua.abdulaiev.hw17.task5.BoxService.randomBox;

public class Task5 {
    public static void main(String[] args) {
        final int MAX_BOXES = 10;
        List<Box> boxes = new ArrayList<>();

        for (int i = MAX_BOXES; i > 0; i--) {
            boxes.add(randomBox());
        }

        final int LIMIT = 2;
        List<Item> filteredItems = filterBoxes(boxes, LIMIT);

        filteredItems
                .stream()
                .sorted((i1, i2) -> (int) (i1.getCost() - i2.getCost()))
                .forEach(System.out::println);
    }
}
