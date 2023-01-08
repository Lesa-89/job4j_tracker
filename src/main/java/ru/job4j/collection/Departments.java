package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = Objects.equals(start, "") ? el : start + "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Comparator naturalComp  = Comparator.naturalOrder();
        orgs.sort(naturalComp);
    }

    public static void sortDesc(List<String> orgs) {
        fillGaps(orgs);
        DepDescComp reverseComp = new DepDescComp();
        orgs.sort(reverseComp);
    }
}
