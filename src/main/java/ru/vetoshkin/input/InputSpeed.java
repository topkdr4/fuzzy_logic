package ru.vetoshkin.input;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputSpeed extends InputParam {
    public static InputParam NOT_HIGH = new InputParam("НЕ высокое", 0);
    public static InputParam HIGH = new InputParam("Высокое", 1);


    public InputSpeed(InputParam state, double value) {
        super(state, value);
    }
}
