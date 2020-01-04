package main.calculator_app;

import main.calculator.Calculator;
import main.s_expression.StringParser;

import java.util.*;

public class CalculatorApp {

    Calculator calculator;
    StringParser stringParser;

    private final String PLUS_SIGN = "+";
    private final String MULTIPLY_SIGN = "*";
    private final String OPEN_PARENTHESIS = "(";
    private final String CLOSE_PARENTHESIS = ")";
    private final String DELIMITER = " ";


    public CalculatorApp(Calculator calculator){
        this.calculator = calculator;
    }

    public int process (String input){
        if(!isExpression(input)){
            return Integer.parseInt(input);
        }

        Map<String, String> wordToSignMap = this.createWordToSignMap();

        Map<String, String> parenthesesSpacingMap = this.createParenthesesSpacingMap(OPEN_PARENTHESIS,
                CLOSE_PARENTHESIS, DELIMITER);

        this.stringParser = new StringParser(input, wordToSignMap, parenthesesSpacingMap, DELIMITER);
        String[] parsedString = stringParser.TokenizeExpression();

        Set<String> operatorSigns = this.createOperatorSignsSet(wordToSignMap);

        try {
            Tree tree = new Tree();
            tree.constructATree(parsedString, operatorSigns, OPEN_PARENTHESIS, CLOSE_PARENTHESIS);
            return evaluateExpressionTree(tree.getRoot());
        } catch (EmptyStackException e) {
            System.out.println("Invalid input: Most likely caused by an unknown operation.");
            throw e;
        }
    }

    private int evaluateExpressionTree(Node node){
        int answer = 0;
        if (node.getChildren().isEmpty() && !node.isOperator()){
            return Integer.parseInt(node.getData());
        }
        else {
            for (int i = 1; i < node.getChildren().size(); i++) {
                answer = this.calculator.calculate(node.getData(),
                        evaluateExpressionTree(node.getChildren().get(0)),
                        evaluateExpressionTree(node.getChildren().get(i)));
            }
        }
        return answer;
    }

    private Set<String> createOperatorSignsSet(Map<String, String> wordToSignMap) {
        Set<String> signsSet = new HashSet<>();
        signsSet.addAll(wordToSignMap.values());
        return signsSet;
    }

    private Map<String, String> createWordToSignMap() {
        Map<String, String> map = new HashMap<>();
        map.put("add", PLUS_SIGN);
        map.put("multiply", MULTIPLY_SIGN);

        return map;
    }

    private Map<String, String> createParenthesesSpacingMap(String open_parentheses, String close_parentheses,
                                                            String delimiter){
        Map<String, String> map = new HashMap<>();
        map.put(open_parentheses, open_parentheses+delimiter);
        map.put(close_parentheses, delimiter+close_parentheses);

        return map;
    }

    private boolean isExpression(String input){
        return input.contains(OPEN_PARENTHESIS) && input.contains(CLOSE_PARENTHESIS);
    }
}
