package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {
    private final String name;

    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int nameComparisonResult = Objects.compare(name, o.name, Comparator.naturalOrder());
        if (nameComparisonResult == 0) {
            return Integer.compare(age, o.age);
        }
        return nameComparisonResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}