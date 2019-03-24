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
    public void cutting(Param param, double value) {
        SystemFunctions system = getSystem(param);
        if (system.getSystem().size() != 2)
            throw new IllegalStateException("max 2 function");

        Line line = new Line(new Point(0, value), new Point(1, value));
        System.out.println(line);

        Point start = system.getSystem().get(0).getLine().getCrossing(line);
        Point end   = system.getSystem().get(1).getLine().getCrossing(line);


        if (param == OutputWater.SUPER_POSITIVE) {
            SystemFunctions superTempSystem = new SystemFunctions();
            superTempSystem.addFunction(arg -> arg >= 30 && arg <= start.getX(), new Line(new Point(30, 0), start));
            superTempSystem.addFunction(arg -> arg >= start.getX() && arg <= end.getX(), new Line(start, end));
            superTempSystem.addFunction(arg -> arg <= 90 && arg >= end.getX(), new Line(end, new Point(90, 0)));

            System.out.println(superTempSystem.defuuzz(30, 90));
        }
    }
}
