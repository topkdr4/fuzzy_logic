package ru.vetoshkin.input;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputSpeed extends Param {
    public static Param NOT_HIGH = new Param("НЕ высокое", 0);
    public static Param HIGH = new Param("Высокое", 1);


    public InputSpeed(Param state, double value) {
        super(state, value);
    }
}
