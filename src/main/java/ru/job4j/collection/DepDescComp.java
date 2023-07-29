package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        String[] split1 = str1.split("/", 2);
        String[] split2 = str2.split("/", 2);
        int firstComparison = split2[0].compareTo(split1[0]);
        if (firstComparison != 0) {
            return firstComparison;
        } else {
            if (split1.length > 1 && split2.length > 1) {
                return split1[1].compareTo(split2[1]);
            } else if (split1.length > 1) {
                return 1;
            } else if (split2.length > 1) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}