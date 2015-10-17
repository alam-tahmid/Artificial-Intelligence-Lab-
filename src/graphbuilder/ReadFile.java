package graphbuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import lab1task.Node;


public class ReadFile {

	private String path;
	private int startRow;
	private int startColumn;
	private int finalRow;
	private int finalColumn;
	private int [][] maze;
	//public Node start;
	public Node finish;
	ArrayList<Integer> start;

	public ReadFile(String path){
 
		
		this.path = path;
		start = new ArrayList<Integer>();
		
	}

	//// Following method will build reading from text file
	//// It will return a 2D matrix.

	public int[][] mazeCreator() throws IOException{

		FileReader fileReader = new FileReader(path);
		Scanner input = new Scanner(fileReader);

		// Following line will read the row number from the text.
		int row = input.nextInt();
		// Following line will read the row number from the text.
		int column = input.nextInt();

		// After reading the numbers it will create a 2D matrix with corresponding value
		maze = new int [row+2][column+2];

		// Firstly this will create a whole graphconnected with each other
		for (int rowCounter = 1; rowCounter < maze.length-1; rowCounter++) {

			for (int columnCounter = 1; columnCounter < maze[rowCounter].length-1; columnCounter++) {

				maze[rowCounter][columnCounter] = 1;
			}
		}

		// Following line will keep track of starting positions.

		startPosition(input.nextInt()+1, input.nextInt()+1);
		//start= new Node(input.nextInt()+1, input.nextInt()+1);

		// Following line will keep track of final positions.
		finalPosition(input.nextInt()+1, input.nextInt()+1);

		//finish = new Node(input.nextInt()+1, input.nextInt()+1);
		// Following line will take the input of number of blockade.
		int limit = input.nextInt();


		// Following loop will disconnect some of the block with each other
		int counter = 0;
		while(counter<limit){

			maze[input.nextInt()+1][input.nextInt()+1] = 0;
			counter++;
		}

		input.close();
		return maze;
	}

	// Following method will return the start position.
	public ArrayList<Integer> getStartPosition(){





		return start;
	}




	// Following method will save the start position.
	public void startPosition(int startRow, int startColumn){
		//start = new ArrayList<Integer>();
		
		/*this.startRow = startRow;
		this.startColumn = startColumn;*/
		start.add(startRow);
		start.add(startColumn);
		System.out.println(start);
		//start = new Node(startRow, startColumn);
		//start.add();



	}

	/*public Node getStartPosition(){

		ArrayList<Integer> startPosition = new ArrayList<Integer>();

		startPosition.add(startRow);
		startPosition.add(startColumn);

		System.out.println(start.x);
		System.out.println(start.y);
		return start;
	}
	 */
	public ArrayList<Integer> getFinalPosition(){

		ArrayList<Integer> finalPosition = new ArrayList<Integer>();

		finalPosition.add(finalRow);
		finalPosition.add(finalColumn);

		return finalPosition;
	}

	/*	public Node getFinalPosition(){

		ArrayList<Integer> finalPosition = new ArrayList<Integer>();

		finalPosition.add(finalRow);
		finalPosition.add(finalColumn);

		return finish;
	}*/

	public void finalPosition(int finalRow, int finalColumn){

		this.finalRow = finalRow;
		this.finalColumn = finalColumn;



	}

	public void print (){

		for (int rowCounter = 0; rowCounter < maze.length; rowCounter++) {

			for (int columnCounter = 0; columnCounter < maze[rowCounter].length; columnCounter++) {

				System.out.print("["+rowCounter+"]["+columnCounter+"]: "+ maze[rowCounter][columnCounter]+"\t");
			}

			System.out.println();
		}
	}
}
