package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();       // инициализация базовых операций происходит в конструкторе
        calculator.addOperation(new Calculator.Divide(), ':');          // так можно добавлять знаки для операций
        calculator.addOperation(new Calculator.Multiply(), 'x');        // так можно добавлять знаки для операций
        calculator.addOperation(new Calculator.Operations() {
            @Override
            public double operation(double a, double b) {
                return Math.pow(a, b);
            }
        }, '^');// так можно добавлять операции

        InputElement input = new InputElement();
        Double result = 0.0, operand1, operand2;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter first operand (empty string to use previous result as operand): ");
            System.out.printf("%s%s\n", "first operand = ", operand1 = input.inputOperand(result, scanner));
            System.out.print("Please enter second operand (empty string to use previous result as operand): ");
            System.out.printf("%s%s\n", "second operand = ", operand2 = input.inputOperand(result, scanner));
            System.out.print("Please enter a sign of operation: ");
            Character signOfOperation = input.inputSign(calculator.getOperationsMap().keySet(), scanner);
            result = calculator.calculate(operand1, operand2, signOfOperation);
            System.out.printf("%s%s%s%s%s%s%s\n", operand1, " ", signOfOperation, " ", operand2, " = ", result);
            System.out.print("Another operation? ");
            if (input.inputSign(input.getAnswerSet(), scanner) == 'n')
                break;
        } while (true);
    }
}
