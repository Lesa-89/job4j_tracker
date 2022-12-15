package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa@mail.ru", "Ivan Ivanov");
        map.put("bbb@mail.ru", "Petr Petrov");
        map.put("ccc@mail.ru", "Semen Semenov");
        map.put("ddd@mail.ru", "Andrey Andreev");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
