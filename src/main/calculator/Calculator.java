package main.calculator;

import main.calculator.operations.Addition;
import main.calculator.operations.Multiplication;
import main.calculator.operations.Operation;

import java.util.HashMap;

public class Calculator {
    private HashMap<String, Operation> operationsMap = new HashMap<String, Operation>();
    public Calculator(){
        operationsMap.put("+", new Addition());
        operationsMap.put("*", new Multiplication());
    }

    public void addOrUpdateOperation(String operand, Operation operation){
        if(operationsMap.containsKey(operand)){
            operationsMap.replace(operand, operation);
        } else {
            operationsMap.put(operand, operation);
        }
    }

    public int calculate (String operand, int a, int b) throws NullPointerException {
            Operation operation = operationsMap.get(operand);
            return operation.calc(a, b);
    }
}
