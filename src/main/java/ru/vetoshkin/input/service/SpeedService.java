package ru.vetoshkin.input.service;
import ru.vetoshkin.input.InputSpeed;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class SpeedService extends InputService<InputSpeed> {

    public SpeedService() {
        super(InputSpeed.class);
    }


    @Override
    protected void init() {
        SystemFunctions notHighSystem = new SystemFunctions();
        notHighSystem.addFunction(value -> value <= 800, getFunction(new Point(0, 1),   new Point(800, 1)));
        notHighSystem.addFunction(value -> value > 800,  getFunction(new Point(800, 1), new Point(1000, 0)));

        systemFunction.put(InputSpeed.NOT_HIGH, notHighSystem);


        SystemFunctions highSystem = new SystemFunctions();
        highSystem.addFunction(value -> value < 1000,  getFunction(new Point(800, 0),  new Point(1000, 1)));
        highSystem.addFunction(value -> value >= 1000, getFunction(new Point(1000, 1), new Point(1100, 1)));

        systemFunction.put(InputSpeed.HIGH, highSystem);
    }
}
