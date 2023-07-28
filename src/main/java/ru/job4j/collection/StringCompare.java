package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char leftChar;
        char rightChar;
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            leftChar = left.charAt(i);
            rightChar = right.charAt(i);
            if (leftChar != rightChar) {
                return Character.compare(leftChar, rightChar);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
