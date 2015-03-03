package com.noahhuppert.basicmaze.models;

/**
 * Created by Noah Huppert on 3/2/2015.
 */
public class MazePointNode {
    private MazePoint mazePoint;
    private MazePointNode parent;

    public MazePointNode(MazePoint mazePoint, MazePointNode parent) {
        this.mazePoint = mazePoint;
        this.parent = parent;
    }

    /* Actions */
    @Override
    public String toString(){
        return "[Point => " + getMazePoint() + " | Parent => " + (getParent() != null ? getParent().getMazePoint() : null) + "]";
    }

    /* Getters */
    public MazePoint getMazePoint() {
        return mazePoint;
    }

    public MazePointNode getParent() {
        return parent;
    }

    /* Setters */
    public void setMazePoint(MazePoint mazePoint) {
        this.mazePoint = mazePoint;
    }

    public void setParent(MazePointNode parent) {
        this.parent = parent;
    }
}
