package BeautySquareMatrix;

import java.util.*;

public class BeautySquareMatrix {
	public static int[][] beautyMatrix(int[][] matrix, int n, int m){
		int[][] res = new int[n][n];
		
		TreeMap<Integer, List<int[]>> treemap = new TreeMap<>();
		for(int i = 0; i < n; i += m) {
			for(int j = 0; j < n; j += m) {
				int beauty = getBeauty(matrix, i, j, m);
				if(!treemap.containsKey(beauty)) treemap.put(beauty, new ArrayList<>());
				treemap.get(beauty).add(new int[] {i, j});
			}
		}
		
		int row = 0;
		int col = 0;
		for(int key : treemap.keySet()) {
			for(int[] pos : treemap.get(key)) {
				int i = pos[0];
				int j = pos[1];
				for(int r = i; r < i+m && r < n; r++) {
					for(int c = j; c < j+m && c < n; c++) {
						//System.out.println(row + " " + col+" " +r+" "+c);
						res[row][col] = matrix[r][c];
						col++;
					}
					row++;
					col -= m;
				}
				// next square m^2 -> right
				col += m;
				
				if(col == n) 
					col = 0;
				else
					row -= m;
					
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return res;
	}
	
	public static int getBeauty(int[][] matrix, int i, int j, int m) {
		Set<Integer> set = new HashSet<>();
		for(int r = i; r < i+m; r++) {
			for(int c = j; c < j+m; c++) {
				set.add(matrix[r][c]);
			}
		}
		
		for(int num = 1; num <= m*m; num++) 
			if(!set.contains(num)) return num;
		
		return m*m+1;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,1,2,6},
				{3,4,5,6,7,8},
				{6,7,8,9,10,11},
				{1,10,11,12,13,14},
				{12,13,14,15,16,17},
				{15,16,17,18,19,20}
		};
		beautyMatrix(matrix, 6, 3);
		int[][] a = {
				{1,2,1,2},
				{3,3,1,2},
				{1,1,2,2},
				{1,1,2,2}
		};
		beautyMatrix(a, 4, 1);
		beautyMatrix(a, 4, 2);
		beautyMatrix(a, 4, 4);
	}
}
