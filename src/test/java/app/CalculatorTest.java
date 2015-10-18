package app;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddOperation() {
        Calculator.Operations operationPlus = new Calculator.Plus();
        Calculator.Operations operationMinus = new Calculator.Minus();
        Calculator.Operations operationMultiply = new Calculator.Multiply();
        Calculator.Operations operationDivide = new Calculator.Divide();
        Calculator.Operations operationMinimum = new Calculator.Minimum();
        Calculator.Operations operationMaximum = new Calculator.Maximum();
        Calculator.Operations operationMaximum2 = new Calculator.Maximum();
        Calculator testCalculator = new Calculator();

        assertEquals(true, testCalculator.addOperation(operationPlus, '+'));
        assertEquals(false, testCalculator.addOperation(operationPlus, '+'));
        assertEquals(true, testCalculator.addOperation(operationMinus, '-'));
        assertEquals(true, testCalculator.addOperation(operationMultiply, '*'));
        assertEquals(false, testCalculator.addOperation(operationMultiply, '*'));
        assertEquals(true, testCalculator.addOperation(operationDivide, '/'));
        assertEquals(true, testCalculator.addOperation(operationMinimum, 'i'));
        assertEquals(true, testCalculator.addOperation(operationMaximum, 'a'));
        assertEquals(false, testCalculator.addOperation(operationMaximum, 'a'));
        assertEquals(false, testCalculator.addOperation(operationMaximum2, 'a'));
        assertEquals(true, testCalculator.addOperation(operationMaximum2, 'u'));
    }

    @Test
    public void testCalculate() {
        Calculator testCalculator = new Calculator();
        testCalculator.addOperation(new Calculator.Plus(), '+');
        testCalculator.addOperation(new Calculator.Minus(), '-');
        testCalculator.addOperation(new Calculator.Multiply(), '*');
        testCalculator.addOperation(new Calculator.Divide(), '/');
        testCalculator.addOperation(new Calculator.Minimum(), 'i');
        testCalculator.addOperation(new Calculator.Maximum(), 'a');

        assertEquals(39.0, testCalculator.calculate(32.5, 6.5, '+'));
        assertEquals(0.0, testCalculator.calculate(2.5, -2.5, '+'));
        assertEquals(26.0, testCalculator.calculate(32.5, 6.5, '-'));
        assertEquals(5.0, testCalculator.calculate(2.5, -2.5, '-'));
        assertEquals(211.25, testCalculator.calculate(32.5, 6.5, '*'));
        assertEquals(-6.25, testCalculator.calculate(2.5, -2.5, '*'));
        assertEquals(5.0, testCalculator.calculate(32.5, 6.5, '/'));
        assertEquals(-1.0, testCalculator.calculate(2.5, -2.5, '/'));
        assertEquals(32.5, testCalculator.calculate(32.5, 6.5, 'a'));
        assertEquals(2.5, testCalculator.calculate(2.5, -2.5, 'a'));
        assertEquals(6.5, testCalculator.calculate(32.5, 6.5, 'i'));
        assertEquals(-2.5, testCalculator.calculate(2.5, -2.5, 'i'));
    }
}
