package main.s_expression;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String data;
    boolean isOperator;
    List<Node> children;

    public Node (String data, boolean isOperator){
        this.data = data;
        this.isOperator = isOperator;
        this.children = new ArrayList<>();
    }

    public String getData(){
        return this.data;
    }

    public void addChild (Node child){
        this.children.add(child);
    }

    public List<Node> getChildren (){
        return this.children;
    }

    public boolean isOperator (){
        return this.isOperator;
    }
}
