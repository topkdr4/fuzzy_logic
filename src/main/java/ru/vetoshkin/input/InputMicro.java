package ru.vetoshkin.input;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class InputMicro extends Param {
    public static Param LOW = new Param("Низкое", 0);
    public static Param ACCEPTABLE = new Param("Приемлемое", 0.5);
    public static Param HIGH = new Param("Высокое", 1);


    public InputMicro(Param state, double value) {
        super(state, value);
    }
}

