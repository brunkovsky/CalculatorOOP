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
    /**
     * <p>Операция ввода числа Double</p>
     * <p>не выходит из метода до тех пор, пока не введено число Double.</p>
     * @param previousResult число Double (возвращается методом, если введена пустая строка ("\n"))
     * @param scanner переменная типа Scanner
     * @return Double число
     */
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
    /**
     * <p>Операция ввода типа Character</p>
     * <p>возвращает символ только в том случае, если он есть в переданном наборе.</p>
     * <p>не выходит из метода до тех пор, пока не введен разрешенный символ.</p>
     * @param operationsSet Set (набор типов Character. (разрешенные символы для ввода))
     * @param scanner переменная типа Scanner
     * @return Character
     */
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
    /**
     * <p>Метод поэлементного заполнения набора разрешенных символов</p>
     * @param character переаваемый символ
     * @return true, если операция добавление прошла без конфликтов.
     * (т.е. если вводимый символ не существует в наборе answerSet)
     */
    public boolean fillAnswerSet(Character character) {
        return answerSet.add(character);
    }

    public Set<Character> getAnswerSet() {
        return answerSet;
    }
}
