package ru.vetoshkin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public abstract class FuzzyOutputService extends FuzzyService {
    public abstract SystemFunctions cutting(Param param, double value);


    protected Pair<Point, Point> getParams(Param param, double value) {
        SystemFunctions system = getSystem(param);
        if (system.getSystem().size() != 2)
            throw new IllegalStateException("max 2 function");

        Line line = new Line(new Point(0, value), new Point(1, value));

        Point start = system.getSystem().get(0).getLine().getCrossing(line);
        Point end   = system.getSystem().get(1).getLine().getCrossing(line);

        return new Pair<>(start, end);
    }


    @ToString
    @Getter
    @RequiredArgsConstructor
    protected static class Pair<K, V> {
        protected final K first;
        protected final V second;
    }

}
