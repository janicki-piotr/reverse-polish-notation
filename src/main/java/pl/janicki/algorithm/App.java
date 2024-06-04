package pl.janicki.algorithm;

public class App {
    public static void main(String[] args) {
        if (args != null && args.length == 1) {
            System.out.println(new ReversePolishNotation().calculate(args[0]));
        }
    }
}
