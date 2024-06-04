package pl.janicki.algorithm.operator;

import pl.janicki.algorithm.IncorrectInputException;

import java.util.Deque;

public class Max implements Operator {
    @Override
    public int operation(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            throw new IncorrectInputException("Max requires one operand");
        }

        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public String getOperator() {
        return "max";
    }
}
