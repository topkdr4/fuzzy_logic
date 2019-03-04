package ru.vetoshkin.input.service;
import ru.vetoshkin.input.InputChlorine;
import ru.vetoshkin.input.InputParam;

import static ru.vetoshkin.input.InputChlorine.ACCEPTABLE;
import static ru.vetoshkin.input.InputChlorine.HIGH;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class ChlorineService extends InputService<InputParam> {


    public ChlorineService() {
        super();
    }


    @Override
    protected void init() {
        SystemFunctions acceptableSystem = new SystemFunctions();
        acceptableSystem.addFunction(value -> value <= 400, getFunction(new Point(0,   1), new Point(400, 1)));
        acceptableSystem.addFunction(value -> value > 400,  getFunction(new Point(400, 1), new Point(600, 0)));

        systemFunction.put(ACCEPTABLE, acceptableSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value <  600, getFunction(new Point(400, 0), new Point(600,  1)));
        highSystem.addFunction(value -> value >= 600, getFunction(new Point(600, 1), new Point(1000, 1)));

        systemFunction.put(HIGH, highSystem);
    }


    @Override
    public InputChlorine getValue(double value) {
        double acceptable = getValue(ACCEPTABLE, value);
        double high       = getValue(HIGH, value);

        int compare = Double.compare(acceptable, high);

        if (compare >= 0)
            return new InputChlorine(ACCEPTABLE, acceptable);

        return new InputChlorine(HIGH, high);
    }

}
