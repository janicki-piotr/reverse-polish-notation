package pl.janicki.algorithm.operator;

import pl.janicki.algorithm.IncorrectInputException;

import java.util.Deque;

public class Multiplication implements Operator {
    @Override
    public int operation(Deque<Integer> stack) {
        if (stack.size() < 2) {
            throw new IncorrectInputException("Multiplication requires two operands");
        }
        int a = stack.pop();
        int b = stack.pop();
        return b * a;
    }

    @Override
    public String getOperator() {
        return "*";
    }
}
