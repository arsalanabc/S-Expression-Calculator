package test.s_expression;

import main.s_expression.StringParser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {
    @Test
    public void shouldReturnArrayOfTokens(){
        final String open_parentheses = "(";
        final String close_parentheses = ")";
        final String delimiter = " ";

        Map<String, String> wordToSign_map = new HashMap<>(){{
            put("add", "+");
            put("multiply", "*");}
        };
        Map<String, String> parentheses_spacing_map = new HashMap<>(){{
            put(open_parentheses, open_parentheses+delimiter);
            put(close_parentheses, delimiter+close_parentheses);}
        };


        String[] expectedTokens = new String[]{"(","+","1","2",")"};
        StringParser stringParser = new StringParser("(add 1 2)", wordToSign_map, parentheses_spacing_map, delimiter);

        String[] tokens = stringParser.TokenizeExpression();

        assertArrayEquals(expectedTokens,tokens);

        stringParser = new StringParser("(add (multiply 2 8) 3)", wordToSign_map, parentheses_spacing_map, delimiter);

        expectedTokens = new String[]{"(","+","(","*","2","8",")","3",")"};
        tokens = stringParser.TokenizeExpression();

        assertArrayEquals(expectedTokens,tokens);
    }

    @Test
    public void shouldReturnArrayOfTokensWithCustomInput(){
        final String open_parentheses = "<";
        final String close_parentheses = ">";
        final String delimiter = " ";

        Map<String, String> wordToSign_map = new HashMap<>(){{
            put("plus", "++");
            put("times", "**");}
        };
        Map<String, String> parentheses_spacing_map = new HashMap<>(){{
            put(open_parentheses, open_parentheses+delimiter);
            put(close_parentheses, delimiter+close_parentheses);}
        };


        String[] expectedTokens = new String[]{"<","++","1","2",">"};
        StringParser stringParser = new StringParser("<plus 1 2>", wordToSign_map, parentheses_spacing_map, delimiter);

        String[] tokens = stringParser.TokenizeExpression();

        assertArrayEquals(expectedTokens,tokens);

        stringParser = new StringParser("<plus <times 2 8> 3>", wordToSign_map, parentheses_spacing_map, delimiter);

        expectedTokens = new String[]{"<","++","<","**","2","8",">","3",">"};
        tokens = stringParser.TokenizeExpression();

        assertArrayEquals(expectedTokens,tokens);
    }
}