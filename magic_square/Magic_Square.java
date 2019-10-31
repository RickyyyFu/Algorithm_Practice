package magic_square;

public class Magic_Square {
	public static int solution(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		
		int N = grid.length;
		int M = grid[0].length;
		if(N <= 1 || M <= 1) return Math.min(N, M);
		
		// greedy -> starts with largest possible size
		int size =  Math.min(N, M);
		while(size > 0) {
			for(int i = 0; i + size <= N; i++) {
				for(int j = 0; j + size <= M; j++) {
					if(isMagic(grid, i, j, size)) {
						return size;
					}
				}
			}
			size--;
		}
		return size;
	}
	
	public static boolean isMagic(int[][] grid, int row, int col, int size) {
		int target = 0;
		
		// target
		for(int j = col; j < col + size; j++) {
			target += grid[row][j];
		}
		
		// the sum of row
		for(int i = row; i < row + size; i++) {
			int sum = 0;
			for(int j = col; j < col + size; j++) {
				sum += grid[i][j];
			}
			if(sum != target) return false;
		}
		
		// the sum of column
		for(int j = col; j < col + size; j++) {
			int sum = 0;
			for(int i = row; i < row + size; i++) {
				sum += grid[i][j];
			}
			if(sum != target) return false;
		}
		
		// the sum of diagonal
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += grid[row + i][col + i];
		}
		if(sum != target) return false;
		
		sum = 0;
		for(int i = 0; i < size; i++) {
			sum += grid[row + i][col + size - 1 - i];
		}
		if(sum != target) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		int[][] m1 = {};
		System.out.println(solution(m1));
		
		int[][] m2 = {{1},{1,2}};
		System.out.println(solution(m2));
		
		int[][] m3 = {{4,3,4,5,3},
					  {2,7,3,8,4},
					  {1,7,6,5,2},
					  {8,4,9,5,5}};
		System.out.println(solution(m3));
		
		int[][] m4 = {{2,2,1,1},
				  	  {2,2,2,2},
				      {1,2,2,2}};
		System.out.println(solution(m4));
		
		int[][] m5 = {{7,2,4},
			  	  	  {2,7,6},
			  	  	  {9,5,1},
			  	  	  {4,3,8},
			  	  	  {3,5,4}};
		System.out.println(solution(m5));
	}
	
}
