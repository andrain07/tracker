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
            if (item != null && item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int counter = 0;
        for (int i = 0; i <= size; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[counter++] = items[i];
            }
        }
        result = Arrays.copyOf(result, counter);
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
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        int deletedItemIndex = indexOf(id);
        if (deletedItemIndex != -1) {
            System.arraycopy(items, deletedItemIndex + 1, items, deletedItemIndex, size - deletedItemIndex);
            items[items.length - 1] = null;
            result = true;
        }
        return result;
    }
}