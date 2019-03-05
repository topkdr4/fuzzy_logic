package ru.vetoshkin;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
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



    @Getter
    @AllArgsConstructor
    public static class SystemHolder {
        private final Predicate<Double> predicate;
        private final FuzzyService.Line line;
    }


    public double calc(double value) {
        for (SystemHolder holder : system) {
            if (holder.predicate.test(value))
                return holder.line.getFunction().apply(value);
        }

        throw new IllegalArgumentException("function not found for value: " + value);
    }
}
