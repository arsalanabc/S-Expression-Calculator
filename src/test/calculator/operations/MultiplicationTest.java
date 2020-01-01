package test.calculator.operations;

import main.calculator.operations.Addition;
import main.calculator.operations.Multiplication;
import main.calculator.operations.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    Operation multiplication = new Multiplication();


    @Test
    void shouldMultiplyTwoIntegers() {
        int result = multiplication.calc(123, 321);

        assertTrue(result==39483);
    }

    @Test
    void shouldMultiplyWithZero() {
        int result = multiplication.calc(100, 0);

        assertTrue(result==0);
    }

    @Test
    void shouldMultiplyNegativeIntegers() {
        int result = multiplication.calc(-1, -1);

        assertTrue(result==1);
    }

    @Test
    void shouldMultiplyNegativeAndPositiveIntegers() {
        int result = multiplication.calc(1, -1);
        assertTrue(result == -1);
    }

}