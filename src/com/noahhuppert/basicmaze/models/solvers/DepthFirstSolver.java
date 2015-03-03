package com.noahhuppert.basicmaze.models.solvers;

import com.noahhuppert.basicmaze.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah Huppert on 3/2/2015.
 */
public class DepthFirstSolver {
    private EnhancedMaze maze;

    public DepthFirstSolver(EnhancedMaze maze) {
        this.maze = maze;
    }

    public List<MazePointNode> solve(MazePoint target){
        List<MazePointNode> nodes = new ArrayList<MazePointNode>();
        nodes.add(new MazePointNode(maze.getCursorCoords(), null));

        while(true) {
            List<RelativeMazePoint> moveOptions = maze.getUnvistedEmptyPointsNextTo(maze.getCursorCoords());

            if (moveOptions.size() != 0) {
                RelativeMazePoint movingTo = moveOptions.get(0);

                System.out.println("Cursor => " + maze.getCursorCoords() + " Moving To => " + movingTo);

                maze.getCursorCoords().getVisitedDirs().add(movingTo.getDirection());

                maze.setCursorCoords(maze.getPoint(movingTo.getCoords()));
            } else {
                break;
            }
        }

        return nodes;
    }
}
