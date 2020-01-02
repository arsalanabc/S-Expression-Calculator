package test.s_expression;

import main.s_expression.Tree;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TreeTest {
    @Test
    public void shouldMakeATree(){
        String[] expression = new String[]{"(","+","2","3",")"};
        Tree tree = new Tree();

        Set<String> operatorSigns = new HashSet<>();
        operatorSigns.add("+");
        operatorSigns.add("*");

        tree.constructATree(expression, operatorSigns);

        assertEquals(tree.getRoot().getData(), "+");
        assertTrue(tree.getRoot().isOperator());
        assertEquals(tree.getRoot().getChildren().get(0).getData(), "2");
        assertEquals(tree.getRoot().getChildren().get(1).getData(), "3");

        expression = new String[]{"(","*","2","3",")"};

        tree.constructATree(expression, operatorSigns);
        assertEquals(tree.getRoot().getData(), "*");
        assertTrue(tree.getRoot().isOperator());
    }

}