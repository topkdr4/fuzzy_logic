package ru.vetoshkin;
import ru.vetoshkin.input.InputData;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Main {


    public static void main(String[] args) {
        InputData inputData = InputData.build();

        FuzzyLogic logic = new FuzzyLogic();

        System.out.println(Double.compare(1, 2));
        System.out.println(Double.compare(1, 1));
        System.out.println(Double.compare(2, 1));
    }


}
