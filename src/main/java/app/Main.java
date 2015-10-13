package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addOperation(new Plus(), '+');
        calc.addOperation(new Minus(), '-');
        calc.addOperation(new Multiply(), '*');
        calc.addOperation(new Divide(), '/');
        calc.addOperation(new Operations() {
            @Override
            public double operation(double a, double b) {
                return a > b ? a : b;
            }
        }, 'a');        // так можно добавлять операции
        calc.addOperation(new Operations() {
            @Override
            public double operation(double a, double b) {
                return a < b ? a : b;
            }
        }, 'i');        // так можно добавлять операции
        Set<Character> yesNoSet = new HashSet<>();
        yesNoSet.add('y');
        yesNoSet.add('n');
        do {
            System.out.print("Please enter first operand (empty string to use previous result as operand): ");
            Double firstOperand = new InputElement().myInputOperand(calc.getOperationResult(), new Scanner(System.in));
            System.out.println("firstOperand = " + firstOperand);

            System.out.print("Please enter second operand (empty string to use previous result as operand): ");
            Double secondOperand = new InputElement().myInputOperand(calc.getOperationResult(), new Scanner(System.in));
            System.out.println("secondOperand = " + secondOperand);

            System.out.print("Please enter a sign of operation: ");
            Character signOfOperation = new InputElement().myInputSign(calc.getOperationsMap().keySet(), new Scanner(System.in));

            Double result = calc.makeСompilation(firstOperand, secondOperand, signOfOperation);
            System.out.println(firstOperand + " " + signOfOperation + " " + secondOperand + " = " + result);

            System.out.print("Another operation? ");
        } while (new InputElement().myInputSign(yesNoSet, new Scanner(System.in)) == 'y');
    }
}

