package ru.vetoshkin;
import ru.vetoshkin.input.*;
import ru.vetoshkin.input.service.*;
import ru.vetoshkin.output.OutputChlorine;
import ru.vetoshkin.output.OutputSpeed;
import ru.vetoshkin.output.OutputWater;
import ru.vetoshkin.output.service.OutputChlorineService;
import ru.vetoshkin.output.service.OutputSpeedService;
import ru.vetoshkin.output.service.OutputWaterService;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.stream.DoubleStream;

import static ru.vetoshkin.FuzzyService.AND;
import static ru.vetoshkin.FuzzyService.NOT;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class FuzzyLogic {
    private static final NumberFormat formatter = new DecimalFormat("###.###");
    private static final String DELIMITER = "---------------------------------";

    //*******************************************

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
     * IF Turbidity = Высокое AND Water_f = НЕ Высокое THEN
     * Water_f_var = Положительное большое.
     */
    public void rule1(InputData inputData) {
        System.out.println(DELIMITER);
        Param turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.HIGH, inputData.getTurbidity());
        Param water = INPUT_WATER_SERVICE.getVal(InputWater.HIGH, inputData.getWater_f());

        System.out.printf("Прозрачность:    %.03f \n", turbidity.value);
        System.out.printf("Поток воды:      %.03f \n", water.value);
        Param temp = AND(turbidity, NOT(water));

        System.out.printf("Результат:       %.03f \n", temp.value);

        SystemFunctions systemFunctions = OUTPUT_WATER_SERVICE.cutting(OutputWater.SUPER_POSITIVE, temp.value);

        System.out.printf("Правило #1. Центр тяжести: %.03f \n", systemFunctions.gravityCenter(30, 90));
        System.out.println(DELIMITER);
    }


    /**
     * Салат вымыт плохо, но скорость движения ленты большая:
     * IF Turbidity = Высокое AND Water_f = Высокое THEN
     * Speed_var = Отрицательное.
     * */
    public void rule2(InputData inputData) {
        Param turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.HIGH, inputData.getTurbidity());
        Param water = INPUT_WATER_SERVICE.getVal(InputWater.HIGH, inputData.getWater_f());

        System.out.printf("Прозрачность:    %.03f \n", turbidity.value);
        System.out.printf("Поток воды:      %.03f \n", water.value);

        Param temp = AND(turbidity, water);

        System.out.printf("Результат:       %.03f \n", temp.value);

        SystemFunctions systemFunctions = OUTPUT_SPEED_SERVICE.cutting(OutputSpeed.NEGATIVE, temp.value);

        System.out.printf("Правило #2. Центр тяжести: %.03f \n", systemFunctions.gravityCenter(-50, 10));
        System.out.println(DELIMITER);
    }


    /**
     * Большое количество микроорганизмов:
     * IF Micro_ratio = Высокое THEN Cl_f_var = Положительное большое.
     * */
    public void rule3(InputData inputData) {
        Param micro = INPUT_MICRO_SERVICE.getVal(InputMicro.HIGH, inputData.getMicro_ratio());

        System.out.printf("Результат:       %.03f \n", micro.value);

        SystemFunctions systemFunctions = OUTPUT_CHLOR_SERVICE.cutting(OutputChlorine.SUPER_POSITIVE, micro.value);
        System.out.printf("Правило #3. Центр тяжести: %.03f \n", systemFunctions.gravityCenter(30, 90));
        System.out.println(DELIMITER);
    }


    /**
     * Выходные измерения в норме и производительность может быть увеличена:
     * */
    public void rule4(InputData inputData) {
        Param turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.LOW, inputData.getTurbidity());
        Param micro = INPUT_MICRO_SERVICE.getVal(InputMicro.HIGH, inputData.getMicro_ratio());
        Param speed = INPUT_SPEED_SERVICE.getVal(InputSpeed.HIGH, inputData.getSpeed());
        Param chlorine  = INPUT_CHLORINE_SERVICE.getVal(InputChlorine.ACCEPTABLE, inputData.getCl_ratio());
        Param water = INPUT_WATER_SERVICE.getVal(InputWater.HIGH, inputData.getWater_f());


        System.out.printf("Прозрачность:    %.03f \n", turbidity.value);
        System.out.printf("Микроорганизмов: %.03f \n", micro.value);
        System.out.printf("Скорость ленты:  %.03f \n", speed.value);
        System.out.printf("Хлорин:          %.03f \n", chlorine.value);
        System.out.printf("Поток воды:      %.03f \n", water.value);


        Param temp  = AND(turbidity, NOT(micro));
        Param temp1 = AND(NOT(speed), chlorine);
        Param temp2 = NOT(water);

        Param res   = AND(temp, AND(temp1, temp2));

        System.out.printf("Результат:       %.03f \n", res.value);

        double speedFunctions = OUTPUT_SPEED_SERVICE.cutting(OutputSpeed.POSITIVE, res.value).gravityCenter(-10, 50);
        double chlorFunctions = OUTPUT_CHLOR_SERVICE.cutting(OutputChlorine.POSITIVE, res.value).gravityCenter(-10, 50);
        double waterFunctions = OUTPUT_WATER_SERVICE.cutting(OutputWater.POSITIVE, res.value).gravityCenter(-10, 50);

        double min = DoubleStream.of(
                speedFunctions,
                chlorFunctions,
                waterFunctions
        ).min().getAsDouble();

        System.out.printf("Правило #4. Центр тяжести: %.03f \n", min);
        System.out.println(DELIMITER);
    }


    /**
     * Салат имеет запах и привкус хлорина, и при этом очень малое количество микроорганизмов:
     * IF Cl_ratio = Высокое AND Micro_ratio = НЕ Высокое THEN
     * Cl_f_var = Отрицательное.
     * */
    public void rule5(InputData inputData) {
        Param chlorine  = INPUT_CHLORINE_SERVICE.getVal(InputChlorine.HIGH, inputData.getCl_ratio());
        Param micro = INPUT_MICRO_SERVICE.getVal(InputMicro.HIGH, inputData.getMicro_ratio());

        System.out.printf("Микроорганизмов: %.03f \n", micro.value);
        System.out.printf("Хлорин:          %.03f \n", chlorine.value);

        Param temp = AND(chlorine, NOT(micro));

        System.out.printf("Результат:       %.03f \n", temp.value);

        SystemFunctions systemFunctions = OUTPUT_CHLOR_SERVICE.cutting(OutputChlorine.NEGATIVE, temp.value);
        System.out.printf("Правило #5. Центр тяжести: %.03f \n", systemFunctions.gravityCenter(-50, 10));
        System.out.println(DELIMITER);
    }


    /**
     * Выходные измерения в норме и производительность максимальная: экономия воды.
     * IF Speed = Высокое AND Cl_ratio = Приемлемое AND
     * Turbidity = Низкая THEN Water_f_var = Отрицательное.
     * */
    public void rule6(InputData inputData) {
        Param speed     = INPUT_SPEED_SERVICE.getVal(InputSpeed.HIGH, inputData.getSpeed());
        Param chlorine  = INPUT_CHLORINE_SERVICE.getVal(InputChlorine.ACCEPTABLE, inputData.getCl_ratio());
        Param turbidity = INPUT_TURBIDITY_SERVICE.getVal(InputTurbidity.LOW, inputData.getTurbidity());

        System.out.printf("Прозрачность:    %.03f \n", turbidity.value);
        System.out.printf("Скорость ленты:  %.03f \n", speed.value);
        System.out.printf("Хлорин:          %.03f \n", chlorine.value);

        Param temp = AND(speed, chlorine);
        temp = AND(temp, turbidity);

        System.out.printf("Результат:       %.03f \n", temp.value);

        SystemFunctions systemFunctions = OUTPUT_WATER_SERVICE.cutting(OutputWater.NEGATIVE, temp.value);
        System.out.printf("Правило #6. Центр тяжести: %.03f \n", systemFunctions.gravityCenter(-50, 10));
        System.out.println(DELIMITER);
    }


    /**
     * Очень малое количество микроорганизмов
     * IF Micro_ratio = Низкое THEN Cl_f_var = Отрицательное.
     * */
    public void rule7(InputData inputData) {
        Param micro = INPUT_MICRO_SERVICE.getVal(InputMicro.LOW, inputData.getMicro_ratio());

        System.out.printf("Результат:       %.03f \n", micro.value);

        SystemFunctions systemFunctions = OUTPUT_CHLOR_SERVICE.cutting(OutputChlorine.NEGATIVE, micro.value);
        System.out.printf("Правило #7. Центр тяжести: %.03f \n", systemFunctions.gravityCenter(30, 90));
        System.out.println(DELIMITER);
    }
}

