package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return  users.remove(new User(passport, "")) != null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}