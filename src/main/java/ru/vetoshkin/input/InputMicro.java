package ru.vetoshkin.input;
import lombok.AllArgsConstructor;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public enum InputMicro {
    LOW("Низкое"),
    ACCEPTABLE("Приемлемое"),
    HIGH("Высокое")
    ;

    private final String count;
}

