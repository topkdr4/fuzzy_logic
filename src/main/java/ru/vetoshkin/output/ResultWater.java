package ru.vetoshkin.output;
import lombok.AllArgsConstructor;

import java.util.function.Function;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public enum ResultWater implements Function<Double, Double> {
    NEGATIVE("Отрицательное", value -> {
        if (value <= -150)
            return 0d;

        if (value == -70)
            return 1d;

        if (value >= 20)
            return 0d;

        return Math.abs(value / 20);
    }),
    POSITIVE("Положительное", value -> {
        if (value <= -20)
            return 0d;

        if (value == 70)
            return 1d;

        if (value >= 150)
            return 0d;

        return value / 150d;
    })
    ;

    private final String count;
    private final Function<Double, Double> fuzzyFunc;


    @Override
    public Double apply(Double t) {
        return fuzzyFunc.apply(t);
    }
}
