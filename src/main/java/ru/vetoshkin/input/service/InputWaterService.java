package ru.vetoshkin.input.service;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.input.InputParam;

import static ru.vetoshkin.input.InputWater.HIGH;
import static ru.vetoshkin.input.InputWater.NOT_HIGH;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputWaterService<T extends InputParam> extends InputService<T> {

    public InputWaterService() {
        super();
    }


    @Override
    protected void init() {
        SystemFunctions notHighSystem = new SystemFunctions();
        notHighSystem.addFunction(value -> value <= 800, getFunction(new Point(0,   1), new Point(800, 1)));
        notHighSystem.addFunction(value -> value >  800, getFunction(new Point(800, 1), new Point(1000, 0)));

        systemFunction.put(NOT_HIGH, notHighSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value <  1000, getFunction(new Point(800,  0), new Point(1000, 1)));
        highSystem.addFunction(value -> value >= 1000, getFunction(new Point(1000, 1), new Point(1100, 1)));

        systemFunction.put(HIGH, highSystem);
    }

}