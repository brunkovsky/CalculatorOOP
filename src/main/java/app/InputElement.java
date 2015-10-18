package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputElement implements Input {
    private Set<Character> answerSet = new HashSet<>();

    public InputElement() {
        this.fillAnswerSet('y');
        this.fillAnswerSet('n');
    }

    @Override
    public Double inputOperand(Double previousResult, Scanner scanner) {
        Double operandResult = previousResult;
        String string;
        do {
            string = scanner.nextLine();
            if (string.equals("")) {
                break;
            }
            try {
                operandResult = Double.parseDouble(string);
                break;
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
            }
        } while (true);
        return operandResult;
    }

    @Override
    public Character inputSign(Set<Character> operationsSet, Scanner scanner) {
        Character signResult;
        String string;
        for (Character character : operationsSet)
            System.out.print(character + " ");
        System.out.print(": ");
        do {
            string = scanner.next();
            if (string.length() == 1) {
                signResult = string.charAt(0);
                if (operationsSet.contains(signResult))
                    break;
            }
            System.out.print("Please enter a valid input: ");
        }
        while (true);
        return signResult;
    }

    @Override
    public boolean fillAnswerSet(Character character) {
        return answerSet.add(character);
    }

    public Set<Character> getAnswerSet() {
        return answerSet;
    }
}
