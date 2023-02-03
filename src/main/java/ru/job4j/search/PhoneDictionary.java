package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> isNameContainKey = s -> s.getName().contains(key);
        Predicate<Person> isSurnameContainKey = s -> s.getSurname().contains(key);
        Predicate<Person> isPhoneContainKey = s -> s.getPhone().contains(key);
        Predicate<Person> isAddressContainKey = s -> s.getAddress().contains(key);
        Predicate<Person> combine = isNameContainKey.or(isSurnameContainKey).or(isPhoneContainKey).or(isAddressContainKey);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
