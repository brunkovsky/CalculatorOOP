package app;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Double operationResult = 0.0;
    private Map<Character, Operations> operationsMap = new HashMap<>();


    public Double getOperationResult() {
        return operationResult;
    }

    public Map<Character, Operations> getOperationsMap() {
        return operationsMap;
    }

    public void addOperation(Operations operations, Character character) {
        operationsMap.put(character, operations);
    }

    public Double makeСompilation(Double firstOperand, Double secondOperand, Character signOfOperation) {
        Operations operations = operationsMap.get(signOfOperation);
        operationResult = operations.operation(firstOperand, secondOperand);
        return operationResult;
    }
}
