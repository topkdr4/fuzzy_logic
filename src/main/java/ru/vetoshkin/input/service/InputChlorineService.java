package ru.vetoshkin.input.service;
import ru.vetoshkin.FuzzyService;
import ru.vetoshkin.SystemFunctions;

import static ru.vetoshkin.input.InputChlorine.ACCEPTABLE;
import static ru.vetoshkin.input.InputChlorine.HIGH;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputChlorineService extends FuzzyService {

    @Override
    public void init() {
        SystemFunctions acceptableSystem = new SystemFunctions();
        acceptableSystem.addFunction(value -> value <= 400, getFunction(new Point(0,   1), new Point(400, 1)));
        acceptableSystem.addFunction(value -> value > 400,  getFunction(new Point(400, 1), new Point(600, 0)));

        putFunction(ACCEPTABLE, acceptableSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value <  600, getFunction(new Point(400, 0), new Point(600,  1)));
        highSystem.addFunction(value -> value >= 600, getFunction(new Point(600, 1), new Point(1000, 1)));

        putFunction(HIGH, highSystem);
    }

}
