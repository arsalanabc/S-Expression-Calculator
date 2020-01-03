package main.calculator_app;

import java.util.EmptyStackException;
import java.util.Set;
import java.util.Stack;

public class Tree {
    Node root;

    public Node getRoot() {
        return root;
    }

    public void constructATree (String[] parsedString, Set<String> operatorSigns, String startExp, String endExp) throws EmptyStackException {
        Stack<Node> localRoot = new Stack<>();
        for (int i = 0; i < parsedString.length; i++) {
            if(parsedString[i].equals(startExp)) { // ignore (
                continue;
            }
            if(operatorSigns.contains(parsedString[i])){ // operator for expression
                localRoot.push(new Node(parsedString[i], true));

            } else if(parsedString[i].equals(endExp)) // end of an expression
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
                tempNode.addChild(new Node(parsedString[i], false)); // add values to children of operator node
                localRoot.push(tempNode);
            }
        }
    }
}
