package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenDescComparator() {
        var items = new ArrayList<Item>();
        Item item1 = new Item(1, "Test1");
        Item item2 = new Item(2, "Test2");
        Item item3 = new Item(3, "Test3");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        var expected = new ArrayList<Item>();
        expected.add(item3);
        expected.add(item2);
        expected.add(item1);
        items.sort(new ItemDescByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }
}