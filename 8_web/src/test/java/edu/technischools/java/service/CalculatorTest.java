package edu.technischools.java.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void compute_Addition() {
        Calculator calculator = Calculator.getInstance();
        Double operandA = 5.0;
        Double operandB = 3.0;
        String operation = "ADD";

        Double result = calculator.compute(operandA, operandB, operation);

    }

    @Test
    public void compute_DivisionByZero() {
        Calculator calculator = Calculator.getInstance();
        Double operandA = 10.0;
        Double operandB = 0.0;
        String operation = "DIV";

        assertThrows(ComputationException.class, () -> {
            calculator.compute(operandA, operandB, operation);
        });
    }

    @Test
    public void compute_InvalidOperation() {
        Calculator calculator = Calculator.getInstance();
        Double operandA = 5.0;
        Double operandB = 3.0;
        String operation = "INVALID";

        assertThrows(ComputationException.class, () -> {
            calculator.compute(operandA, operandB, operation);
        });
    }
}