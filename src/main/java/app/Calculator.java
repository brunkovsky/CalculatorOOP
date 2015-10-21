package app;

import java.util.*;

public class Calculator {
    public interface Operations {
        /**
         * <p>Операция арифметического действия</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return значение double
         */
        double operation(double a, double b);
    }
    public static class Plus implements Operations{
        @Override
        /**
         * <p>Операция сложения</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return Сумма (a + b)
         */
        public double operation(double a, double b) {
            return a + b;
        }
    }
    public static class Minus implements Operations{
        @Override
        /**
         * <p>Операция вычитания</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return Разность (a - b)
         */
        public double operation(double a, double b) {
            return a - b;
        }
    }
    public static class Multiply implements Operations{
        @Override
        /**
         * <p>Операция умножения</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return Произведение (a * b)
         */
        public double operation(double a, double b) {
            return a * b;
        }
    }
    public static class Divide implements Operations{
        @Override
        /**
         * <p>Операция деления</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return Частное (a / b)
         */
        public double operation(double a, double b) {
            return a / b;
        }
    }
    public static class Maximum implements Operations {
        @Override
        /**
         * <p>Операция нахождения максимального значения</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return Максимальное значение из a и b
         */
        public double operation(double a, double b) {
            return a > b ? a : b;
        }
    }
    public static class Minimum implements Operations {
        @Override
        /**
         * <p>Операция нахождения минимального значения</p>
         *
         * @param a Операнд a
         * @param b Операнд b
         * @return Минимальное значение из a и b
         */
        public double operation(double a, double b) {
            return a < b ? a : b;
        }
    }
    private Map<Character, Operations> operationsMap = new HashMap<>();

    /**
     * инициализация базовых операций происходит в конструкторе
     */
    public Calculator() {
        this.addOperation(new Calculator.Plus(), '+');
        this.addOperation(new Calculator.Minus(), '-');
        this.addOperation(new Calculator.Multiply(), '*');
        this.addOperation(new Calculator.Divide(), '/');
        this.addOperation(new Calculator.Maximum(), 'a');
        this.addOperation(new Calculator.Minimum(), 'i');
    }

    public void runCalculator() {
        InputElement input = new InputElement();
        Double result = 0.0, operand1, operand2;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter first operand (empty string to use previous result as operand): ");
            System.out.printf("%s%s\n", "first operand = ", operand1 = input.inputOperand(result, scanner));
            System.out.print("Please enter second operand (empty string to use previous result as operand): ");
            System.out.printf("%s%s\n", "second operand = ", operand2 = input.inputOperand(result, scanner));
            System.out.print("Please enter a sign of operation: ");
            Character signOfOperation = input.inputSign(getOperationsMap().keySet(), scanner);
            result = calculate(operand1, operand2, signOfOperation);
            System.out.printf("%s%s%s%s%s%s%s\n", operand1, " ", signOfOperation, " ", operand2, " = ", result);
            System.out.print("Another operation? ");
            if (input.inputSign(input.getAnswerSet(), scanner) == 'n')
                break;
        } while (true);
    }

    /**
     * этот метод добавляет в мапу operationsMap ключ:знак операции и значение:сама операция
     * @param operations операция калькулятора
     * @param character знак
     * @return true, если при добавлении не произошло конфликта.
     * (т.е. если добавляемый ключ не содержался ранее среди ключей в мапе)
     */
    public boolean addOperation(Operations operations, Character character) {
        return operationsMap.put(character, operations) == null;
    }

    /**
     * метод вычисления значения
     * signOfOperation может быть только из среди набора разрешенных символов.
     * об этом должен позаботиться предыдущий метод.
     * в противном случае NullPointerException.
     * @param firstOperand первый операнд
     * @param secondOperand второй операнд
     * @param signOfOperation знак операции
     * @return значение алгебраической операции
     */
    public Double calculate(Double firstOperand, Double secondOperand, Character signOfOperation) {
        Operations operations = operationsMap.get(signOfOperation);
        return operations.operation(firstOperand, secondOperand);
    }

    public Map<Character, Operations> getOperationsMap() {
        return operationsMap;
    }
}
