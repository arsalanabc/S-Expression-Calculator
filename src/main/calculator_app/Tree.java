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
            if(tokens[i].equals(startExp)) { // ignore (
                continue;
            }
            if(operatorSigns.contains(tokens[i])){ // operator for expression
                localRoot.push(new Node(tokens[i], true));

            } else if(tokens[i].equals(endExp)) // end of an expression
            {
                Node tempNode = localRoot.pop(); // get the last node
                if(localRoot.empty()){
                    this.root = tempNode; // if there is only one expression return it as the root of the tree
                } else {
                    Node tail = localRoot.peek(); //
                    tail.addChild(tempNode); // add the children from last node to trailing node
                }
            } else {
                Node tempNode = localRoot.pop();
                tempNode.addChild(new Node(tokens[i], false)); // add values to children of operator node
                localRoot.push(tempNode);
            }
        }
    }
}
