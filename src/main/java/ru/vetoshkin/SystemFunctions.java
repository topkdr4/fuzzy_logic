package ru.vetoshkin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class SystemFunctions {
    @Getter
    private final List<SystemHolder> system = new ArrayList<>();


    public void addFunction(Predicate<Double> predicate, FuzzyService.Line line) {
        system.add(new SystemHolder(predicate, line));
    }


    @ToString
    @Getter
    @AllArgsConstructor
    public static class SystemHolder {
        private final Predicate<Double> predicate;
        private final FuzzyService.Line line;
    }


    public double calc(double value) {
        for (SystemHolder holder : system) {
            if (holder.predicate.test(value)) {
                double val = holder.line.getFunction().apply(value);
                return val > 0 ? val : 0;
            }
        }

        return 0;
    }



    private static final double delta = 0.01;


    private static double sum(List<Double> source) {
        double result = 0;

        for (Double val : source)
            result += val;

        return result;
    }



    public double gravityCenter(double from, double to) {
        List<Double> a = new ArrayList<>();
        List<Double> b = new ArrayList<>();


        for (double i = from; i <= to; i += delta) {
            double data = calc(i);
            a.add(data * i);
            b.add(data);
        }

        return sum(a) / sum(b);
    }


    public static SystemFunctions addConstraints(FuzzyOutputService.Pair<FuzzyService.Point, FuzzyService.Point> points, FuzzyOutputService.Pair<Double, Double> constraints) {
        FuzzyService.Point start = points.getFirst();
        FuzzyService.Point end   = points.getSecond();

        double min = constraints.getFirst();
        double max = constraints.getSecond();

        SystemFunctions superTempSystem = new SystemFunctions();
        superTempSystem.addFunction(arg -> arg >= min && arg <= start.getX(), new FuzzyService.Line(new FuzzyService.Point(min, 0), start));
        superTempSystem.addFunction(arg -> arg >= start.getX() && arg <= end.getX(), new FuzzyService.Line(start, end));
        superTempSystem.addFunction(arg -> arg <= max && arg >= end.getX(), new FuzzyService.Line(end, new FuzzyService.Point(max, 0)));

        return superTempSystem;
    }
}
