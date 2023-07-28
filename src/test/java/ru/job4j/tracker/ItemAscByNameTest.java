package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
class ItemAscByNameTest {
    @Test
    public void whenAscComparator() {
        var items = new ArrayList<Item>();
        Item item1 = new Item(1, "Test1");
        Item item2 = new Item(2, "Test2");
        Item item3 = new Item(3, "Test3");
        items.add(item3);
        items.add(item2);
        items.add(item1);
        var expected = new ArrayList<Item>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        items.sort(new ItemAscByName());
        assertThat(items).containsExactlyElementsOf(expected);
    }
}