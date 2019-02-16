package ru.vetoshkin.input.service;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class SystemFunctions {
    private final List<SystemHolder> system = new ArrayList<>();


    public void addFunction(Predicate<Double> predicate, Function<Double, Double> function) {
        system.add(new SystemHolder(predicate, function));
    }



    @AllArgsConstructor
    private static class SystemHolder {
        private final Predicate<Double> predicate;
        private final Function<Double, Double> function;
    }


    public double calc(double value) {
        for (SystemHolder holder : system) {
            if (holder.predicate.test(value))
                return holder.function.apply(value);
        }

        throw new IllegalArgumentException("function not found for value: " + value);
    }
}
