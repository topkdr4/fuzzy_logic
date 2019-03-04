package ru.vetoshkin.input.service;
import lombok.AllArgsConstructor;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.input.InputParam;
import ru.vetoshkin.input.InputTurbidity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public abstract class InputService<T extends InputParam> {
    protected final Map<InputParam, SystemFunctions> systemFunction = new ConcurrentHashMap<>();


    public InputService() {
        init();
    }


    protected abstract void init();


    public double getValue(T t, double value) {
        return systemFunction.get(t).calc(value);
    }


    public InputParam getVal(InputParam t, double value) {
        return new InputParam(t, value);
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
