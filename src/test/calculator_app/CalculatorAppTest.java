package test.calculator_app;

import main.calculator.Calculator;
import main.calculator_app.CalculatorApp;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAppTest {
    Calculator calculator = new Calculator();
    CalculatorApp calculatorApp = new CalculatorApp(calculator);

    @Test
    public void shouldReturnSameInteger (){
        int result = calculatorApp.process("123");
        int result1 = calculatorApp.process("0");
        int result2 = calculatorApp.process("1000001");

        assertEquals(result, 123);
        assertEquals(result1, 0);
        assertEquals(result2, 1000001);
    }

    @Test
    public void shouldAddTwoInteger (){
        int result = calculatorApp.process("(add 1 2)");
        int result2 = calculatorApp.process("(add 1 -2)");

        assertEquals(result, 3);
        assertEquals(result2, -1);
    }

    @Test
    public void shouldMultiplyTwoInteger (){
        int result = calculatorApp.process("(multiply 3 2)");
        int result2 = calculatorApp.process("(multiply -3 2)");

        assertEquals(result, 6);
        assertEquals(result2, -6);
    }

    @Test
    public void shouldEvaluateNestedExpressions (){
        int result = calculatorApp.process("(multiply (add 1 2) (add 1 (multiply 3 2)))");
        assertEquals(result, 21);
    }

    @Test
    public void shouldHandleZeros (){
        int result = calculatorApp.process("(multiply 0 2)");
        int result1 = calculatorApp.process("(add -3 0)");
        int result2 = calculatorApp.process("(multiply (add 0 0) (add 0 (multiply 0 0)))");

        assertEquals(result, 0);
        assertEquals(result1, -3);
        assertEquals(result2, 0);
    }

    @Test
    public void shouldThrowException(){
        try {
            int result = calculatorApp.process("(new 0 2)");
        }
        catch (EmptyStackException e){
            assertTrue(e instanceof EmptyStackException);
            assertTrue(true);
        }
    }
}