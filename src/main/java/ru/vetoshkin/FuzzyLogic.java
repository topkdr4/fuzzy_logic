package ru.vetoshkin;
import ru.vetoshkin.input.InputData;
import ru.vetoshkin.input.InputMicro;
import ru.vetoshkin.input.InputTurbidity;
import ru.vetoshkin.input.InputWater;
import ru.vetoshkin.input.service.*;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class FuzzyLogic {
    private static final ChlorineService chlorineService = new ChlorineService();
    private static final TurbidityService turbidityService = new TurbidityService();
    private static final MicroService microService = new MicroService();
    private static final WaterService waterService = new WaterService();
    private static final SpeedService speedService = new SpeedService();


    /**
     * Салат вымыт плохо:
     * IF Turbidity = Высокое AND Water_f = НЕ Высокое THEN
     * Water_f_var = Положительное большое.
     */
    public void rule1(InputData inputData) {
        InputTurbidity turbidityData = turbidityService.getValue(inputData.getTurbidity());
        InputWater waterData = waterService.getValue(inputData.getWater_f());

        double turbidityValue = turbidityService.getValue(InputTurbidity.LOW, inputData.getTurbidity());
        double waterValue = waterService.getValue(InputWater.NOT_HIGH, inputData.getWater_f());

        double temp = AND(turbidityValue, waterValue);
    }


    public void rule2(InputData inputData) {
        InputTurbidity turbidityData = turbidityService.getValue(inputData.getTurbidity());
        InputWater waterData = waterService.getValue(inputData.getWater_f());
    }


    public void rule3(InputData inputData) {
        InputMicro microData = microService.getValue(inputData.getMicro_ratio());
    }


    //*******************************************************************************************************


    /**
     * Оператор пересечния
     */
    private static double AND(double a, double b) {
        return Math.min(a, b);
    }


    /**
     * Операция объединения
     */
    private static double OR(double a, double b) {
        return Math.max(a, b);
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

