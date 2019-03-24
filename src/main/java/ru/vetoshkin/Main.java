package ru.vetoshkin;
import ru.vetoshkin.input.InputData;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class Main {


    public static void main(String[] args) {
        InputData inputData = InputData.generate();

        FuzzyLogic logic = new FuzzyLogic();
        logic.rule1(inputData);
        logic.rule2(inputData);
        logic.rule3(inputData);
        logic.rule4(inputData);
        logic.rule5(inputData);
        logic.rule6(inputData);
        logic.rule7(inputData);
    }


}
