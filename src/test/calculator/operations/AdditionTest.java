package test.calculator.operations;

import main.calculator.operations.Addition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @Test
    void shouldAddTwoIntegers() {
        Addition addition = new Addition();
        int result = addition.calc(1001, 1);

        assertTrue(result==1002);
    }

    @Test
    void shouldAddTwoZeroes() {
        Addition addition = new Addition();
        int result = addition.calc(0, 0);

        assertTrue(result==0);
    }

    @Test
    void shouldAddNegativeIntegers() {
        Addition addition = new Addition();
        int result = addition.calc(-1, -1);

        assertTrue(result==-2);
    }

    @Test
    void shouldAddNegativeAndPositiveIntegers() {
        Addition addition = new Addition();
        int result = addition.calc(1, -1);
        assertTrue(result == 0);
    }
}