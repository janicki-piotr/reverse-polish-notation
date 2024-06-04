package pl.janicki.algorithm;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException(String errorMessage) {
        super(errorMessage);
    }
}
