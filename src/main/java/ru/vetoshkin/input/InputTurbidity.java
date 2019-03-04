package ru.vetoshkin.input;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputTurbidity extends Param {
    public static final Param LOW  = new Param("Низкое", 0);
    public static final Param HIGH = new Param("Высокое", 1);


    public InputTurbidity(Param state, double value) {
        super(state, value);
    }
}
