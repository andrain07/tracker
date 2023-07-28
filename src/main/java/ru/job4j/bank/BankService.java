package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляется нового пользователя в сисетему
     *
     * @param user новый пользовать
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет существующего в системе пользователя по паспортным данным
     *
     * @param passport паспортные данные удаляемого пользователя
     * @return true, если пользователь успешно удален, иначе - false
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Добавляет новый счет к существующему пользователю
     *
     * @param passport паспортные данные пользователя
     * @param account  добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        var userAccounts = users.get(user);
        if (user != null && !userAccounts.contains(account)) {
            userAccounts.add(account);
        }
    }

    /**
     * Ищет в системе существующего пользователя по паспортным данным
     *
     * @param passport паспортные данные искомого пользователя
     * @return найденного User или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ищет счет существующего пользователя по реквезитам счета
     *
     * @param passport паспортные данные удаляемого пользователя
     * @return найденный Account или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Перечисляет деньги со счета одного пользователю другому пользователю
     *
     * @param srcPassport паспортные данные счета отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport паспортные данные счета получателя
     * @param destRequisite реквизиты счета получателя
     * @return true в случае успешного перевода, иначе - false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null
                || destAccount == null
                || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    /**
     * Возвращает список всех счетов пользователя
     *
     * @param user объект пользователя
     * @return список всех счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}