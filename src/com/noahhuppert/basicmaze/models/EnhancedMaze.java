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
    private int isPointPartOfSolution(List<MazePointNode> solution, MazeCoords coords){
        int i = 0;
        for(MazePointNode node : solution){
            if(node.getMazePoint().getCoords().x == coords.x && node.getMazePoint().getCoords().y == coords.y){
                return i;
            }

            i++;
        }

        return -1;
    }


    public void printSolution(List<MazePointNode> nodes){
        for (int i = 0; i < maze.width + 2; i++)
            System.out.print("*");
            System.out.println();
        for (int row = 0; row < maze.height; row++) {
            System.out.print("*");
            for (int col = 0; col < maze.width; col++) {
                MazeCoords coords = new MazeCoords(col, row);

                int isPartOfSol = isPointPartOfSolution(nodes, coords);

                if (isPartOfSol != -1) {
                    System.out.print(isPartOfSol);
                } else if (maze.isStartSquare(coords)) {
                    System.out.print("S");
                }else if (maze.isEndSquare(coords)) {
                    System.out.print("E");
                }else if(maze.isPassable(coords)) {
                    System.out.print(" ");
                } else{
                    System.out.print("*");
                }
            }
            System.out.println("*");
        }
        for (int i = 0; i < maze.width + 2; i++)
            System.out.print("*");
        System.out.println();
    }


    public boolean isValidPoint(MazePoint point){
        return maze.isPassable(point.getCoords());
    }

    public List<MazePoint> getPointsNextTo(MazePoint point){
        List<MazePoint> points = new ArrayList<MazePoint>();

        for(Direction direction : Direction.values()){
            MazePoint transformedMazePoint = Direction.transform(point, direction);

            if(transformedMazePoint.getCoords().x >= 0 && transformedMazePoint.getCoords().x < maze.getWidth() &&
               transformedMazePoint.getCoords().y >= 0 && transformedMazePoint.getCoords().y < maze.getHeight()){

                transformedMazePoint.setEmpty(getPoint(transformedMazePoint.getCoords()).getEmpty());
                transformedMazePoint.setVisited(getPoint(transformedMazePoint.getCoords()).getVisited());
                points.add(transformedMazePoint);
            }
        }

        return points;
    }

    public List<MazePoint> getEmptyPointsNextTo(MazePoint point) {
        List<MazePoint> points = getPointsNextTo(point);

        for(int i = points.size() - 1; i >= 0; i--){
            if(!points.get(i).getEmpty()){
                points.remove(i);
            }
        }

        return points;
    }

    public List<MazePoint> getUnvistedEmptyPointsNextTo(MazePoint point){
        List<MazePoint> points = getEmptyPointsNextTo(point);

        for(int i = points.size() - 1; i >= 0; i--){
            if(points.get(i).getVisited()){
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

    public void moveCursorTo(MazePoint point){
        setCursorCoords(getPoint(point.getCoords().x, point.getCoords().y));
    }
}
