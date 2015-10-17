package lab1task;




import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bidirect {


	public int[][]parentFromSource;// 0= from up; 1= from bottom; 2 = from left; 3 = from right;
	public int[][]parentFromDistance;
	public int [][] color; // 1 for black and 0 for white.
	public static int des1;
	public static int des2;
	public static int midX;
	public static int midY;

	public void bi(int [][] graph,int h1, int h2,int dt1,int dt2){

		parentFromSource = new int[graph.length][graph[0].length];
		parentFromDistance = new int[graph.length][graph[0].length];
		color = new int [graph.length][graph[0].length];

		int x = h1;
		int y = h2;

		int dx=dt1;
		int dy=dt2;

		des1=dx;
		des2=dy;

		parentFromSource [x][y]=-1;
		parentFromDistance [dx][dy]=-1;
		color [x][y]=1;
		color [dx][dy]=2;

		Queue<Integer> queX = new LinkedList<Integer>();
		Queue<Integer> queY = new LinkedList<Integer>();

		queX.add(x);
		queX.add(y);

		queY.add(dx);
		queY.add(dy);

		int u=0;
		int v=0;

		int t1=0;
		int t2=0;

		while(queX.size() !=0 || queY.size() !=0){


			if(queX.size() !=0) {
				u=queX.remove();
				v=queX.remove();
			}

			if(queY.size() !=0) {
				t1=queY.remove();
				t2=queY.remove();
			}



			if(graph[u-1][v]==1){

				if( color [u-1][v]==0){

					color [u-1][v] = 1;
					parentFromSource[u-1][v] = 1;
					queX.add(u-1);
					queX.add(v);

				} else if(color [u-1][v]==2){

					parentFromSource[u-1][v] = 1;
					color [u-1][v]=1;
					midX= u-1;
					midY=v;
					break;
				}


			}

			if(graph[u+1][v]==1){


				if(color [u+1][v]==0){// bottom row

					color [u+1][v] = 1;
					parentFromSource[u+1][v] = 0;
					queX.add(u+1);
					queX.add(v);
				}
				else if(color [u+1][v]==2){

					parentFromSource[u+1][v] = 0;
					color [u+1][v]=1;
					midX= u+1;
					midY=v;
					break;
				}
			}

			if(graph[u][v-1]==1){


				if(color [u][v-1]==0){// left column

					color [u][v-1] = 1;
					parentFromSource[u][v-1] = 3;
					queX.add(u);
					queX.add(v-1);
				} 
				else if(color [u][v-1]==2){

					color [u][v-1] = 1;
					color [u][v-1]=1;
					midX= u;
					midY=v-1;
					break;
				}
			}


			if(graph[u][v+1]==1){

				if(color [u][v+1]==0){

					color [u][v+1] = 1;
					parentFromSource[u][v+1] = 2;
					queX.add(u);
					queX.add(v+1);
				} 
				else if(color [u][v+1]==2){

					parentFromSource[u][v+1] = 2;
					color [u][v+1]=1;
					midX= u;
					midY= v+1;
					break;
				}
			}

			if(graph[t1-1][t2]==1){

				if(color [t1-1][t2]==0){

					color [t1-1][t2] = 2;
					parentFromDistance[t1-1][t2] = 1;
					queY.add(t1-1);
					queY.add(t2);
				} 
				else if(color[t1-1][t2]==1){

					parentFromDistance[t1-1][t2] = 1;
					color[t1-1][t2]=2;
					midX= t1-1;
					midY = t2;
					break;
				}

			}

			if(graph[t1+1][t2]==1){

				if(color [t1+1][t2]==0){// bottom row

					color [t1+1][t2] = 2;
					parentFromDistance[t1+1][t2] = 0;
					queY.add(t1+1);
					queY.add(t2);
				}
				else if(color [t1+1][t2] == 1){

					parentFromDistance[t1+1][t2] = 0;
					color[t1+1][t2]=2;
					midX = t1+1;
					midY = t2;
					break;
				}
			}

			if(graph[t1][t2-1]==1){

				if(color [t1][t2-1]==0){// left column

					color [t1][t2-1] = 2;
					parentFromDistance[t1][t2-1] = 3;
					queY.add(t1);
					queY.add(t2-1);
				}
				else if(color [t1][t2-1] == 1){

					parentFromDistance[t1][t2-1] = 3;
					color[t1][t2-1]=2;
					midX = t1;
					midY = t2-1;
					break;
				}
			}

			if(graph[t1][t2+1]==1){


				if(color [t1][t2+1]==0){// right column

					color [t1][t2+1] = 2;
					parentFromDistance[t1][t2+1] = 2;
					queY.add(t1);
					queY.add(t2+1);
				}
				else if(color [t1][t2+1] ==1){

					parentFromDistance[t1][t2+1] = 2;
					color[t1][t2+1]=2;
					midX = t1;
					midY = t2+1;
					break;
				}
			}
		}
	}

	public void path(){

		ArrayList path = new ArrayList();
		ArrayList path1 = new ArrayList();

		int ex = midX;
		int ey = midY;

		while(parentFromSource[ex][ey]!=-1){


			if(parentFromSource[ex][ey]==0){ 

				path.add("Down");
				ex--;
			} if(parentFromSource[ex][ey]==1){

				path.add("Up");
				ex++;
			} if(parentFromSource[ex][ey]==2){

				path.add("Right");
				ey--;
			} if(parentFromSource[ex][ey]==3){

				path.add("Left");
				ey++;
			}
		}
		

		ex = midX;
		ey = midY;
		
		
		while(parentFromDistance[ex][ey]!=-1){


			if(parentFromDistance[ex][ey]==0){ 

				path1.add("Up");
				ex--;
			} if(parentFromDistance[ex][ey]==1){

				path1.add("Down");
				ex++;
			} if(parentFromDistance[ex][ey]==2){

				path1.add("Left");
				ey--;
			} if(parentFromDistance[ex][ey]==3){

				path1.add("Right");
				ey++;
			}
		}

		Collections.reverse(path1);
		
		System.out.println("----------Source-------------");
		for(int i=path.size()-1;i>=0;i--){

			System.out.println(path.get(i));
		}
		
		
		System.out.println("------------Destination----------------");
		
		for(int i=path.size()-1;i>=0;i--){

			System.out.println(path1.get(i));
		}
	}
}


