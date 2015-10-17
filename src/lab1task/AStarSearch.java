package lab1task;


import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


public class AStarSearch {



	public static int [][] color;
	public static int [][] graph;
	public static int [][] parent;
	public static class Compare implements Comparator<Node> {

		public int compare(Node i, Node j){
			if(i.f_scores > j.f_scores){
				return 1;
			}

			else if (i.f_scores < j.f_scores){
				return -1;
			}

			else{
				return 0;
			}
		}
	}
	public static class Node {

		public  int dx;
		public int dy;
		public double g_scores;
		public int heuristicValue;
		public double f_scores = 0;
		public Edge[] adjacencies;
		public Node parent;

		public Node(int dx,int dy, int heheuristicValueu){

			this.dx = dx;
			this.dy = dy;
			this.heuristicValue = heuristicValue;
		}

		public int getDx(){

			return dx;
		}
		public int getDy(){

			return dy;
		}
		public int getHeuristicValue(){

			return heuristicValue;
		}


	}
	public static class Edge {

		public final double cost;
		public final Node target;

		public Edge(Node targetNode, double costVal){
			target = targetNode;
			cost = costVal;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);



		Node [] node = new Node[5];
/*
		node[0] = new Node("s",7);
		node[1]= new Node("a",6);
		node[2] = new Node ("b",4);
		node[3] = new Node("c",2);
		node[4] = new Node("g",0);*/

		String [] a = {"s","a","b","c","g"};
		System.out.println("Places: ");
		for(String s : a){

			System.out.println(s);
		}

		System.out.print("From: ");
		String from = scanner.next();
		System.out.println();
		System.out.print("To: ");
		String to = scanner.next();



		node[0].adjacencies = new Edge[]{

				new Edge(node[1],1),
				new Edge(node[2],4)
		};

		int  fromCount =0;
		for(Node n : node){

			if(from.equals(n.toString())){

				System.out.println(fromCount);
				break;
			}else{

				fromCount++;
			}
		}

		int  toCount = 0;
		for(Node n : node){

			if(to.equals(n.toString())){

				System.out.println(toCount);
				break;
			}else{

				toCount++;
			}
		}
		node[1].adjacencies = new Edge[]{

				new Edge(node[0],1),
				new Edge(node[2],2),
				new Edge(node[3],5),
				new Edge(node[4],12)
		};
		node[2].adjacencies = new Edge[]{

				new Edge(node[0],4),
				new Edge(node[1],2),
				new Edge(node[3],2),
		};
		node[3].adjacencies = new Edge[]{

				new Edge(node[1],5),
				new Edge(node[2],2),
				new Edge(node[4],3),
		};
		node[4].adjacencies = new Edge[]{

				new Edge(node[1],12),
				//new Edge (node[2],),
				new Edge (node[3],3)
		};




		AstarSearch(node[fromCount],node[toCount]);

		List<Node> path = printPath(node[toCount]);

		System.out.println("Path: " + path);
	}

	public static List<Node> printPath(Node target){
		List<Node> path = new ArrayList<Node>();

		for(Node node = target; node!=null; node = node.parent){
			path.add(node);
		}

		Collections.reverse(path);

		return path;
	}

		public int lowest(int x, int y){
			
			
		}
		public static void AstarSearch(Node source, Node goal){


		color = new int[7][8];
		graph = new int[7][8];
		parent = new int[7][8];

		int dx= 0;
		int dy= 0;
		Set<Node> explored = new HashSet<Node>();
		Compare compare = new Compare();
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(10, compare);


		//cost from start
		source.g_scores = 0;

		queue.add(source);

		boolean found = false;

		while((!queue.isEmpty())&&(!found)){

			//the node in having the lowest f_score value
			Node current = queue.poll();

			int sx=current.getDx();
			int sy = current.getDy();
			
			explored.add(current);

			//goal found
			if((sx==dx) && (sy==dy)){
				found = true;
			}

			//check every child of current node
			
			if(graph[sx-1][sy]==1 && color [sx-1][sy]==0){// upper row

				color [sx-1][sy] = 1;
				parent[sx-1][sy] = 1;
				///////////////////////////////////s
				
				double cost = heu[sx-1][sy];
				double temp_g_scores = graph[sx-1][sy] + cost;
				double temp_f_scores = temp_g_scores + child.h_scores;

				//queX.add(u-1);
				///queY.add(v);
			}

			if(graph[u+1][v]==1 && color [u+1][v]==0){// bottom row

				color [u+1][v] = 1;
				parent[u+1][v] = 0;
				///queX.add(u+1);
				////queY.add(v);
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
			
			for(Edge e : current.adjacencies){
				Node child = e.target;
				double cost = e.cost;
				double temp_g_scores = current.g_scores + cost;
				double temp_f_scores = temp_g_scores + child.h_scores;


				/*if child node has been evaluated and 
                                the newer f_score is higher, skip*/

				if((explored.contains(child)) && 
						(temp_f_scores >= child.f_scores)){
					//continue;
				}

				/*else if child node is not in queue or 
                                newer f_score is lower*/

				else if((!queue.contains(child)) || 
						(temp_f_scores < child.f_scores)){

					child.parent = current;
					child.g_scores = temp_g_scores;
					child.f_scores = temp_f_scores;

					if(queue.contains(child)){
						queue.remove(child);
					}

					queue.add(child);

				}

			}

		}

	}
}
