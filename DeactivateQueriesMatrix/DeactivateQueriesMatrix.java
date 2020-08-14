package DeactivateQueriesMatrix;

import java.util.*;

public class DeactivateQueriesMatrix {
	public static List<Integer> matrixQueries(int n, int m, int[][] queries) {
		List<Integer> res = new ArrayList<>();
		
		Set<Integer> deactivate_row = new HashSet<>();
		Set<Integer> deactivate_col = new HashSet<>();
		for(int[] query: queries) {
			if(query[0] == 0) {
				int min_row = 1;
				while(min_row <= n && deactivate_row.contains(min_row)) min_row++;
				int min_col = 1;
				while(min_col <= m && deactivate_col.contains(min_col)) min_col++;
				res.add(min_row * min_col);
			}
			else if(query[0] == 1) deactivate_row.add(query[1]);
			else if(query[0] == 2) deactivate_col.add(query[1]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] queries = {{0},{1,2},{0},{2,1},{0},{1,1},{0}};
		System.out.print(matrixQueries(3,4,queries));
	}
}
