package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, -1, -2, -3);
        List<Integer> positive = numbers.stream()
                .filter(e -> e > 0)
                .toList();
        positive.forEach(System.out::println);
    }
}