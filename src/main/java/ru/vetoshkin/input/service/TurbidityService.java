package ru.vetoshkin.input.service;
import ru.vetoshkin.input.InputTurbidity;

import static ru.vetoshkin.input.InputTurbidity.HIGH;
import static ru.vetoshkin.input.InputTurbidity.LOW;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class TurbidityService extends InputService<InputTurbidity> {

    public TurbidityService() {
        super(InputTurbidity.class);
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


    @Override
    public InputTurbidity getValue(double value) {
        double low = getValue(LOW, value);
        double high = getValue(HIGH, value);

        int compare = Double.compare(low, high);

        if (compare == 0)
            return LOW;

        return compare > 0 ? LOW : HIGH;
    }
}
