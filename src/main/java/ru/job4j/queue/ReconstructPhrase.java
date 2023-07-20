package ru.job4j.queue;

import java.util.Deque;
import java.util.LinkedList;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        Deque<Character> evenElements = new LinkedList<>(this.evenElements);
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            Character symbol = evenElements.pollFirst();
            if (i % 2 == 0) {
                result.append(symbol);
            }
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        Deque<Character> descendingElements = new LinkedList<>(this.descendingElements);
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            result.append(descendingElements.pollLast());
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}