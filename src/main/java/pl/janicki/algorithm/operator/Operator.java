package pl.janicki.algorithm.operator;

import java.util.Deque;
import java.util.Objects;

public interface Operator {

    int operation(Deque<Integer> stack);

    String getOperator();

    default boolean canHandle(String operatorCharacter) {
        return Objects.equals(operatorCharacter, getOperator());
    }
}
