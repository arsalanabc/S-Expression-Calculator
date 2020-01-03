package test.calculator_app;

import main.calculator.Calculator;
import main.calculator_app.CalculatorApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAppTest {
    Calculator calculator = new Calculator();
    CalculatorApp calculatorApp = new CalculatorApp(calculator);

    @Test
    public void shouldReturnSameInteger (){
        int result = calculatorApp.input("123").process().output();
        int result1 = calculatorApp.input("0").process().output();
        int result2 = calculatorApp.input("1000001").process().output();

        assertEquals(result, 123);
        assertEquals(result1, 0);
        assertEquals(result2, 1000001);
    }

    @Test
    public void shouldAddTwoInteger (){
        int result = calculatorApp.input("(add 1 2)").process().output();
        int result2 = calculatorApp.input("(add 1 -2)").process().output();

        assertEquals(result, 3);
        assertEquals(result2, -1);
    }

    @Test
    public void shouldMultiplyTwoInteger (){
        int result = calculatorApp.input("(multiply 3 2)").process().output();
        int result2 = calculatorApp.input("(multiply -3 2)").process().output();

        assertEquals(result, 6);
        assertEquals(result, -6);
    }

    @Test
    public void shouldEvaluateNestedExpressions (){
        int result = calculatorApp.input("(multiply (add 1 2) (add 1 (multiply 3 2)))").process().output();
        assertEquals(result, 21);
    }

    @Test
    public void shouldHandleZeros (){
        int result = calculatorApp.input("(multiply 0 2)").process().output();
        int result1 = calculatorApp.input("(add -3 0)").process().output();
        int result2 = calculatorApp.input("(multiply (add 0 0) (add 0 (multiply 0 0)))").process().output();


        assertEquals(result, 0);
        assertEquals(result1, -3);
        assertEquals(result2, 0);
    }
}