package pl.janicki.algorithm;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReversePolishNotationTest {
    private final ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

    @DisplayName("Addition success test")
    @Test
    void additionTest() {
        // given
        String input = "10 25 +";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(35, result);
    }

    @DisplayName("Division success test")
    @Test
    void divisionTest() {
        // given
        String input = "30 5 /";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(6, result);
    }

    @DisplayName("Multiplication success test")
    @Test
    void multiplicationTest() {
        // given
        String input = "30 5 *";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(150, result);
    }

    @DisplayName("Subtraction success test")
    @Test
    void subtractionTest() {
        // given
        String input = "5 15 -";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(-10, result);
    }

    @DisplayName("Abs success test")
    @Test
    void absTest() {
        // given
        String input = "-2000 abs";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(2000, result);
    }

    @DisplayName("Max success test")
    @Test
    void maxTest() {
        // given
        String input = "-200 145 0 200 max 15 +";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(215, result);
    }

    @DisplayName("Success test with multiple operators")
    @Test
    void multipleOperatorsTest() {
        // given
        // abs(30 + 10 / 10 * 2 - 200)
        String input = "30 10 10 / 2 * + 200 - abs";
        // when
        int result = reversePolishNotation.calculate(input);
        // then
        assertEquals(168, result);
    }

    @DisplayName("IncorrectInputException on null input")
    @Test
    void nullInputExceptionTest() {
        // given
        String input = null;
        // when
        Throwable exception = assertThrows(IncorrectInputException.class, () -> {
            reversePolishNotation.calculate(input);
        });
        // then
        assertEquals("Input cannot be null", exception.getMessage());
    }

    @DisplayName("IncorrectInputException on incorrect input")
    @Test
    void incorrectInputExceptionTest() {
        // given
        String input = "10 10 10 /";
        // when
        Throwable exception = assertThrows(IncorrectInputException.class, () -> {
            reversePolishNotation.calculate(input);
        });
        // then
        assertEquals("Incorrect input format", exception.getMessage());
    }

    @DisplayName("IncorrectInputException on unsupported operator")
    @Test
    void incorrectOperatorTest() {
        // given
        String input = "10 10 >";
        // when
        Throwable exception = assertThrows(IncorrectInputException.class, () -> {
            reversePolishNotation.calculate(input);
        });
        // then
        assertEquals("Operation > not supported", exception.getMessage());
    }
}
