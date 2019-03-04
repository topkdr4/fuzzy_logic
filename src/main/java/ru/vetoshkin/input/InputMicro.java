package ru.vetoshkin.input;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputMicro extends InputParam {
    public static InputParam LOW = new InputParam("Низкое", 0);
    public static InputParam ACCEPTABLE = new InputParam("Приемлемое", 0.5);
    public static InputParam HIGH = new InputParam("Высокое", 1);


    public InputMicro(InputParam state, double value) {
        super(state, value);
    }
}

