package main.s_expression;

import java.util.Map;

public class StringParser {
    String expression;
    Map<String, String> sign_map;
    Map<String, String> parentheses_map;
    String delimiter ;

    public StringParser(String expression, Map<String, String> sign_map,
                        Map<String, String> parentheses_map, String delimiter){
        this.expression = expression;
        this.sign_map = sign_map;
        this.parentheses_map = parentheses_map;
        this.delimiter = delimiter;
    }

    public String[] TokenizeExpression (){
        replaceWordsWithSigns().addSpacesAroundParentheses();
        return splitBySpaces();
    }

    private void addSpacesAroundParentheses(){
        for (String parentheses: parentheses_map.keySet()){
            this.expression = this.expression.replace(parentheses, parentheses_map.get(parentheses));
        }
    }

    private StringParser replaceWordsWithSigns (){
        for (String keyword: sign_map.keySet()){
            this.expression = this.expression.replace(keyword, sign_map.get(keyword));
        }
        return this;
    }

    private String[] splitBySpaces (){
        return this.expression.split(delimiter);
    }

}
