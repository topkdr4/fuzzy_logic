package ru.vetoshkin;
import lombok.AllArgsConstructor;
import lombok.Getter;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Getter
@AllArgsConstructor
public class Param implements Comparable<Param> {
    protected final String count;
    protected final double value;
    protected final Param state;


    public Param(String count, double value) {
        this.count = count;
        this.value = value;
        this.state = this;
    }


    public Param(Param state, double value) {
        this.count = state.count;
        this.state = state;
        this.value = value;
    }


    @Override
    public int compareTo(Param o) {
        return Double.compare(this.value, o.value);
    }
}
