package com.noahhuppert.basicmaze.solvers;

import com.noahhuppert.basicmaze.Maze;
import com.noahhuppert.basicmaze.MazeCoords;
import com.noahhuppert.basicmaze.Node;

import java.util.List;

/**
 * Created by block7 on 2/13/15.
 */
public abstract class MazeSolver {
    private Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    /* Actions */
    public abstract List<Node> solve();

    /* Getters */
    public Maze getMaze() {
        return maze;
    }

    /* Setters */
    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
