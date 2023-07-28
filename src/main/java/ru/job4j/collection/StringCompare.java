package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.length() == 0 && right.length() == 0) {
            return 0;
        } else if (left.length() == 0) {
            return -1;
        } else if (right.length() == 0) {
            return 1;
        }

        int charComparisonResult;
        for (int i = 0; i < left.length(); i++) {
            if (i >= right.length()) {
                return 1;
            }

            charComparisonResult = Integer.compare(left.charAt(i), right.charAt(i));
            if (charComparisonResult > 0) {
                return 1;
            } else if (charComparisonResult < 0) {
                return -1;
            }
        }

        if (left.length() < right.length()) {
            return -1;
        }

        return 0;
    }
}
