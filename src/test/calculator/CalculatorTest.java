package test.calculator;

import main.calculator.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void shouldAdd (){
        int result = calculator.calculate("+", 1,2);
        assertTrue(result ==  3);
    }

    @Test
    public void shouldMultiply (){
        int result = calculator.calculate("*", -1,20);
        assertTrue(result ==  -20);
    }


//    TODO add a unit test to check if Calculator calls the method on Operations
}