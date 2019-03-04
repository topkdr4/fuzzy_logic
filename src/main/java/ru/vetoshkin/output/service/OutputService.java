package ru.vetoshkin.output.service;
import ru.vetoshkin.SystemFunctions;
import ru.vetoshkin.output.OutputParam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public abstract class OutputService<T extends OutputParam> {
    protected final Map<T, SystemFunctions> systemFunction = new ConcurrentHashMap<>();


    public OutputService() {
        init();
    }


    protected abstract void init();

}
