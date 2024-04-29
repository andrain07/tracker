package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String department : departments) {
            String[] elements = department.split("/");
            StringBuilder start = new StringBuilder(elements[0]);
            temp.add(start.toString());
            for (int i = 1; i < elements.length; i++) {
                start
                        .append("/")
                        .append(elements[i]);
                temp.add(start.toString());
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}