package ru.vetoshkin.input;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputChlorine extends Param {
    public static final Param ACCEPTABLE = new Param("Приемлемое", 0);
    public static final Param HIGH = new Param("Высокое", 1);


    public InputChlorine(Param state, double value) {
        super(state, value);
    }
}
