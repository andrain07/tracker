package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        StringBuilder departmentName;
        List<String> departments;
        for (String value : deps) {
            departments = List.of(value.split("/"));
            departmentName = new StringBuilder(departments.get(0));
            tmp.add(departmentName.toString());
            for (int i = 1; i < departments.size(); i++) {
                departmentName.append("/").append(departments.get(i));
                tmp.add(departmentName.toString());
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}