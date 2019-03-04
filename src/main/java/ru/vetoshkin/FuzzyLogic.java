package ru.vetoshkin;
import ru.vetoshkin.input.*;
import ru.vetoshkin.input.service.*;
import ru.vetoshkin.output.OutputWater;
import ru.vetoshkin.output.service.OutputChlorineService;
import ru.vetoshkin.output.service.OutputSpeedService;
import ru.vetoshkin.output.service.OutputWaterService;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class FuzzyLogic {
    private static final FuzzyService INPUT_CHLORINE_SERVICE = new InputChlorineService();
    private static final FuzzyService INPUT_TURBIDITY_SERVICE = new InputTurbidityService();
    private static final FuzzyService INPUT_MICRO_SERVICE = new InputMicroService();
    private static final FuzzyService INPUT_WATER_SERVICE = new InputWaterService();
    private static final FuzzyService INPUT_SPEED_SERVICE = new InputSpeedService();

    //*******************************************

    private static final FuzzyService OUTPUT_WATER_SERVICE = new OutputWaterService();
    private static final FuzzyService OUTPUT_CHLOR_SERVICE = new OutputChlorineService();
    private static final FuzzyService OUTPUT_SPEED_SERVICE = new OutputSpeedService();


    /**
     * Салат вымыт плохо:
     * IF InputTurbidity = Высокое AND Water_f = НЕ Высокое THEN
     * Water_f_var = Положительное большое.
     */
    public void rule1(InputData inputData) {
        Param turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.LOW, inputData.getTurbidity());
        Param water = INPUT_WATER_SERVICE.getVal(InputWater.NOT_HIGH, inputData.getWater_f());

        Param temp = AND(turbidity, water);
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


    private static Param AND(Param a, Param b) {
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


    private static Param OR(Param a, Param b) {
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

