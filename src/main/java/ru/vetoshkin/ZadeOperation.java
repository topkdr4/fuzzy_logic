package ru.vetoshkin;
import lombok.AllArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.Function;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public final class ZadeOperation {
    /**
     * Оператор пересечния
     */
    public static final BiFunction<Double, Double, Double> AND = Math::min;


    /**
     * Операция объединения
     */
    public static final BiFunction<Double, Double, Double> OR = Math::max;


    /**
     * Отрицания
     */
    public static final Function<Double, Double> NOT = (a) -> 1 - a;
}

