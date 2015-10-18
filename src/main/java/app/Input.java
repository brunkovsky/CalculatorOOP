package app;

import java.util.Scanner;
import java.util.Set;

public interface Input {

    /**
     * <p>Операция ввода числа Double</p>
     * <p>не выходит из метода до тех пор, пока не введено число Double.</p>
     * @param previousResult число Double (возвращается методом, если введена пустая строка ("\n"))
     * @param scanner переменная типа Scanner
     * @return Double число
     */
    Double inputOperand(Double previousResult, Scanner scanner);

    /**
     * <p>Операция ввода типа Character</p>
     * <p>возвращает символ только в том случае, если он есть в переданном наборе.</p>
     * <p>не выходит из метода до тех пор, пока не введен разрешенный символ.</p>
     * @param operationsSet Set (набор типов Character. (разрешенные символы для ввода))
     * @param scanner переменная типа Scanner
     * @return Character
     */
    Character inputSign(Set<Character> operationsSet, Scanner scanner);

    boolean fillAnswerSet(Character character);
}
