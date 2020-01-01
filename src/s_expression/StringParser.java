package s_expression;

public class StringParser {
    private String expression;

    public StringParser(String expression){
        this.expression = expression;
    }

    public void printExpression(){
        System.out.println(this.expression);
    }
}
