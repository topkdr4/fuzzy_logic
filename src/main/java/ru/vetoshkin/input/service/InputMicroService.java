package ru.vetoshkin.input.service;
import ru.vetoshkin.FuzzyService;
import ru.vetoshkin.SystemFunctions;

import static ru.vetoshkin.input.InputMicro.*;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputMicroService extends FuzzyService {

    @Override
    protected void init() {
        SystemFunctions lowSystem = new SystemFunctions();
        lowSystem.addFunction(value -> value <= 350, getFunction(new Point(0,   1), new Point(350, 1)));
        lowSystem.addFunction(value -> value > 350,  getFunction(new Point(350, 1), new Point(500, 0)));

        putFunction(LOW, lowSystem);


        SystemFunctions acceptSystem = new SystemFunctions();
        acceptSystem.addFunction(value -> value < 500, getFunction(new Point(350, 0), new Point(500, 1)));
        acceptSystem.addFunction(value -> value >= 500 && value <= 800, getFunction(new Point(500, 1), new Point(800, 1)));
        acceptSystem.addFunction(value -> value > 800, getFunction(new Point(800, 1), new Point(1000, 0)));

        putFunction(ACCEPTABLE, acceptSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value < 1000,  getFunction(new Point(800,  0), new Point(1000, 1)));
        highSystem.addFunction(value -> value >= 1000, getFunction(new Point(1000, 1), new Point(1100, 1)));

        putFunction(HIGH, highSystem);
    }

}
