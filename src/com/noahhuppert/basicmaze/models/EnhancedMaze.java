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

    public List<RelativeMazePoint> getPointsNextTo(MazePoint point){
        List<RelativeMazePoint> points = new ArrayList<RelativeMazePoint>();

        for(Direction direction : Direction.values()){
            MazePoint transformedMazePoint = Direction.transform(point, direction);
            RelativeMazePoint relativeMazePoint = new RelativeMazePoint(transformedMazePoint.getCoords().x, transformedMazePoint.getCoords().y, direction);

            if(isValidPoint(relativeMazePoint)){
                points.add(relativeMazePoint);
            }
        }

        return points;
    }

    public List<RelativeMazePoint> getEmptyPointsNextTo(MazePoint point){
        List<RelativeMazePoint> points = getPointsNextTo(point);

        for(int i = points.size() - 1; i >= 0; i--){
            if(!points.get(i).getEmpty()){
                points.remove(i);
            }
        }

        return points;
    }

    public List<RelativeMazePoint> getUnvistedEmptyPointsNextTo(MazePoint point){
        List<RelativeMazePoint> points = getEmptyPointsNextTo(point);

        for(int i = points.size() - 1; i >= 0; i--){
            if(point.getVisitedDirs().contains(points.get(i).getDirection())){
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

    public MazePoint getPoint(MazeCoords coords){
        return getPoint(coords.x, coords.y);
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
