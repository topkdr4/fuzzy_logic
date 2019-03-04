package ru.vetoshkin;
import ru.vetoshkin.input.*;
import ru.vetoshkin.input.service.*;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class FuzzyLogic {
    private static final ChlorineService chlorineService   = new ChlorineService();
    private static final TurbidityService turbidityService = new TurbidityService();
    private static final MicroService microService = new MicroService();
    private static final WaterService waterService = new WaterService();
    private static final SpeedService speedService = new SpeedService();


    public void rule1(InputData inputData) {
        InputTurbidity turbidityData = turbidityService.getValue(inputData.getTurbidity());
        InputWater waterData         = waterService.getValue(inputData.getWater_f());

        if (turbidityData != InputTurbidity.HIGH)
            return;

        if (waterData != InputWater.NOT_HIGH)
            return;

        double turbidityValue = turbidityService.getValue(InputTurbidity.HIGH, inputData.getTurbidity());
        double waterValue     = waterService.getValue(InputWater.NOT_HIGH, inputData.getWater_f());

        // TODO: ДЕФАЗЗИФИКАЦИЯ
    }


    public void rule2(InputData inputData) {
        InputTurbidity turbidityData = turbidityService.getValue(inputData.getTurbidity());
        InputWater waterData         = waterService.getValue(inputData.getWater_f());

        if (turbidityData != InputTurbidity.HIGH)
            return;

        if (waterData != InputWater.HIGH)
            return;

        double turbidityValue = turbidityService.getValue(InputTurbidity.HIGH, inputData.getTurbidity());
        double waterValue     = waterService.getValue(InputWater.HIGH, inputData.getWater_f());

        // TODO: ДЕФАЗЗИФИКАЦИЯ
    }


    public void rule3(InputData inputData) {
        InputMicro microData = microService.getValue(inputData.getMicro_ratio());

        if (microData != InputMicro.HIGH)
            return;

        // TODO: ДЕФАЗЗИФИКАЦИЯ
    }

}

