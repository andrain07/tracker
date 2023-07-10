package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                result[size++] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[size++] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int oldItemIndex = indexOf(id);
        if (oldItemIndex != -1) {
            int oldItemId = items[oldItemIndex].getId();
            item.setId(oldItemId);
            items[oldItemIndex] = item;
            result = true;
        }
        return result;
    }
}