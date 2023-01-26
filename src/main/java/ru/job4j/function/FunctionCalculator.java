package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        Consumer<Double> con = s -> res.add(func.apply(s));
        for (int i = start; i < end; i++) {
            con.accept((double) i);
        }
        return res;
    }
}
