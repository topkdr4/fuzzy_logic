package ru.vetoshkin.input.service;
import ru.vetoshkin.FuzzyService;
import ru.vetoshkin.SystemFunctions;

import static ru.vetoshkin.input.InputSpeed.HIGH;
import static ru.vetoshkin.input.InputSpeed.NOT_HIGH;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputSpeedService extends FuzzyService {

    public InputSpeedService() {
        super();
    }


    @Override
    public void init() {
        SystemFunctions notHighSystem = new SystemFunctions();
        notHighSystem.addFunction(value -> value <= 800, new Line(new Point(0, 1),   new Point(800, 1)));
        notHighSystem.addFunction(value -> value > 800,  new Line(new Point(800, 1), new Point(1000, 0)));

        putFunction(NOT_HIGH, notHighSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value < 1000,  new Line(new Point(800, 0),  new Point(1000, 1)));
        highSystem.addFunction(value -> value >= 1000, new Line(new Point(1000, 1), new Point(1100, 1)));

        putFunction(HIGH, highSystem);
    }


}
