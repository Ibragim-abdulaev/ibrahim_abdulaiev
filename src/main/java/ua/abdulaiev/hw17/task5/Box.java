package ua.abdulaiev.hw17.task5;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private List<Item> items;
    private int size;

    public Box() {
        items = new ArrayList<>();
        size = 0;
    }

    public Box(List<Item> items) {
        this.items = new ArrayList<>(items);
        this.size = items.size();
    }

    public void addItem(Item item) {
        items.add(item);

        size = items.size();
    }

    public void removeItem(int index) {
        items.remove(index);

        size = items.size();
    }

    public int getSize() {
        return size;
    }

    public List<Item> getItems() {
        return this.items;
    }
}