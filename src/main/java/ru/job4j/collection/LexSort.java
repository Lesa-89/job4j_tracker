package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        String[] leftSubstrings = left.split("\\.");
        String[] rightSubstrings = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftSubstrings[0]), Integer.parseInt(rightSubstrings[0]));
    }
}