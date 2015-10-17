package lab1task;
import graphbuilder.ReadFile;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller {

	public static void main(String[] args) {

		String path = "D:\\Workspace\\Workspace_Java\\AILabs\\test2" ;
		//BFS bFS = new BFS();
		//DFS dFS = new DFS();
		//Heuristic h = new Heuristic();
		ArrayList<Integer> startNode = new ArrayList<Integer>();
		ArrayList<Integer> finishNode = new ArrayList<Integer>();
		
		//Node startNode = new Node();
		//Node finishNode ;
		//Dijkstra d = new Dijkstra();
		bidirect b = new bidirect();

		try {

			ReadFile readFile = new ReadFile(path);
			int [][] maze = readFile.mazeCreator();
		    //System.out.println(readFile.getStartPosition());
			startNode = readFile.getStartPosition();
			finishNode = readFile.getFinalPosition();
			
			
			System.out.println("Start position "+ startNode);
			System.out.println("Finish position "+ finishNode);
			
		/*	System.out.println("starting Position "+ startNode.x + " "+ startNode.y);
			
			System.out.println("final Position "+ finishNode.x + " "+ finishNode.y);*/
			//System.out.println(startNode.remove(0));
			//System.out.println(startNode.remove(0));
			
			//int max = maze.length;
			//int [][] heu = h.heurictic(maze, finishNode);
		//	System.out.println(startNode);

		//d.dijkstra(maze, startNode,finishNode);
	///	d.path();
			
			
			
		//	bFS.bfs(maze,startNode);
		//	bFS.path(finishtNode);
			
			//System.out.println("----------------------");
			
		/*	dFS.dfs(maze,startNode);
			dFS.path(finishNode);
*/
			//b.biDirectional(maze,startNode,finishNode);
			
			b.bi(maze,startNode.remove(0),startNode.remove(0),finishNode.remove(0),finishNode.remove(0));
			//b.bi(maze,1,5,4,2);
			b.path();

		}catch(Exception e){

			e.printStackTrace();
		}
	}
}


