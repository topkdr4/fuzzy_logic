package ru.vetoshkin.input.service;
import ru.vetoshkin.FuzzyService;
import ru.vetoshkin.SystemFunctions;

import static ru.vetoshkin.input.InputTurbidity.HIGH;
import static ru.vetoshkin.input.InputTurbidity.LOW;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputTurbidityService extends FuzzyService {

    @Override
    public void init() {
        SystemFunctions lowSystem = new SystemFunctions();
        lowSystem.addFunction(value -> value > 350,  new Line(new Point(350, 1), new Point(500, 0)));
        lowSystem.addFunction(value -> value <= 350, new Line(new Point(0,   1), new Point(350, 1)));

        putFunction(LOW, lowSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value <  500, new Line(new Point(350, 0), new Point(500,  1)));
        highSystem.addFunction(value -> value >= 500, new Line(new Point(500, 1), new Point(1000, 1)));

        putFunction(HIGH, highSystem);
    }

}
