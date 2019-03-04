package ru.vetoshkin;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public abstract class FuzzyService {
    private final Map<Param, SystemFunctions> systemFunction = new ConcurrentHashMap<>();


    protected FuzzyService() {
        init();
    }


    protected abstract void init();


    protected void putFunction(Param key, SystemFunctions value) {
        this.systemFunction.put(key, value);
    }


    public double getValue(Param t, double value) {
        return systemFunction.get(t).calc(value);
    }


    public Param getVal(Param t, double value) {
        return new Param(t, value);
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
