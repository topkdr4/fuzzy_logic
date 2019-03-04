package ru.vetoshkin.input.service;
import ru.vetoshkin.input.InputParam;
import ru.vetoshkin.input.InputSpeed;

import static ru.vetoshkin.input.InputSpeed.HIGH;
import static ru.vetoshkin.input.InputSpeed.NOT_HIGH;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class SpeedService extends InputService<InputParam> {

    public SpeedService() {
        super();
    }


    @Override
    protected void init() {
        SystemFunctions notHighSystem = new SystemFunctions();
        notHighSystem.addFunction(value -> value <= 800, getFunction(new Point(0, 1),   new Point(800, 1)));
        notHighSystem.addFunction(value -> value > 800,  getFunction(new Point(800, 1), new Point(1000, 0)));

        systemFunction.put(NOT_HIGH, notHighSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value < 1000,  getFunction(new Point(800, 0),  new Point(1000, 1)));
        highSystem.addFunction(value -> value >= 1000, getFunction(new Point(1000, 1), new Point(1100, 1)));

        systemFunction.put(HIGH, highSystem);
    }


    @Override
    public InputSpeed getValue(double value) {
        double notHigh = getValue(NOT_HIGH, value);
        double high = getValue(HIGH, value);

        int compare = Double.compare(notHigh, high);

        if (compare >= 0)
            return new InputSpeed(NOT_HIGH, notHigh);

        return new InputSpeed(HIGH, high);
    }
}
