package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 * с простейшими операциями с пользователями и их счетами
 * @author SERGEY LARICHEV
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение базы пользователей осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя и добавляет его в базу если его там нет.
     * @param user пользователь который добавляется в базу
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из базы если он там есть.
     * @param passport номер паспорта пользователя
     * @return возвращает true если пользователь удален и false если нет
     */
    public boolean deleteUser(String passport) {
        return  users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод ищет пользователя по номеру паспорта, и если такой пользователь есть,
     * добавляет ему указанный счет
     * @param passport номер паспорта пользователя
     * @param account счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя если он найден или null если нет
     */
    public User findByPassport(String passport) {
        User res = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                res = user;
                break;
            }
        }
        return res;
    }

    /**
     * Метод ищет счет по номеру паспорта и реквизитам счета
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return возвращает счет если он найден или null если нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account res = null;
        if (user != null) {
            List<Account> list = getAccounts(user);
            for (Account account : list) {
                if (requisite.equals(account.getRequisite())) {
                    res = account;
                    break;
                }

            }
        }
        return res;
    }

    /**
     * Метод производит поиск счетов отправителя и получателя по номеру паспорта и реквизитам
     * и осуществляет перевод средств с счета отправителя на счет получателя
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод удался и false если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDest = findByRequisite(destPassport, destRequisite);
        if (accSrc != null && accDest != null && accSrc.getBalance() >= amount) {
            accSrc.setBalance(accSrc.getBalance() - amount);
            accDest.setBalance(accDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список счетов пользователя
     * @param user пользователь
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}