package ru.vetoshkin.input.service;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.input.InputParam;

import static ru.vetoshkin.input.InputTurbidity.HIGH;
import static ru.vetoshkin.input.InputTurbidity.LOW;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputTurbidityService<T extends InputParam> extends InputService<T> {

    public InputTurbidityService() {
        super();
    }


    @Override
    protected void init() {
        SystemFunctions lowSystem = new SystemFunctions();
        lowSystem.addFunction(value -> value >  350, getFunction(new Point(350, 1), new Point(500, 0)));
        lowSystem.addFunction(value -> value <= 350, getFunction(new Point(0, 1),   new Point(350, 1)));

        systemFunction.put(LOW, lowSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value <  500, getFunction(new Point(350, 0), new Point(500,  1)));
        highSystem.addFunction(value -> value >= 500, getFunction(new Point(500, 1), new Point(1000, 1)));

        systemFunction.put(HIGH, highSystem);
    }

}
