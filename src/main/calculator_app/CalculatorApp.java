package main.calculator_app;

import main.calculator.Calculator;
import main.s_expression.Node;
import main.s_expression.StringParser;
import main.s_expression.Tree;

import java.util.*;

public class CalculatorApp {
    String input;
    Calculator calculator;
    int result;

    final String open_parentheses = "(";
    final String close_parentheses = ")";
    final String delimiter = " ";


    public CalculatorApp(Calculator calculator){
        this.calculator = calculator;
    }

    public CalculatorApp input (String input){
        this.input = input;
        return this;
    }

    public CalculatorApp process (){
        if(!isExpression()){
            result=Integer.parseInt(input);
            return this;
        }

        Map<String, String> wordToSign_map = new HashMap<>(){{
            put("add", "+");
            put("multiply", "*");}
        };

        Map<String, String> parentheses_spacing_map = new HashMap<>(){{
            put(open_parentheses, open_parentheses+delimiter);
            put(close_parentheses, delimiter+close_parentheses);}
        };

        StringParser stringParser = new StringParser(input, wordToSign_map, parentheses_spacing_map, delimiter);

        String[] parsedString = stringParser.TokenizeExpression();

        Set<String> operatorSigns = new HashSet<>();
        operatorSigns.addAll(wordToSign_map.values());

        Tree tree = new Tree();
        tree.constructATree(parsedString, operatorSigns, open_parentheses, close_parentheses);
        result = evaluateExpressionTree(tree.getRoot());
        return this;
    }

    public int output (){
        return result;
    }

    private boolean isExpression(){
        return input.contains(open_parentheses) && input.contains(close_parentheses);
    }

    private int evaluateExpressionTree(Node node){
        int ans = 0;
        if (node.getChildren().isEmpty()){
            return Integer.parseInt(node.getData());
        }
        else if(node.isOperator()){
            ans = node.getData().equals("+")?0:1;
            for (int i = 0; i < node.getChildren().size(); i++) {
                ans = this.calculator.calculate(node.getData(),
                        evaluateExpressionTree(node.getChildren().get(i)),
                        ans);
            }
        }
        return ans;
    }
}
