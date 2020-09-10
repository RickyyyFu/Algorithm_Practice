// similar to 718   ---->  dp

package LongestCommonContinuousSubarray;

import java.util.*;

public class LongestCommonContinuousSubarray {
	public static void main(String[] args) {
		String[] a = {"3234.html", "xys.html", "7hsaa.html"};
		String[] b = {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
		System.out.println(LCCS(a, b));
	}
	
	public static List<String> LCCS(String[] a, String[] b) {
		List<String> res = new ArrayList<>();
		
		int m =  a.length;
		int n =  b.length;
		if(a == null || b == null || m == 0 || n == 0) return res;
		int max = 0;
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(a[i-1].equals(b[j-1])) dp[i][j] = 1 + dp[i-1][j-1];
				if(max < dp[i][j]) {
					List<String> tmp = new ArrayList<>();
					max = dp[i][j];
					for(int idx = i-max; idx <= i-1; idx++) {
						tmp.add(a[idx]);
					}
					res = tmp;
				}
			}
		}
		return res;
	}
}
