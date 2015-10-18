package app;

import java.util.*;

public class Calculator {
    public interface Operations {
        double operation(double a, double b);
    }
    public static class Plus implements Operations{
        @Override
        public double operation(double a, double b) {
            return a + b;
        }
    }
    public static class Minus implements Operations{
        @Override
        public double operation(double a, double b) {
            return a - b;
        }
    }
    public static class Multiply implements Operations{
        @Override
        public double operation(double a, double b) {
            return a * b;
        }
    }
    public static class Divide implements Operations{
        @Override
        public double operation(double a, double b) {
            return a / b;
        }
    }
    public static class Maximum implements Operations {
        @Override
        public double operation(double a, double b) {
            return a > b ? a : b;
        }
    }
    public static class Minimum implements Operations {
        @Override
        public double operation(double a, double b) {
            return a < b ? a : b;
        }
    }
    private Map<Character, Operations> operationsMap = new HashMap<>();

    public Calculator() {
        this.addOperation(new Calculator.Plus(), '+');
        this.addOperation(new Calculator.Minus(), '-');
        this.addOperation(new Calculator.Multiply(), '*');
        this.addOperation(new Calculator.Divide(), '/');
        this.addOperation(new Calculator.Maximum(), 'a');
        this.addOperation(new Calculator.Minimum(), 'i');
    }

    public boolean addOperation(Operations operations, Character character) {
        return operationsMap.put(character, operations) == null;
    }

    public Double calculate(Double firstOperand, Double secondOperand, Character signOfOperation) {
        Operations operations = operationsMap.get(signOfOperation);
        return operations.operation(firstOperand, secondOperand);
    }

    public Map<Character, Operations> getOperationsMap() {
        return operationsMap;
    }
}
