package ru.vetoshkin;
import ru.vetoshkin.input.*;
import ru.vetoshkin.input.service.*;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class FuzzyLogic {
    private static final InputService<InputChlorine> INPUT_CHLORINE_SERVICE = new InputChlorineService<>();
    private static final InputService<InputTurbidity> INPUT_TURBIDITY_SERVICE = new InputTurbidityService<>();
    private static final InputService<InputMicro> INPUT_MICRO_SERVICE = new InputMicroService<>();
    private static final InputService<InputWater> INPUT_WATER_SERVICE = new InputWaterService<>();
    private static final InputService<InputSpeed> INPUT_SPEED_SERVICE = new InputSpeedService<>();

    //*******************************************




    /**
     * Салат вымыт плохо:
     * IF Turbidity = Высокое AND Water_f = НЕ Высокое THEN
     * Water_f_var = Положительное большое.
     */
    public void rule1(InputData inputData) {
        InputParam turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.LOW, inputData.getTurbidity());
        InputParam water = INPUT_WATER_SERVICE.getVal(InputWater.NOT_HIGH, inputData.getWater_f());

        InputParam temp = AND(turbidity, water);
    }


    public void rule2(InputData inputData) {

    }


    public void rule3(InputData inputData) {

    }


    //*******************************************************************************************************


    /**
     * Оператор пересечния
     */
    private static double AND(double a, double b) {
        return Math.min(a, b);
    }


    private static InputParam AND(InputParam a, InputParam b) {
        int compare = a.compareTo(b);
        if (compare <= 0)
            return a;

        return b;
    }


    /**
     * Операция объединения
     */
    private static double OR(double a, double b) {
        return Math.max(a, b);
    }


    private static InputParam OR(InputParam a, InputParam b) {
        int compare = a.compareTo(b);
        if (compare < 0)
            return a;

        return b;
    }


    /**
     * Отрицания
     */
    private static double NOT(double a) {
        return 1d - a;
    }


    /**
     * Степень истенности записывается как µ(A)
     */
    private static <T> T u(T t) {
        throw new UnsupportedOperationException();
    }

}

