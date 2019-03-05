package ru.vetoshkin.output.service;

import ru.vetoshkin.FuzzyOutputService;
import ru.vetoshkin.Param;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.output.OutputSpeed;


/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputSpeedService extends FuzzyOutputService {

    @Override
    public void init() {
        SystemFunctions negativeSystem = new SystemFunctions();
        negativeSystem.addFunction(value -> value <= -20, getFunction(new Point(-50, 0), new Point(-20, 1)));
        negativeSystem.addFunction(value -> value >  -20, getFunction(new Point(-20, 1), new Point(10,  0)));

        putFunction(OutputSpeed.NEGATIVE, negativeSystem);


        SystemFunctions positiveSystem = new SystemFunctions();
        positiveSystem.addFunction(value -> value <= 20, getFunction(new Point(-10, 0), new Point(20, 1)));
        positiveSystem.addFunction(value -> value >  20, getFunction(new Point(20,  1), new Point(50, 0)));

        putFunction(OutputSpeed.POSITIVE, positiveSystem);
    }




    @Override
    public void cutting(Param param, double value) {

    }
}
