package ru.vetoshkin;
import ru.vetoshkin.input.InputData;
import ru.vetoshkin.input.InputTurbidity;
import ru.vetoshkin.input.InputWater;
import ru.vetoshkin.input.service.*;
import ru.vetoshkin.output.OutputWater;
import ru.vetoshkin.output.service.OutputChlorineService;
import ru.vetoshkin.output.service.OutputSpeedService;
import ru.vetoshkin.output.service.OutputWaterService;

import static ru.vetoshkin.FuzzyService.AND;





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

    private static final FuzzyOutputService OUTPUT_WATER_SERVICE = new OutputWaterService();
    private static final FuzzyOutputService OUTPUT_CHLOR_SERVICE = new OutputChlorineService();
    private static final FuzzyOutputService OUTPUT_SPEED_SERVICE = new OutputSpeedService();


    /**
     * Салат вымыт плохо:
     * IF InputTurbidity = Высокое AND Water_f = НЕ Высокое THEN
     * Water_f_var = Положительное большое.
     */
    public void rule1(InputData inputData) {
        Param turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.LOW, inputData.getTurbidity());
        Param water = INPUT_WATER_SERVICE.getVal(InputWater.NOT_HIGH, inputData.getWater_f());

        Param temp = AND(turbidity, water);
        System.out.println(temp.value);
        SystemFunctions systemFunctions = OUTPUT_WATER_SERVICE.cutting(OutputWater.SUPER_POSITIVE, temp.value);

        System.out.println(systemFunctions.gravityCenter(30, 90));
    }


    public void rule2(InputData inputData) {

    }


    public void rule3(InputData inputData) {

    }


}

