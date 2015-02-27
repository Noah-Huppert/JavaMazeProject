
package com.noahhuppert.basicmaze;

// main class for Mini-Maze Project; all it currently does is create a maze
// object and print it out

import com.noahhuppert.basicmaze.models.EnhancedMaze;
import com.noahhuppert.basicmaze.models.Maze;

public class MazeMain {
		public static void main(String args[]) {
			Maze maze = new Maze();
			maze.printMaze();

			EnhancedMaze enhancedMaze = new EnhancedMaze(maze);

			System.out.println(enhancedMaze.getEmptyPointsNextTo(enhancedMaze.getCursorCoords()));
		}
}
