package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine;
        Predicate<Person> nameMatchesKey = person -> person.getName().equals(key);
        Predicate<Person> surnameMatchesKey = person -> person.getSurname().equals(key);
        Predicate<Person> addressMatchesKey = person -> person.getAddress().equals(key);
        Predicate<Person> phoneMatchesKey = person -> person.getPhone().equals(key);
        combine = nameMatchesKey
                .or(surnameMatchesKey)
                .or(addressMatchesKey)
                .or(phoneMatchesKey);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}