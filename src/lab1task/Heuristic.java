package lab1task;

import java.util.ArrayList;

public class Heuristic {

	public int heu [][];

	public int[][] heurictic(int [][] graph,ArrayList<Integer> finish){

		heu = new int [graph.length][graph[0].length];

		for(int row = 0; row<heu.length; row++){
			
			for(int column = 0; column<heu[row].length; column++){


				heu [row][column] = graph[row][column];
			}
		}
		
		int dx = finish.get(0);
		int dy = finish.get(0);

		for(int row = 1; row<heu.length-1; row++){
			for(int column = 1; column<heu[row].length-1; column++){

				if(heu[row][column]!=0){

					int sum = Math.abs((dx-row)+(dy-column));
					heu [row][column] = sum;
				}

			}

		}
		
		return heu;
	}
}
