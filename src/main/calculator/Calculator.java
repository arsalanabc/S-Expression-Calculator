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

    public void addOrUpdateOperation(String operator, Operation operation){
        if(operationsMap.containsKey(operator)){
            operationsMap.replace(operator, operation);
        } else {
            operationsMap.put(operator, operation);
        }
    }

    public int calculate (String operator, int a, int b) throws NullPointerException {
            Operation operation = operationsMap.get(operator);
            return operation.calc(a, b);
    }
}
