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


    public abstract void init();


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


    //******************************************************************


    /**
     * Оператор пересечния
     */
    public static Param AND(Param a, Param b) {
        int compare = a.compareTo(b);
        if (compare <= 0)
            return a;

        return b;
    }


    /**
     * Операция объединения
     */
    public static Param OR(Param a, Param b) {
        int compare = a.compareTo(b);
        if (compare < 0)
            return a;

        return b;
    }


    /**
     * Отрицания
     */
    public static double NOT(double a) {
        return 1d - a;
    }


    /**
     * Степень истенности записывается как µ(A)
     */
    private static <T> T u(T t) {
        throw new UnsupportedOperationException();
    }
}
