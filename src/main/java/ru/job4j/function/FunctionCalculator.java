package ru.job4j.function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        return IntStream
                .range(start, end)
                .mapToObj(i -> function.apply((double) i))
                .toList();
    }
}