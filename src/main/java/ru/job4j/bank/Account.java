package ru.job4j.bank;

import java.util.Objects;

/**
 * Данный класс представляет модель банковского счета
 * @author Andrey
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты банковского счета
     */
    private String requisite;
    /**
     * Баланс банковского счета
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Позволяет получить значение поля {@link #requisite}
     * @return значение поля {@link #requisite}
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Позволяет установить новое значение полю {@link #requisite}
     * @param requisite новое значение поля {@link #requisite}
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Позволяет получить значение поля {@link #balance}
     * @return значение поля {@link #balance}
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Позволяет установить новое значение полю {@link #balance}
     * @param balance новое значение поля {@link #balance}
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}