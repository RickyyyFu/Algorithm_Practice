package LargestSubGrid;

public class By_PrefixSum {
	public static int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        
        int res = 0;
        int len = 1; // square side length

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
                
                if (i >= len && j >= len && sum[i][j] - sum[i-len][j] - sum[i][j-len] + sum[i-len][j-len] <= threshold)
                    res = len;
                	len++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[][] m1 = {
				{2,2,2},
				{3,3,3},
				{4,4,4}
		};
		System.out.println(maxSideLength(m1, 27));
		System.out.println(maxSideLength(m1, 0));
		int[][] m2 = {
				{1,1,1},
				{1,1,1},
				{1,1,1}
		};
		System.out.println(maxSideLength(m2, 4));
		int[][] m3 = {
				{1,1,1,1},
				{2,2,2,2},
				{3,3,3,3},
				{4,4,4,4}
		};
		System.out.println(maxSideLength(m3, 39));
		
		int[][] m4 = {
				{4,5},
				{6,7}
		};
		System.out.println(maxSideLength(m4, 2));
	}
}
