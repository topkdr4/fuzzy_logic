package ru.vetoshkin.input;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Getter
@AllArgsConstructor
public class InputData {
    /**
     * Количество микроорганизмов
     */
    private final double micro_ratio;
    /**
     * Остаточная концентрация хлорина
     */
    private final double cl_ratio;
    /**
     * Прозрачность воды
     */
    private final double turbidity;
    /**
     * Скорость ленты конвейера
     */
    private final double speed;
    /**
     * Поток воды
     */
    private final double water_f;


    private static InputData build() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кол-во микроорганизмов:");
        double micro_ratio = scanner.nextDouble();

        System.out.println("Остаточная концентрация хлорина:");
        double cl_ratio = scanner.nextDouble();

        System.out.println("Прозрачность воды:");
        double turbidity = scanner.nextDouble();

        System.out.println("Скорость ленты конвейера:");
        double speed = scanner.nextDouble();

        System.out.println("Поток воды");
        double water_f = scanner.nextDouble();

        return new InputData(micro_ratio, cl_ratio, turbidity, speed, water_f);
    }

}
