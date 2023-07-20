package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (Item item : items) {
            if (item != null && item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.size()];
        int counter = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result[counter++] = item;
            }
        }
        result = Arrays.copyOf(result, counter);
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int deletedItemIndex = indexOf(id);
        boolean result = deletedItemIndex != -1;
        if (result) {
            items.remove(deletedItemIndex);
        }
        return result;
    }
}