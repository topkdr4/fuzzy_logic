package ru.vetoshkin.input.service;
import lombok.AllArgsConstructor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public abstract class InputService<T extends Enum<T>> {
    protected final Map<T, SystemFunctions> systemFunction;


    public InputService(Class<T> clazz) {
        systemFunction = new EnumMap<>(clazz);
        init();
    }


    protected abstract void init();


    public abstract T getValue(double value);


    protected double getValue(T t, double value) {
        return systemFunction.get(t).calc(value);
    }


    protected static Function<Double, Double> getFunction(Point pointA, Point pointB) {
        double k = (pointB.y - pointA.y) / (pointB.x - pointA.x);
        double b = (pointB.x * pointA.y - pointA.x * pointB.y) / (pointB.x - pointA.x);

        return (value) -> k * value + b;
    }


    @AllArgsConstructor
    protected static class Point {
        private final double x;
        private final double y;
    }

}
