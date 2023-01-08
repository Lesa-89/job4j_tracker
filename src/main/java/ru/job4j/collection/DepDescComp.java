package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @SuppressWarnings("checkstyle:WhitespaceAround")
    @Override
    public int compare(String o1, String o2) {
        String[] o1s = o1.split("/");
        String[] o2s = o2.split("/");
        return o2s[0].equals(o1s[0]) ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}