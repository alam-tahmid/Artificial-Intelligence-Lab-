package lab1task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public int[][]parent;// 0= from up; 1= from bottom; 2 = from left; 3 = from right;
	public int [][] color; // 1 for black and 0 for white.

	public void bfs(int [][] graph, ArrayList<Integer> sourceNode){

		parent = new int[graph.length][graph[0].length];
		color = new int [graph.length][graph[0].length];

		int x = sourceNode.remove(0);
		int y = sourceNode.remove(0);

		parent [x][y]=-1;
		color [x][y]=1;

		Queue<Integer> queX = new LinkedList<Integer>();
		Queue<Integer> queY = new LinkedList<Integer>();

		queX.add(x);
		queY.add(y);

		while(queX.size() !=0 || queY.size() !=0){

			int u = queX.poll();
			int v = queY.poll();

			if(graph[u-1][v]==1 && color [u-1][v]==0){// upper row

				color [u-1][v] = 1;
				parent[u-1][v] = 1;
				queX.add(u-1);
				queY.add(v);
			}

			if(graph[u+1][v]==1 && color [u+1][v]==0){// bottom row

				color [u+1][v] = 1;
				parent[u+1][v] = 0;
				queX.add(u+1);
				queY.add(v);
			}

			if(graph[u][v-1]==1 && color [u][v-1]==0){// left column

				color [u][v-1] = 1;
				parent[u][v-1] = 3;
				queX.add(u);
				queY.add(v-1);
			}

			if(graph[u][v+1]==1 && color [u][v+1]==0){// right column

				color [u][v+1] = 1;
				parent[u][v+1] = 2;
				queX.add(u);
				queY.add(v+1);
			}
		}
	}

	public void path(ArrayList<Integer> home){

		ArrayList path = new ArrayList();

		int ex = home.remove(0);
		int ey = home.remove(0);

		while(parent[ex][ey]!=-1){


			if(parent[ex][ey]==0){ 

				path.add("Down");
				ex--;
			} if(parent[ex][ey]==1){

				path.add("Up");
				ex++;
			} if(parent[ex][ey]==2){

				path.add("Right");
				ey--;
			} if(parent[ex][ey]==3){

				path.add("Left");
				ey++;
			}
		}
		
		for(int i=path.size()-1;i>=0;i--){
			
			System.out.println(path.get(i));
		}
	}
}

