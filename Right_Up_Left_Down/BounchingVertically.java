package Right_Up_Left_Down;

import java.util.*;

public class BounchingVertically {
	public static List<Integer> travel(int[][] matrix, int row){
		List<Integer> res = new ArrayList<>();
		
		int n = matrix.length;
		int r = row;
		int c = 0;
		
		while(r >= 0 && c < n) {
			res.add(matrix[r][c]);
			r--;
			c++;
		}
		
		r += 2;
		while(c < n && row < n) {
			res.add(matrix[r][c]);
			r++;
			c++;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int matrix[][] = {
				{1,8,4,3,4},
				{2,8,0,3,1},
				{0,7,9,0,8},
				{5,0,3,1,6},
				{1,5,0,3,1},
		};
		System.out.print(travel(matrix, 4));
		System.out.print(travel(matrix, 2));
	}
}
