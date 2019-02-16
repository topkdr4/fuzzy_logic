package ru.vetoshkin.input.service;
import ru.vetoshkin.input.InputChlorine;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class ChlorineService extends InputService<InputChlorine> {


    public ChlorineService() {
        super(InputChlorine.class);
    }


    @Override
    protected void init() {
        SystemFunctions acceptableSystem = new SystemFunctions();
        acceptableSystem.addFunction(value -> value <= 400, getFunction(new Point(0,   1), new Point(400, 1)));
        acceptableSystem.addFunction(value -> value > 400,  getFunction(new Point(400, 1), new Point(600, 0)));

        systemFunction.put(InputChlorine.ACCEPTABLE, acceptableSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value <  600, getFunction(new Point(400, 0), new Point(600,  1)));
        highSystem.addFunction(value -> value >= 600, getFunction(new Point(600, 1), new Point(1000, 1)));

        systemFunction.put(InputChlorine.HIGH, highSystem);
    }


}
