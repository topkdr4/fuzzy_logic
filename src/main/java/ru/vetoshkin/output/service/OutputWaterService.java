package ru.vetoshkin.output.service;

import ru.vetoshkin.FuzzyOutputService;
import ru.vetoshkin.Param;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.output.OutputWater;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputWaterService extends FuzzyOutputService {


    @Override
    public void init() {
        SystemFunctions negativeSystem = new SystemFunctions();
        negativeSystem.addFunction(value -> value <= -20, new Line(new Point(-50, 0), new Point(-20, 1)));
        negativeSystem.addFunction(value -> value >  -20, new Line(new Point(-20, 1), new Point(10,  0)));

        putFunction(OutputWater.NEGATIVE, negativeSystem);


        SystemFunctions positiveSystem = new SystemFunctions();
        positiveSystem.addFunction(value -> value <= 20, new Line(new Point(-10, 0), new Point(20, 1)));
        positiveSystem.addFunction(value -> value >  20, new Line(new Point(20,  1), new Point(50, 0)));

        putFunction(OutputWater.POSITIVE, positiveSystem);


        SystemFunctions superPositiveSystem = new SystemFunctions();
        superPositiveSystem.addFunction(value -> value <= 60, new Line(new Point(30, 0), new Point(60, 1)));
        superPositiveSystem.addFunction(value -> value > 60,  new Line(new Point(60, 1), new Point(90, 0)));

        putFunction(OutputWater.SUPER_POSITIVE, superPositiveSystem);
    }


    @Override
    public SystemFunctions cutting(Param param, double value) {
        Pair<Point, Point> points = getParams(param, value);

        if (param == OutputWater.SUPER_POSITIVE) {
            return SystemFunctions.addConstraints(points, new Pair<>(30d, 90d));
        } else if (param == OutputWater.POSITIVE) {
            return SystemFunctions.addConstraints(points, new Pair<>(-10d, 50d));
        } else if (param == OutputWater.NEGATIVE) {
            return SystemFunctions.addConstraints(points, new Pair<>(-50d, 10d));
        }


        throw new IllegalArgumentException("unknown parameter");
    }
}
