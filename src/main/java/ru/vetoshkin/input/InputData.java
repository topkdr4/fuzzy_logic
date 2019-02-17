package ru.vetoshkin.input;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;





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


    public static InputData build() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кол-во микроорганизмов: ");
        double micro_ratio = scanner.nextDouble();

        System.out.print("Остаточная концентрация хлорина: ");
        double cl_ratio = scanner.nextDouble();

        System.out.print("Прозрачность воды: ");
        double turbidity = scanner.nextDouble();

        System.out.print("Скорость ленты конвейера: ");
        double speed = scanner.nextDouble();

        System.out.print("Поток воды: ");
        double water_f = scanner.nextDouble();

        return new InputData(micro_ratio, cl_ratio, turbidity, speed, water_f);
    }


    public static InputData generate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        double micro_ratio = random.nextDouble(0, 1000);
        System.out.printf("Кол-во микроорганизмов: %f \n", micro_ratio);

        double cl_ratio = random.nextDouble(0, 1000);
        System.out.printf("Остаточная концентрация хлорина: %f \n", cl_ratio);

        double turbidity = random.nextDouble(0, 1000);
        System.out.printf("Прозрачность воды: %f \n", turbidity);

        double speed = random.nextDouble(0, 1000);
        System.out.printf("Скорость ленты конвейера: %f \n", speed);

        double water_f = random.nextDouble(0, 1000);
        System.out.printf("Поток воды: %f \n", water_f);

        return new InputData(micro_ratio, cl_ratio, turbidity, speed, water_f);
    }

}
