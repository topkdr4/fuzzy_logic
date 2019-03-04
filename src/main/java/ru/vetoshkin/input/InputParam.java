package ru.vetoshkin.input;
import lombok.AllArgsConstructor;
import lombok.Getter;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@AllArgsConstructor
public class InputParam {
    protected final String count;
    @Getter
    protected final double value;
    @Getter
    protected final InputParam state;


    protected InputParam(String count, double value) {
        this.count = count;
        this.value = value;
        this.state = this;
    }


    public InputParam(InputParam state, double value) {
        this.count = state.count;
        this.state = state;
        this.value = value;
    }

}
