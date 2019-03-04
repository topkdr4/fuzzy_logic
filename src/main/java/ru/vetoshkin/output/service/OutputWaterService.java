package ru.vetoshkin.output.service;
import ru.vetoshkin.FuzzyService;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.output.OutputWater;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputWaterService extends FuzzyService {

    public OutputWaterService() {
        super();
    }


    @Override
    protected void init() {
        SystemFunctions acceptableSystem = new SystemFunctions();
        acceptableSystem.addFunction(value -> value <= 400, getFunction(new Point(0, 1), new Point(400, 1)));
        acceptableSystem.addFunction(value -> value > 400, getFunction(new Point(400, 1), new Point(600, 0)));

        putFunction(OutputWater.NEGATIVE, acceptableSystem);
    }
}
