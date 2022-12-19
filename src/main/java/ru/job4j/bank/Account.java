package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает личный банковский счет пользователя
 * @author SERGEY LARICHEV
 * @version 1.0
 */
public class Account {
    /**
     * Хранение реквизитов счета осуществляется в строке типа String
     */
    private String requisite;
    /**
     * Хранение баланса счета осуществляется в числе типа double
     */
    private double balance;

    /**
     * Конструктор класса Account
     * создает новый счет по заданным реквизитам с заданным балансом
     * @param requisite реквизиты нового счета
     * @param balance баланс нового счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает реквизиты текущего счета
     * @return возврвщает реквизиты текущего пользователя
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод изменяет реквизиты текущего счета на новые
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает баланс текущего счета
     * @return возвращает баланс текущего счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод изменяет баланс текущего счета на новый
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals для корректного сравнения счетов
     * @param o объект для сравнения
     * @return возвращает true если счета одинаковые и false если нет
     */
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

    /**
     * Переопределение метода hashCode для корректного сравнения счетов
     * @return возвращает hashCode реквизитов счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
