package com.noahhuppert.basicmaze.models;

/**
 * Created by Noah Huppert on 2/26/2015.
 */
public enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static MazePoint transform(MazePoint mazePoint, Direction dir){
        MazePoint point = new MazePoint(mazePoint.getCoords().x, mazePoint.getCoords().y);

        if(dir == UP){
            point.getCoords().y -= 1;
        } else if(dir == DOWN){
            point.getCoords().y += 1;
        } else if(dir == RIGHT){
            point.getCoords().x += 1;
        } else if(dir == LEFT){
            point.getCoords().x -= 1;
        }

        return point;
    }
}