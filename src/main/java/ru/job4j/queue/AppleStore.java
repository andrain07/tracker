package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Queue<Customer> queue = new LinkedList<>(this.queue);
        for (int i = 0; i < count - 1; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        Queue<Customer> queue = new LinkedList<>(this.queue);
        int size = queue.size();
        for (int i = 0; i < size - 1 && i < count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }
}