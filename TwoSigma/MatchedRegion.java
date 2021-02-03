package TwoSigma;
/**
 * compare the cells in both the grids G1 with G2

	if both 1's, keep as it is
	if both 0's, keep as it is
	if both are different, change the cell to 2;
	count all islands with no adjacent 2. that's the answer
 *
 */

public class MatchedRegion {
	public static int matchedRegion(int[][] m1, int[][] m2) {
		int m = m1.length;
		int n = m1[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(m1[i][j] != m2[i][j]) m1[i][j] = 2;
			}
		}
		
		int res = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(m1[i][j] == 1 && dfs(m1, i, j)) res++;
			}
		}
		return res;
	}
	
	public static boolean dfs(int[][] m1, int i , int j) {
		int m = m1.length;
		int n = m1[0].length;
		
		if(i < 0 || j < 0 || i >= m || j >= n || m1[i][j] == 0) return true;
		if(m1[i][j] == 2) return false;
		
		m1[i][j] = 0;
		return dfs(m1, i-1, j) && dfs(m1, i+1, j) && dfs(m1, i, j-1) && dfs(m1, i, j+1);
	}
	
	public static void main(String[] args) {
		int[][] A = {{1, 1, 1}, {1, 0, 0}, {1, 0, 0}};
	    int[][] B = {{1, 1, 1}, {1, 0, 0}, {1, 0, 1}};
	    System.out.println(matchedRegion(A, B));
	    
		int[][] C = {{1, 1, 1}, {1, 0, 1}, {1, 0, 0}};
	    int[][] D = {{1, 1, 1}, {1, 0, 0}, {1, 0, 1}};
	    System.out.println(matchedRegion(C, D));
	    
		int[][] E = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	    int[][] F = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	    System.out.println(matchedRegion(E, F));
	}
}
