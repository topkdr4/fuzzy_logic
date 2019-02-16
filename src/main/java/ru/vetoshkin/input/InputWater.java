package ru.vetoshkin.input;
import lombok.AllArgsConstructor;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public enum InputWater {
    NOT_HIGH("НЕ высокое"),
    HIGH("Высокое")
    ;

    private final String count;
}
