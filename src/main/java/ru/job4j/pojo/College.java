package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student vova = new Student();
        vova.setName("Vova");
        vova.setGroup("54F");
        vova.setReceiptDate(LocalDate.of(2019, 9, 1));
        String ln = System.lineSeparator();
        String formatVovaReceiptDate = vova.getReceiptDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.printf("Name: %s%4$sGroup: %s%4$sReceipt Date: %s%4$s",
                vova.getName(), vova.getGroup(), formatVovaReceiptDate, ln);
    }
}
