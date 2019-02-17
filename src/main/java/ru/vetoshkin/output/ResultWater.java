package ru.vetoshkin.output;
import lombok.AllArgsConstructor;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public enum ResultWater {
    NEGATIVE("Отрицательное"),
    POSITIVE("Положительное"),
    SUPER_POSITIVE("Положительное большое")
    ;

    private final String count;
}
