
import s_expression.StringParser;

public class Main {

    public static void main(String[] args) {
        StringParser stringParser = new StringParser(args[0].toString());
        stringParser.printExpression();
    }
}
