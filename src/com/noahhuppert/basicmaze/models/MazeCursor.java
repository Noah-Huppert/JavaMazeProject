package com.noahhuppert.basicmaze.models;

import com.noahhuppert.basicmaze.MazeCoords;

/**
 * Created by block7 on 2/13/15.
 */
public class MazeCursor {
    public static final int DIRECTION_UP = 0;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_LEFT = 3;

    private MazeCoords currentPos;

    public MazeCursor(){
        currentPos = new MazeCoords();
    }

    /* Actions */
    public MazeCoords move(int dir){

    }

    /* Getters */
    public MazeCoords getCurrentPos() {
        return currentPos;
    }

    /* Setters */
    public void setCurrentPos(MazeCoords currentPos) {
        this.currentPos = currentPos;
    }
}
