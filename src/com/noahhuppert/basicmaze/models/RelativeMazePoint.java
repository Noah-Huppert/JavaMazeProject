package com.noahhuppert.basicmaze.models;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 3/2/2015.
 */
public class RelativeMazePoint extends MazePoint{
    private Direction direction;

    public RelativeMazePoint(MazePoint point, Direction direction){
        super(point.getCoords().y, point.getCoords().y);
        setEmpty(point.getEmpty());
        setVisitedDirs(point.getVisitedDirs());
        this.direction = direction;
    }

    public RelativeMazePoint(MazeCoords coords, Direction direction){
        super(coords);
        this.direction = direction;
    }


    public RelativeMazePoint(int x, int y, Direction direction){
        super(new MazeCoords(x, y));
        this.direction = direction;
    }

    /* Actions */
    @Override
    public String toString(){
        return "[Coords => " + getCoords() + " | Visited => " + getVisitedDirs() + " | Emtpy => " + getEmpty() + " | Direction => " + direction + "]";
    }

    /* Getters */
    public Direction getDirection() {
        return direction;
    }

    /* Setters */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
