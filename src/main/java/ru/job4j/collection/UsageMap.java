package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("vasyapupkin@gmail.com", "Vasya Pupkin");
        for (String personEmail : accounts.keySet()) {
            System.out.printf("Email: %s | Full name: %s\n",
                    personEmail,
                    accounts.get(personEmail)
            );
        }
    }
}
