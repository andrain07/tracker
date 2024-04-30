package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        String[] split1 = str1.split("/", 2);
        String[] split2 = str2.split("/", 2);
        int firstComparison = split2[0].compareTo(split1[0]);
        return firstComparison != 0 ? firstComparison : str1.compareTo(str2);
    }
}