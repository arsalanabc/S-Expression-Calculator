package s_expression;

import calculator.Calculator;

public class StringParser {
    private String expression;

    public StringParser(String expression){
        this.expression = expression;
    }

    public void passForCalculation(Calculator calculator, String operand, int a, int b){
        System.out.println(calculator.calculate(operand, a, b));
    }
}
