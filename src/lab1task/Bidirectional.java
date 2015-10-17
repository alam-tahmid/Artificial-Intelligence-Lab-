package lab1task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bidirectional {

	/*public static int[][]parent;// 0= from up; 1= from bottom; 2 = from left; 3 = from right;
	public static int [][] color; // 1 for black and 0 for white.
	public static int h1;
	public static int h2;

	public static int t1;
	public static int t2;

	//public static void biDirectional(int [][] graphMatrix, ArrayList<Integer> sourceNode,ArrayList<Integer> finishNode){

	public static void biDirectional(int [][] graphMatrix, int h1,int h2,int t1,int t2){

		parent = new int[graphMatrix.length][graphMatrix[0].length];
		color = new int [graphMatrix.length][graphMatrix[0].length];

		h1= sourceNode.remove(0);
		h2 = sourceNode.remove(0);
		t1= finishNode.remove(0);
		t2 = finishNode.remove(0);

		h1= h1;
		h2= h2;
		t1= t1;
		t2=t2;

		System.out.println(h1);

		parent[h1][h2]=-1;
		color	[h1][h2]=1;// 1 means visited
		parent[t1][t2]=0;
		color[t1][t2]=1;
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		q1.add(h1);
		q1.add(h2);
		q2.add(t1);
		q2.add(t2);


		while(q1.size()!=0 ||q2.size()!=0 ){


			if(q1.size() !=0) {
				h1=q1.remove();
				h2=q1.remove();
			}

			if(q2.size() !=0) {
				t1=q2.remove();
				t2=q2.remove();
			}

			if(graphMatrix[h1-1][h2]==1){

				if(color[h1-1][h2]==0){

					color[h1-1][h2]=1;
					parent[h1-1][h2]=1;
					q1.add(h1-1);
					q1.add(h2);
					//taile up
					// printMatrix(colorMatrix);
				}
				else if(color[h1-1][h2]==2){

					break;
				}
			}

			if(graphMatrix[h1+1][h2]==1){

				if(color[h1+1][h2]==0){

					color[h1+1][h2]=1;
					parent[h1+1][h2]=0;
					q1.add(h1+1);
					q1.add(h2);
				} 
				else if(color[h1+1][h2]==2){

					break;

				}


				//taile down
				//   printMatrix(colorMatrix);
			}

			if(graphMatrix[h1][h2-1]==1){

				if(color[h1][h2-1]==0){

					color[h1][h2-1]=1;
					parent[h1][h2-1]=3;
					q1.add(h1);
					q1.add(h2-1);
					//taile left
					//  printMatrix(colorMatrix);
				} else if(color[h1][h2-1]==2){

					break;
				}

			}

			if(graphMatrix[h1][h2+1]==1){

				if(color[h1][h2+1]==0){
					color[h1][h2+1]=1;
					parent[h1][h2+1]=2; 
					q1.add(h1);
					q1.add(h2+1);
					//taile right
					//    printMatrix(colorMatrix);
				} else if(color[h1][h2+1]==2){

					break;
				}
			}


			if(graphMatrix[t1-1][t2]==1){

				if(color[t1-1][t2]==0){

					color[t1-1][t2]=2;
					parent[t1-1][t2]=1;
					q2.add(t1-1);
					q2.add(t2);
					//taile up
					// printMatrix(colorMatrix);
				}
				else if(color[t1-1][t2]==1){

					break;
				}
			}

			if(graphMatrix[t1+1][t2]==1){

				if(color[t1+1][t2]==0){

					color[t1+1][t2]=2;
					parent[t1+1][t2]=0;
					q2.add(t1+1);
					q2.add(t2);
				} 
				else if(color[t1+1][t2]==1){

					break;

				}


				//taile down
				//   printMatrix(colorMatrix);
			}

			if(graphMatrix[t1][t2-1]==1){

				if(color[t1][t2-1]==0){

					color[t1][t2-1]=2;
					parent[t1][t2-1]=3;
					q2.add(t1);
					q2.add(t2-1);
					//taile left
					//  printMatrix(colorMatrix);
				} else if(color[t1][t2-1]==1){

					break;
				}

			}

			if(graphMatrix[t1][t2+1]==1){

				if(color[t1][t2+1]==0){
					color[t1][t2+1]=2;
					parent[t1][t2+1]=2; 
					q2.add(t1);
					q2.add(t2+1);
					//taile right
					//    printMatrix(colorMatrix);
				} else if(color[t1][t2+1]==1){

					break;
				}



			}
		}
		}

	 */

	/*	public static int[][]parent;// 0= from up; 1= from bottom; 2 = from left; 3 = from right;
	public static int [][] color; // 1 for black and 0 for white.
	public static int h1;
	public static int h2;

	public static int t1;
	public static int t2;

	public static void biDirectional(int [][] graphMatrix, int h1, int h2, int t1, int t2){

		parent = new int[graphMatrix.length][graphMatrix[0].length];
		color = new int [graphMatrix.length][graphMatrix[0].length];

		h1= h1;
		h2 = h2;

		t1= t1;
		t2 =t2;

		parent[h1][h2]=-1;
		color	[h1][h2]=1;// 1 means visited
		// parentsMatrix[t1][t2]=0;
		color[t1][t2]=1;
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		q1.add(h1);
		q1.add(h2);
		q2.add(t1);
		q2.add(t2);

		while(q1.size()!=0 ||q2.size()!=0 ){
			if(q1.size() !=0) {
				h1=q1.remove();
				h2=q1.remove();
			}
			if(q2.size() !=0) {
				t1=q2.remove();
				t2=q2.remove();
			}
			if(graphMatrix[h1-1][h2]==1 && color[h1-1][h2]==0){

				color[h1-1][h2]=1;
				q1.add(h1-1);
				q1.add(h2);
				parent[h1-1][h2]=1;//taile up
				// printMatrix(colorMatrix);
			}

			if(graphMatrix[h1+1][h2]==1 && color[h1+1][h2]==0){
				color[h1+1][h2]=1;
				q1.add(h1+1);
				q1.add(h2);
				parent[h1+1][h2]=0;//taile down
				//   printMatrix(colorMatrix);
			}

			if(graphMatrix[h1][h2-1]==1 && color[h1][h2-1]==0){
				color[h1][h2-1]=1;
				q1.add(h1);
				q1.add(h2-1);
				parent[h1][h2-1]=3;//taile left
				//  printMatrix(colorMatrix);

			}

			if(graphMatrix[h1][h2+1]==1 && color[h1][h2+1]==0){
				color[h1][h2+1]=1;
				q1.add(h1);
				q1.add(h2+1);
				parent[h1][h2+1]=2; //taile right
				//    printMatrix(colorMatrix);
			}


				if(graphMatrix[t1-1][t2]==1 && color[t1-1][t2]==0){
					color[t1-1][t2]=1;
					q2.add(t1-1);
					q2.add(t2);
					parent[t1-1][t2]=1;//taile up
					//  printMatrix(colorMatrix);
				}
					if(graphMatrix[t1+1][t2]==1 && color[t1+1][t2]==0){
						color[t1+1][t2]=1;
						q2.add(t1+1);
						q2.add(t2);
						parent[t1+1][t2]=0;//taile down
						//   printMatrix(colorMatrix);
					}

				if(graphMatrix[t1][t2-1]==1 && color[t1][t2-1]==0){
					color[t1][t2-1]=1;
					q2.add(t1);
					q2.add(t2-1);
					parent[t1][t2-1]=3;//taile left
					//   printMatrix(colorMatrix);

				}

				if(graphMatrix[t1][t2+1]==1 && color[t1][t2+1]==0){
					color[t1][t2+1]=1;
					q2.add(t1);
					q2.add(t2+1);
					parent[t1][t2+1]=2;//taile left
					//   printMatrix(colorMatrix);

				}
			}
		}*/


	public static int[][]parentsMatrix;// 0= from up; 1= from bottom; 2 = from left; 3 = from right;
	public static int [][] colorMatrix; // 1 for black and 0 for white.
	public static int [][] graphMatrix;
	public static int h1;
	public static int h2;

	public static int t1;
	public static int t2;

	public static void biDirectional(int [][] graphMatrix,int h1, int h2,int t1,int t2){


		parentsMatrix = new int[graphMatrix.length][graphMatrix[0].length];
		colorMatrix = new int [graphMatrix.length][graphMatrix[0].length];

		h1= h1;
		h2 = h2;

		t1= t1;
		t2 =t2;
		parentsMatrix[h1][h2]=-1;
		colorMatrix[h1][h2]=1;
		// parentsMatrix[t1][t2]=0;
		colorMatrix[t1][t2]=1;
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		q1.add(h1);
		q1.add(h2);
		q2.add(t1);
		q2.add(t2);
		while(q1.size()!=0 ||q2.size()!=0 ){
			if(q1.size() !=0) {
				h1=q1.remove();
				h2=q1.remove();
			}
			if(q2.size() !=0) {
				t1=q2.remove();
				t2=q2.remove();
			}
			if(graphMatrix[h1-1][h2]==1 && colorMatrix[h1-1][h2]==0){
				colorMatrix[h1-1][h2]=1;
				q1.add(h1-1);
				q1.add(h2);
				parentsMatrix[h1-1][h2]=1;//taile up
				// printMatrix(colorMatrix);
			}

			if(graphMatrix[h1+1][h2]==1 && colorMatrix[h1+1][h2]==0){
				colorMatrix[h1+1][h2]=1;
				q1.add(h1+1);
				q1.add(h2);
				parentsMatrix[h1+1][h2]=0;//taile down
				//   printMatrix(colorMatrix);
			}

			if(graphMatrix[h1][h2-1]==1 && colorMatrix[h1][h2-1]==0){
				colorMatrix[h1][h2-1]=1;
				q1.add(h1);
				q1.add(h2-1);
				parentsMatrix[h1][h2-1]=3;//taile left
				//  printMatrix(colorMatrix);

			}

			if(graphMatrix[h1][h2+1]==1 && colorMatrix[h1][h2+1]==0){
				colorMatrix[h1][h2+1]=1;
				q1.add(h1);
				q1.add(h2+1);
				parentsMatrix[h1][h2+1]=2; //taile right
				//    printMatrix(colorMatrix);
			}
			if(graphMatrix[t1][t2-1]==1 && colorMatrix[t1][t2-1]==0){
				colorMatrix[t1][t2-1]=1;
				q2.add(t1);
				q2.add(t2-1);
				parentsMatrix[t1][t2-1]=3;//taile left
				//    printMatrix(colorMatrix);
			}
				if(graphMatrix[t1-1][t2]==1 && colorMatrix[t1-1][t2]==0){
					colorMatrix[t1-1][t2]=1;
					q2.add(t1-1);
					q2.add(t2);
					parentsMatrix[t1-1][t2]=1;//taile up
					//  printMatrix(colorMatrix);
				}
				if(graphMatrix[t1+1][t2]==1 && colorMatrix[t1+1][t2]==0){
					colorMatrix[t1+1][t2]=1;
					q2.add(t1+1);
					q2.add(t2);
					parentsMatrix[t1+1][t2]=2;//taile down
					//   printMatrix(colorMatrix);
				}

				if(graphMatrix[t1][t2-1]==1 && colorMatrix[t1][t2-1]==0){
					colorMatrix[t1][t2-1]=1;
					q2.add(t1);
					q2.add(t2-1);
					parentsMatrix[t1][t2-1]=3;//taile left
					//   printMatrix(colorMatrix);

				}

			}
		}
	


	public void path(){

		ArrayList path = new ArrayList();

		int ex = t1;
		int ey = t2;

		/*for(int row = 0; row< parent.length; row++){

				for (int column = 0; column<parent[row].length; column++){

					System.out.print(parent [row][column]+" ");
				}
				System.out.println();
			}*/


		while(parentsMatrix[ex][ey]!=-1){


			if(parentsMatrix[ex][ey]==0){ 

				path.add("Down");
				ex--;
				System.out.println(ex);
			} if(parentsMatrix[ex][ey]==1){

				path.add("Up");
				ex++;
			} if(parentsMatrix[ex][ey]==2){

				path.add("Right");
				ey--;
			} if(parentsMatrix[ex][ey]==3){

				path.add("Left");
				ey++;
			}
		}


		for(int i=path.size()-1;i>=0;i--){

			System.out.println(path.get(i));
		}
	}




}


