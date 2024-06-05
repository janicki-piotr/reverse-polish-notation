package pl.janicki.algorithm;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReversePolishNotationTest {
    private final ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

    @DisplayName("Calculation Tests")
    @ParameterizedTest(name = "{2}")
    @CsvSource({
            "10 25 +, 35, Addition success test",
            "30 5 /, 6, Division success test",
            "30 5 *, 150, Multiplication success test",
            "5 15 -, -10, Subtraction success test",
            "-2000 abs, 2000, Abs success test",
            "-200 145 0 200 max 15 +, 215, Max success test",
            "30 10 10 / 2 * + 200 - abs, 168, Success test with multiple operators"
    })
    void calculationTest(String input, int expected, String description) {
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(expected, result);
    }

    @DisplayName("IncorrectInputException Tests")
    @ParameterizedTest(name = "{2}")
    @CsvSource({
            ", Input cannot be empty, On null input",
            "'', Input cannot be empty, On empty input",
            "10 10 10 /, Incorrect input format, On incorrect input",
            "10 10 >, Operation > not supported, On unsupported operator",
            "10 +, Addition requires two operands, On not enough operands addition",
            "10 -, Subtraction requires two operands, On not enough operands subtraction",
            "10 *, Multiplication requires two operands, On not enough operands multiplication",
            "10 /, Division requires two operands, On not enough operands division",
            "abs, Abs operator requires one operand, On not enough operands abs",
            "max, Max requires one operand, On not enough operands max",
    })
    void exceptionTest(String input, String expectedMessage, String description) {
        // when
        Throwable exception = assertThrows(IncorrectInputException.class, () -> reversePolishNotation.calculate(input));
        // then
        assertEquals(expectedMessage, exception.getMessage());
    }
}
