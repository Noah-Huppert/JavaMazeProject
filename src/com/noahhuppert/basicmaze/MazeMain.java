
package com.noahhuppert.basicmaze;

// main class for Mini-Maze Project; all it currently does is create a maze
// object and print it out

import com.noahhuppert.basicmaze.models.EnhancedMaze;
import com.noahhuppert.basicmaze.models.Maze;
import com.noahhuppert.basicmaze.models.MazePoint;
import com.noahhuppert.basicmaze.models.MazePointNode;
import com.noahhuppert.basicmaze.models.solvers.DepthFirstSolver;

import java.util.List;

public class MazeMain {
		public static void main(String args[]) {
			Maze maze = new Maze();
			maze.printMaze();

			EnhancedMaze enhancedMaze = new EnhancedMaze(maze);
			DepthFirstSolver depthFirstSolver = new DepthFirstSolver(enhancedMaze);

			MazePoint endPoint = new MazePoint(maze.getEndCoords());

			List<MazePointNode> solution = depthFirstSolver.solve(endPoint);

			System.out.println(solution);

			enhancedMaze.printSolution(solution);
		}
}
