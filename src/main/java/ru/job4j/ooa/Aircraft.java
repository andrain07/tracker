package ru.job4j.ooa;

public class Aircraft {
    private final String model;

    public Aircraft(String model) {
        this.model = model;
    }

    public void printModel() {
        System.out.println(model);
    }
}