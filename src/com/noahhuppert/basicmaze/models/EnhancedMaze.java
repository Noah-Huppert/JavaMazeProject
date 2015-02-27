package com.noahhuppert.basicmaze.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah Huppert on 2/26/2015.
 */
public class EnhancedMaze {
    private Maze maze;
    private List<List<MazePoint>> grid;
    private MazePoint cursorCoords;

    public EnhancedMaze(Maze maze){
        this.maze = maze;
        grid = new ArrayList<List<MazePoint>>();

        for(int w = 0; w < maze.getWidth(); w++){
            grid.add(w, new ArrayList<MazePoint>());

            for(int h = 0; h < maze.getHeight(); h++){
                MazePoint point = new MazePoint(new MazeCoords(w, h));
                point.setEmpty(!maze.grid[w][h]);
                grid.get(w).add(h, point);
            }
        }

        cursorCoords = getPoint(maze.getStartCoords().x, maze.getStartCoords().y);
    }

    /* Actions */
    public boolean isValidPoint(MazePoint point){
        return maze.isPassable(point.getCoords());
    }

    public List<MazePoint> getPointsNextTo(MazePoint point){
        List<MazePoint> points = new ArrayList<MazePoint>();

        MazePoint upPoint = Direction.transform(point, Direction.UP);
        MazePoint downPoint = Direction.transform(point, Direction.DOWN);
        MazePoint rightPoint = Direction.transform(point, Direction.RIGHT);
        MazePoint leftPoint = Direction.transform(point, Direction.LEFT);

        if (isValidPoint(upPoint)) {
            points.add(upPoint);
        }

        if (isValidPoint(downPoint)) {
            points.add(downPoint);
        }

        if (isValidPoint(rightPoint)) {
            points.add(rightPoint);
        }

        if (isValidPoint(leftPoint)) {
            points.add(leftPoint);
        }

        return points;
    }

    public List<MazePoint> getEmptyPointsNextTo(MazePoint point){
        List<MazePoint> points = getPointsNextTo(point);

        for(int i = points.size(); i < points.size(); i--){
            MazePoint ip = points.get(i);

            if(!ip.getEmpty()){
                points.remove(i);
            }
        }

        return points;
    }

    /* Getters */
    public List<List<MazePoint>> getGrid() {
        return grid;
    }

    public MazePoint getPoint(int x, int y){
        return getGrid().get(x).get(y);
    }

    public MazePoint getCursorCoords() {
        return cursorCoords;
    }

    /* Setters */
    public void setGrid(List<List<MazePoint>> grid) {
        this.grid = grid;
    }

    public void setCursorCoords(MazePoint cursorCoords) {
        this.cursorCoords = cursorCoords;
    }
}
