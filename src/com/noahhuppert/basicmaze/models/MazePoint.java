package com.noahhuppert.basicmaze.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah Huppert on 2/26/2015.
 */
public class MazePoint {
    private MazeCoords coords;
    private List<Direction> visitedDirs;
    private boolean empty;

    public MazePoint(MazeCoords coords){
        this.coords = coords;
        this.visitedDirs = new ArrayList<Direction>();
        empty = true;
    }


    public MazePoint(int x, int y){
        this.coords = new MazeCoords(x, y);
        this.visitedDirs = new ArrayList<Direction>();
        empty = true;
    }

    /* Actions */
    @Override
    public String toString(){
        return "[Coords => " + getCoords() + " | Visited => " + getVisitedDirs() + " | Emtpy => " + getEmpty() + "]";
    }

    /* Getters */
    public MazeCoords getCoords() {
        return coords;
    }

    public List<Direction> getVisitedDirs() {
        return visitedDirs;
    }

    public boolean getEmpty() {
        return empty;
    }

    /* Setters */
    public void setCoords(MazeCoords coords) {
        this.coords = coords;
    }

    public void setVisitedDirs(List<Direction> visitedDirs) {
        this.visitedDirs = visitedDirs;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
