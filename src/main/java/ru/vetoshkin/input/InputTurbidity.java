package ru.vetoshkin.input;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputTurbidity extends InputParam {
    public static final InputParam LOW  = new InputParam("Низкое", 0);
    public static final InputParam HIGH = new InputParam("Высокое", 1);


    public InputTurbidity(InputParam state, double value) {
        super(state.count, value, state);
    }
}
