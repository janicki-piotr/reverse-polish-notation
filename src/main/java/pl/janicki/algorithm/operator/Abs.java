package pl.janicki.algorithm.operator;

import pl.janicki.algorithm.IncorrectInputException;

import java.util.Deque;

public class Abs implements Operator {
    @Override
    public int operation(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            throw new IncorrectInputException("Abs operator requires one operand");
        }
        return Math.abs(stack.pop());
    }

    @Override
    public String getOperator() {
        return "abs";
    }
}
