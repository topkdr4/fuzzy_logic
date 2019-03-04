package ru.vetoshkin.output;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputChlorine extends Param {
    public static final Param NEGATIVE = new Param("Отрицательное", 0);
    public static final Param POSITIVE = new Param("Положительное", 0.5);
    public static final Param SUPER_POSITIVE = new Param("Положительное большое", 1);

    public OutputChlorine(Param state, double value) {
        super(state, value);
    }
}
