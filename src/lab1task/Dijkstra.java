package lab1task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

	public int [][] color;
	public int [][] parent;
	public int [][] distance;
	public int [] cost;
	public int [][] graph;
	
	
	public void dijkstra(int [][] graph, Node start){
		
		
		//cost = new int []{1,2,3,4};// x-1=cost[0]=up, x+1=cost[1]=down, y-2=cost[2]=left, y+1=cost[3]=right
		
		color = new int [graph.length][graph[0].length];
		parent = new int [graph.length][graph[0].length];
		distance = new int [graph.length][graph[0].length];
		this.graph = graph;
		System.out.println(start);
		int sx = start.x;
		int sy = start.y;
		
		Node source = new Node(sx,sy);
		//source.add(sx,sy);
		
		distance[source.x][source.y] = 0;
		parent [source.x][source.y] = -1;
		color [source.x][source.y]= 1;
		
		Set<Node> explored = new HashSet<Node>();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(10, new Comparator<Node>(){
			
			public int compare(Node i, Node j){
				
				
				
				if(graph[i.x][i.y]>graph[j.x][j.y])
					
					return 1;
				
				if(graph[i.x][i.y]<graph[j.x][j.y])
					
					return -1;
				
				else 
					
					return 0;
			}
		});
		
		
		queue.add(source);
		
		Node to = new Node();
		
		while (!queue.isEmpty()){
			
			Node current = queue.poll();
			explored.add(current);
			System.out.println(current.x +" " + current.y);
			
			if(graph[current.x-1][current.y]==1 && color [current.x-1][current.y]==0){// upper row

				color [current.x-1][current.y] = 1;
				parent[current.x-1][current.y] = 1;
				to.add(current.x-1,current.y);
				relax(current, to);
				queue.add(to);
			}

			if(graph[current.x+1][current.y]==1 && color [current.x+1][current.y]==0){// bottom row

				
				color [current.x+1][current.y] = 1;
				parent[current.x+1][current.y] = 0;
				
				to.add(current.x+1,current.y);
				relax(current, to);
				queue.add(to);
			}

			if(graph[current.x][current.y-1] ==1 && color[current.x][current.y-1] ==0){// left column

			
				
				color [current.x][current.y-1] = 1;
				parent[current.x][current.y-1] = 3;
				
				to.add(current.x,current.y-1);
				relax(current, to);
				queue.add(to);
				
			
			}

			if(graph[current.x][current.y+1]==1 && color[current.x][current.y+1]==0){// right column

				color [current.x][current.y+1] = 1;
				parent[current.x][current.y+1] = 2;
				
				to.add(current.x,current.y+1);
				relax(current, to);
				queue.add(to);
			
			}
		}
		
	}
	
	public void relax(Node from, Node to){

		int fx= from.x;
		int fy = from.y;
		int tx = to.x;
		int ty = to.y;
		
		if(distance[tx][ty] <graph[tx][ty]+distance[fx][fy]){// if d.v > adj[u][v]+d.u

			distance[tx][ty] = distance[fx][fy]+graph[fx][fy];// distance will be updated
			//parent[tx][ty] = 1;// parent will be set to u
		}
	}
	
	public void path(Node  node){

		ArrayList path = new ArrayList();

	/*	int ex = home.remove(0);
		int ey = home.remove(0);*/
		
		int ex = 1;
		int ey = 5;
		
		for (int rowCounter = 0; rowCounter < parent.length; rowCounter++) {

			for (int columnCounter = 0; columnCounter < parent[rowCounter].length; columnCounter++) {

				System.out.print("["+rowCounter+"]["+columnCounter+"]: "+ parent[rowCounter][columnCounter]+"\t");
			}

			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		for (int rowCounter = 0; rowCounter < distance.length; rowCounter++) {

			for (int columnCounter = 0; columnCounter < distance[rowCounter].length; columnCounter++) {

				System.out.print("["+rowCounter+"]["+columnCounter+"]: "+ distance[rowCounter][columnCounter]+"\t");
			}

			System.out.println();
		}

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
