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
        String lastHappyCustomerName = "";
        Queue<Customer> queue = new LinkedList<>(this.queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (i == count - 1) {
                lastHappyCustomerName = queue.poll().name();
                break;
            }
            queue.poll();
        }
        return lastHappyCustomerName;
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomerName = "";
        Queue<Customer> queue = new LinkedList<>(this.queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (i == count) {
                firstUpsetCustomerName = queue.poll().name();
                break;
            }
            queue.poll();
        }
        return firstUpsetCustomerName;
    }
}