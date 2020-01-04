package main.calculator_app;

import java.util.EmptyStackException;
import java.util.Set;
import java.util.Stack;

public class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void constructATree (String[] tokens, Set<String> operatorSigns, String startExp, String endExp) throws EmptyStackException {
        Stack<Node> localRoot = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals(startExp)) {
                continue;
            }
            if(operatorSigns.contains(tokens[i])){
                localRoot.push(new Node(tokens[i], true));

            } else if(tokens[i].equals(endExp))
            {
                Node tempNode = localRoot.pop();
                if(localRoot.empty()){
                    this.root = tempNode;
                } else {
                    Node tail = localRoot.peek();
                    tail.addChild(tempNode); // add the children from last node to tailing node
                }
            } else {
                Node tempNode = localRoot.pop();
                tempNode.addChild(new Node(tokens[i], false)); // add values to children of operator node
                localRoot.push(tempNode);
            }
        }
    }
}
