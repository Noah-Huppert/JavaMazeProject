package com.noahhuppert.basicmaze.solvers;

import com.noahhuppert.basicmaze.Maze;
import com.noahhuppert.basicmaze.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by block7 on 2/13/15.
 */
public class DepthFirstSolver extends MazeSolver{
    private List<Node> graph;

    public DepthFirstSolver(Maze maze) {
        super(maze);
        graph = new ArrayList<Node>();
    }

    @Override
    public List<Node> solve(){

        return null;
    }
}
