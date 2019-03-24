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


    public SystemFunctions copy() {
        SystemFunctions result = new SystemFunctions();
        result.system.addAll(system);
        return result;
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
}
