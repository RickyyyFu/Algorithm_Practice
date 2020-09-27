package BlackWhiteMatrixSort;

import java.util.PriorityQueue;

public class BlackWhiteSort {
	public static void sort(int[][] matrix, int[][] queries) {
		if(matrix.length == 0 || matrix[0].length == 0) return;
		
		for(int[] query : queries) {
			int r_start = query[0];
			int c_start = query[1];
			int w = query[2];
			
			PriorityQueue<Integer> black = new PriorityQueue<>();
			PriorityQueue<Integer> white = new PriorityQueue<>();
			
			for(int row = r_start; row < r_start+w; row++) {
				for(int col = c_start; col < c_start+w; col++) {
					if((row+col) % 2 == 0) black.offer(matrix[row][col]);
					else white.offer(matrix[row][col]);
				}
			}
			
			for(int row = r_start; row < r_start+w; row++) {
				for(int col = c_start; col < c_start+w; col++) {
					if((row+col) % 2 == 0) matrix[row][col] = black.poll();
					else matrix[row][col] = white.poll();
				}
			}
		}
	}
	
	public static void main(String[] args){
        int[][] matrix = new int[][]{{83,67,39,85,11,21,87}, {25,48,74,7,15,74,90}, {13,10,87,57,3,75,36}, {19,47,89,48,16,7,81}, {79,40,68,70,25,59,96}};
        sort(matrix, new int[][]{{0,0,3},{0,3,4}});
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
	}
}
