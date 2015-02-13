package com.noahhuppert.basicmaze;

import java.util.List;

/**
 * Created by block7 on 2/13/15.
 */
public class Node {
    private MazeCoords coords;
    private Node parent;
    private List<Node> children;

    public Node(MazeCoords coords, Node parent, List<Node> children) {
        this.coords = coords;
        this.parent = parent;
        this.children = children;
    }

    /* Getters */
    public MazeCoords getCoords() {
        return coords;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    /* Setters */
    public void setCoords(MazeCoords coords) {
        this.coords = coords;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
