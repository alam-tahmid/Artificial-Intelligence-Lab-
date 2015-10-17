package lab1task;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] maze = {{0,0,0,0,0,0,0},
				{0,1,1,0,1,1,0},
				{0,0,1,1,1,1,1,1,0},
				{0,1,1,0,1,0,1,0},
				{0,1,1,-1,1,1,1,0},
				{0,1,1,1,0,1,0},
				{0,0,1,1,1,1,0},
				{0,0,0,0,0,0,0}
		};

		
		
		Node node = new Node(4,2);
		//node.add(4, 2);//starting node

		Dijkstra d = new Dijkstra();
		d.dijkstra(maze, node);
		d.path(node);
		
	}
}
