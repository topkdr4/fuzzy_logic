package ru.vetoshkin.output;
import lombok.AllArgsConstructor;
import lombok.Getter;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public class OutputParam {
    protected final String count;
    @Getter
    protected final double value;
    @Getter
    protected final OutputParam state;


    protected OutputParam(String count, double value) {
        this.count = count;
        this.value = value;
        this.state = this;
    }


    public OutputParam(OutputParam state, double value) {
        this.count = state.count;
        this.state = state;
        this.value = value;
    }
}
