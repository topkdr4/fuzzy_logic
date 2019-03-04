package ru.vetoshkin.output;
import ru.vetoshkin.Param;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class OutputSpeed extends Param {
    public static Param NEGATIVE = new Param("Отрицательное", 0);
    public static Param POSITIVE = new Param("Положительное", 0.5);


    public OutputSpeed(Param state, double value) {
        super(state, value);
    }
}
