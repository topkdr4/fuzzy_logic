package ru.vetoshkin.input;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputWater extends Param {
    public static final Param NOT_HIGH = new Param("НЕ высокое", 0);
    public static final Param HIGH = new Param("Высокое", 1);


    public InputWater(Param state, double value) {
        super(state, value);
    }
}
