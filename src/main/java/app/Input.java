package app;

import java.util.Scanner;
import java.util.Set;

public interface Input {

    /**
     * <p>Операция ввода числа Double</p>
     *
     * @param previousResult число Double (возвращается методом, если введена пустая строка ("\n"))
     * @param scanner переменная типаScanner
     * @return Double число
     */
    Double myInputOperand(Double previousResult, Scanner scanner);

    /**
     * <p>Операция ввода типа Character</p>
     * <p>возвращает символ только в том случае, если он есть в переданном наборе.</p>
     * @param operationsSet Set (набор типов Character. (разрешенные символы для ввода))
     * @param scanner переменная типаScanner
     * @return Character
     */
    Character myInputSign(Set<Character> operationsSet, Scanner scanner);
}

