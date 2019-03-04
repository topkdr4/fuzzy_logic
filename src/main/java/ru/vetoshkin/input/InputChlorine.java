package ru.vetoshkin.input;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputChlorine extends InputParam {
    public static final InputParam ACCEPTABLE = new InputParam("Приемлемое", 0);
    public static final InputParam HIGH = new InputParam("Высокое", 1);


    public InputChlorine(InputParam state, double value) {
        super(state, value);
    }
}
