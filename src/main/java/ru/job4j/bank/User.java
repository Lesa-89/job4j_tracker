package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает простейшую модель пользователя банка
 * @author SERGEY LARICHEV
 * @version 1.0
 */
public class User {
    /**
     * Хранение номера паспорта осуществляется в строке типа String
     */
    private String passport;
    /**
     * Хранение имени пользователя осуществляется в строке типа String
     */
    private String username;

    /**
     * Конструктор класса User
     * создает нового пользователя по заданному номеру паспорта и имени пользователя
     * @param passport номер паспорта нового пользователя
     * @param username имя нового пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает номер паспорта текущего пользователя
     * @return возвращает номер паспорта текущего пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод изменяет номер паспорта текущего пользователя новый
     * @param passport новый номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя текущего пользователя
     * @return возвращает имя текущего пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод изменяет имя текущего пользователя пользователя новое
     * @param username новое имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals для корректного сравнения пользователей
     * @param o объект для сравнения
     * @return возвращает true если пользователи одинаковые и false если нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode для корректного сравнения пользователей
     * @return возвращает hashCode номера паспорта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
