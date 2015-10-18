package app;

import java.util.Scanner;
import java.util.Set;

public interface Input {

    Double inputOperand(Double previousResult, Scanner scanner);

    Character inputSign(Set<Character> operationsSet, Scanner scanner);

    boolean fillAnswerSet(Character character);
}
