package ru.vetoshkin;
/**
 * Ветошкин А.В. РИС-16бзу
 * */
public abstract class FuzzyOutputService extends FuzzyService {
    public abstract void cutting(Param param, double value);

    double defuzzification(double x) {
        throw new UnsupportedOperationException();
    }
}
