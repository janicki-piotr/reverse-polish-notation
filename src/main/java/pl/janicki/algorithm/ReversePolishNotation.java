package pl.janicki.algorithm;

import pl.janicki.algorithm.operator.Abs;
import pl.janicki.algorithm.operator.Addition;
import pl.janicki.algorithm.operator.Division;
import pl.janicki.algorithm.operator.Max;
import pl.janicki.algorithm.operator.Multiplication;
import pl.janicki.algorithm.operator.Operator;
import pl.janicki.algorithm.operator.Subtraction;

import java.text.MessageFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ReversePolishNotation {

    private final List<Operator> operators = List.of(
            new Addition(),
            new Multiplication(),
            new Division(),
            new Subtraction(),
            new Abs(),
            new Max()
    );

    public int calculate(String input) {
        if (input == null) {
            throw new IncorrectInputException("Input cannot be null");
        }

        Deque<Integer> stack = new ArrayDeque<>();
        String[] splitInput = input.split(" ");
        for (String symbol : splitInput) {
            int number = isNumber(symbol) ? Integer.parseInt(symbol) : operate(stack, symbol);
            stack.push(number);
        }

        if (stack.size() != 1) {
            throw new IncorrectInputException("Incorrect input format");
        }

        return stack.pop();
    }

    private boolean isNumber(String symbol) {
        try {
            Integer.parseInt(symbol);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    private int operate(Deque<Integer> stack, String operator) {
        return operators.stream()
                .filter(x -> x.canHandle(operator))
                .findFirst().orElseThrow(() -> new IncorrectInputException(MessageFormat.format("Operation {0} not supported", operator)))
                .operation(stack);
    }
}
