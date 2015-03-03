package com.noahhuppert.basicmaze.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah Huppert on 2/26/2015.
 */
public class MazePoint {
    private MazeCoords coords;
    private boolean visited;
    private boolean empty;

    public MazePoint(MazeCoords coords){
        this.coords = coords;
        this.visited = false;
        empty = true;
    }


    public MazePoint(int x, int y){
        this.coords = new MazeCoords(x, y);
        this.visited = false;
        empty = true;
    }

    /* Actions */
    @Override
    public String toString(){
        return "[Coords => " + getCoords() + " | Visited => " + getVisited() + " | Emtpy => " + getEmpty() + "]";
    }

    /* Getters */
    public MazeCoords getCoords() {
        return coords;
    }

    public boolean getVisited(){
        return visited;
    }

    public boolean getEmpty() {
        return empty;
    }

    /* Setters */
    public void setCoords(MazeCoords coords) {
        this.coords = coords;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
