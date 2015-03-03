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
            List<MazePoint> visitOptions = maze.getUnvistedEmptyPointsNextTo(maze.getCursorCoords());

            if(visitOptions.size() == 0 && nodes.size() != 0){
                MazePoint lastPoint = nodes.get(nodes.size() - 1).getParent().getMazePoint();

                maze.moveCursorTo(lastPoint);
                nodes.remove(nodes.size() - 1);
                break;
            } else if(nodes.size() != 0){
                MazePoint visiting = visitOptions.get(0);
                MazePointNode parent = nodes.get(nodes.size() - 1);

                maze.getCursorCoords().setVisited(true);
                maze.moveCursorTo(visiting);

                System.out.println(maze.getCursorCoords());

                MazePointNode pointNode = new MazePointNode(visiting, parent);
                nodes.add(pointNode);
            } else {
                break;
            }
        }

        return nodes;
    }
}
