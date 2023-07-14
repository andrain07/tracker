package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test item");
        tracker.add(item);
        assertThat(item.getId())
                .isEqualTo(tracker
                        .findById(item.getId())
                        .getId()
                );
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isEqualTo(null);
    }
}