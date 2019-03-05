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
        negativeSystem.addFunction(value -> value <= -20, getFunction(new Point(-50, 0), new Point(-20, 1)));
        negativeSystem.addFunction(value -> value >  -20, getFunction(new Point(-20, 1), new Point(10,  0)));

        putFunction(OutputWater.NEGATIVE, negativeSystem);


        SystemFunctions positiveSystem = new SystemFunctions();
        positiveSystem.addFunction(value -> value <= 20, getFunction(new Point(-10, 0), new Point(20, 1)));
        positiveSystem.addFunction(value -> value >  20, getFunction(new Point(20,  1), new Point(50, 0)));

        putFunction(OutputWater.POSITIVE, positiveSystem);


        SystemFunctions superPositiveSystem = new SystemFunctions();
        superPositiveSystem.addFunction(value -> value <= 60, getFunction(new Point(30, 0), new Point(60, 1)));
        superPositiveSystem.addFunction(value -> value > 60,  getFunction(new Point(60, 1), new Point(90, 0)));

        putFunction(OutputWater.SUPER_POSITIVE, superPositiveSystem);
    }


    @Override
    public void cutting(Param param, double value) {

    }
}
