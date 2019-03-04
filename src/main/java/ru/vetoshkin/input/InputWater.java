package ru.vetoshkin.input;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputWater extends InputParam {
    public static final InputParam NOT_HIGH = new InputParam("НЕ высокое", 0);
    public static final InputParam HIGH = new InputParam("Высокое", 1);


    public InputWater(InputParam state, double value) {
        super(state, value);
    }
}
