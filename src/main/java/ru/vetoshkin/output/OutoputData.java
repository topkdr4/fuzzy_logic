package ru.vetoshkin.output;
import lombok.Getter;
import lombok.Setter;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Getter
@Setter
public class OutoputData {
    /**
     * Изменение потока воды
     */
    private double water_f_var;
    /**
     * Изменение потока хлорина
     */
    private double cl_f_var;
    /**
     * Изменение скорости
     */
    private double speed_var;
}
