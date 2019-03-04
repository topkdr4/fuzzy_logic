package ru.vetoshkin.output;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputSpeed extends OutputParam {
    public static OutputParam NEGATIVE = new OutputParam("Отрицательное", 0);
    public static OutputParam POSITIVE = new OutputParam("Положительное", 0.5);


    public OutputSpeed(OutputParam state, double value) {
        super(state, value);
    }
}
