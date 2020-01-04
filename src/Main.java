import main.calculator.Calculator;
import main.calculator_app.CalculatorApp;

public class Main {

    public static void main(String[] args) {
        CalculatorApp calculatorApp = new CalculatorApp(new Calculator());
        int result = calculatorApp.process(args[0]);
        System.out.println(result);
    }
}
