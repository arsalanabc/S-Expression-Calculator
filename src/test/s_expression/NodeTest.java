package test.s_expression;

import main.s_expression.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Node node = new Node("+", true);

    @Test
    public void shouldHoldAnOperator (){
        assertEquals(node.getData(), "+");
        assertTrue(node.isOperator());
    }

    @Test
    public void shouldHoldNonOperatorNode (){
        Node child1 = new Node("1", false);
        assertEquals(child1.getData(), "1");
        assertTrue(!child1.isOperator());
    }

    @Test
    public void shouldHoldChildrenNodes (){
        Node child1 = new Node("1", false);
        Node child2 = new Node("2", false);

        assertTrue(node.getChildren().size()==0);

        node.addChild(child1);
        node.addChild(child2);

        assertTrue(node.getChildren().size()==2);

        assertEquals(node.getChildren().get(0).getData(),"1");
        assertEquals(node.getChildren().get(1).getData(),"2");
    }
}