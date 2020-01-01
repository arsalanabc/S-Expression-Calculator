
import calculator.Calculator;
import s_expression.StringParser;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        StringParser stringParser = new StringParser(args[0].toString());
        stringParser.passForCalculation(calculator, "+", 1, 3);
    }
}
