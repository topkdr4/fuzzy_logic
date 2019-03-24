package ru.vetoshkin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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


    protected SystemFunctions getSystem(Param param) {
        return systemFunction.get(param);
    }


    public double getValue(Param t, double value) {
        return systemFunction.get(t).calc(value);
    }


    public Param getVal(Param t, double value) {
        return new Param(t, getValue(t, value));
    }


    @Getter
    @AllArgsConstructor
    protected static class Point {
        private final double x;
        private final double y;


        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    @ToString
    protected static class Line {
        private final Point pointA;
        private final Point pointB;

        private double k;
        private double b;

        public Line(Point pointA, Point pointB) {
            this.pointA = pointA;
            this.pointB = pointB;

            this.k = (pointB.y - pointA.y) / (pointB.x - pointA.x);
            this.b = (pointB.x * pointA.y - pointA.x * pointB.y) / (pointB.x - pointA.x);
        }


        public Function<Double, Double> getFunction() {
            return (value) -> k * value + b;
        }


        public Point getCrossing(Line other) {
            double x = (other.b - b) / (k - other.k);
            double y = k * x + b;
            return new Point(x, y);
        }

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
    public static Param NOT(Param a) {
        return new Param(a, 1d - a.value);
    }


    /**
     * Степень истенности записывается как µ(A)
     */
    private static <T> T u(T t) {
        throw new UnsupportedOperationException();
    }
}
