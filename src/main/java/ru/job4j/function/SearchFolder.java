package ru.job4j.function;

import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        return list
                .stream()
                .filter(predicate)
                .toList();
    }
}