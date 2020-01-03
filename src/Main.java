import main.calculator.Calculator;
import main.calculator_app.CalculatorApp;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorApp calculatorApp = new CalculatorApp(calculator);
        int result = calculatorApp.input(args[0]).process().output();
        System.out.println(result);
    }
}
