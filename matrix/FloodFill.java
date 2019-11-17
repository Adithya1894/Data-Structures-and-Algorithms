

import java.util.*;

public class FloodFill{

	static class Node{
		int x;
		int y;

		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void floodAlgorithm(int[][] matrix, int x, int y, int newColor){

		int oldColor = matrix[x][y];
		if(oldColor == newColor)
			return; 

		matrix[x][y] = newColor;

		int rows[] = new int[]{-1, 1, 0, 0};
		int cols[] = new int[]{0, 0, -1, 1};

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x, y));

		while(!queue.isEmpty()){
			Node node = queue.poll();
			matrix[node.x][node.y] = newColor; 
			for(int k = 0; k < 4; k++){
				if(isSafe(matrix, node.x + rows[k], node.y + cols[k], oldColor)){
					queue.add(new Node(node.x + rows[k], node.y + cols[k])); 
				}
			}

		}

	}

	public static boolean isSafe(int[][] matrix, int x, int y, int oldColor){
		return (x >= 0) && (y >= 0) && (x < matrix.length) && (y < matrix[0].length) && (matrix[x][y] == oldColor); 
	}

	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(); 
		}
	}

	public static void main(String[] args){
		System.out.println("welcome to flood fill");

		int[][] matrix = new int[][]{{2, 2, 2, 2},
									 {2, 2, 2, 2},
									 {2, 2, 2, 2},
									 {2, 2, 2, 2}};

	    printMatrix(matrix);


	    System.out.println(System.nanoTime()); 
		floodAlgorithm(matrix, 1, 1, 2);
		System.out.println("**********************");
		System.out.println("After flood fill");
		printMatrix(matrix);  
		System.out.println(System.nanoTime()); 



	}

}