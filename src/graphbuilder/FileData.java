package graphbuilder;
import java.io.IOException;
import java.util.ArrayList;

import lab1task.Heuristic;

public class FileData {

	public static void main(String[] args) throws IOException {

		String path = "D:\\Workspace\\Workspace_Java\\AILabs\\test2" ;

		try {

			ReadFile readFile = new ReadFile(path);

			int [][] maze = readFile.mazeCreator();
			Heuristic h = new Heuristic();

			int max = maze.length;
			
			
			for (int rowCounter = 0; rowCounter < maze.length; rowCounter++) {

				for (int columnCounter = 0; columnCounter < maze[rowCounter].length; columnCounter++) {

					System.out.print("["+rowCounter+"]["+columnCounter+"]: "+ maze[rowCounter][columnCounter]+"\t");
				}

				System.out.println();
			}

	/*		ArrayList<Integer> startPosition = new ArrayList<Integer>();
			startPosition = readFile.getStartPosition();

			ArrayList<Integer> finalPosition = new ArrayList<Integer>();
			
			System.out.println("Final position" + finalPosition);
			
			int [][] heu = h.heurictic(maze, finalPosition);
			
			for (int rowCounter = 0; rowCounter < heu.length; rowCounter++) {

				for (int columnCounter = 0; columnCounter < heu[rowCounter].length; columnCounter++) {

					System.out.print("["+rowCounter+"]["+columnCounter+"]: "+ heu[rowCounter][columnCounter]+"\t");
				}

				System.out.println();
			}
			
			
			System.out.println();
			System.out.println();
			
			for (int rowCounter = 0; rowCounter < maze.length; rowCounter++) {

				for (int columnCounter = 0; columnCounter < maze[rowCounter].length; columnCounter++) {

					System.out.print("["+rowCounter+"]["+columnCounter+"]: "+ maze[rowCounter][columnCounter]+"\t");
				}

				System.out.println();
			}*/


		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
