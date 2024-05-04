package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameMatchesKey = person -> person.getName().contains(key);
        Predicate<Person> surnameMatchesKey = person -> person.getSurname().contains(key);
        Predicate<Person> addressMatchesKey = person -> person.getAddress().contains(key);
        Predicate<Person> phoneMatchesKey = person -> person.getPhone().contains(key);
        var combine = nameMatchesKey
                .or(surnameMatchesKey)
                .or(addressMatchesKey)
                .or(phoneMatchesKey);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}