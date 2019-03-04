package ru.vetoshkin.output;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputWater extends OutputParam {
    public static OutputParam NEGATIVE = new OutputParam("Отрицательное", 0);
    public static OutputParam POSITIVE = new OutputParam("Положительное", 0.5);
    public static OutputParam SUPER_POSITIVE = new OutputParam("Положительное большое", 1);


    public OutputWater(OutputParam state, double value) {
        super(state, value);
    }
}
