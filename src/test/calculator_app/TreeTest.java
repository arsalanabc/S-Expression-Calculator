package test.calculator_app;

import main.calculator_app.Tree;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class TreeTest {
    Tree tree = new Tree();
    @Test
    public void shouldMakeATree(){
        String[] expression = new String[]{"(","+","2","3",")"};


        Set<String> operatorSigns = new HashSet<>();
        operatorSigns.add("+");
        operatorSigns.add("*");

        tree.constructATree(expression, operatorSigns, "(", ")");

        assertEquals(tree.getRoot().getData(), "+");
        assertTrue(tree.getRoot().isOperator());
        assertEquals(tree.getRoot().getChildren().get(0).getData(), "2");
        assertEquals(tree.getRoot().getChildren().get(1).getData(), "3");

        expression = new String[]{"(","*","2","3",")"};

        tree.constructATree(expression, operatorSigns, "(", ")");
        assertEquals(tree.getRoot().getData(), "*");
        assertTrue(tree.getRoot().isOperator());
    }

    @Test()
    public void shouldThrowAnException (){
        String[] expression = new String[]{"(","/","2","3",")"};

        Set<String> operatorSigns = new HashSet<>();
        operatorSigns.add("+");
        operatorSigns.add("*");
        try{
            tree.constructATree(expression, operatorSigns, "(", ")");
        } catch (EmptyStackException e){
            assertTrue(true);
        }

    }

}