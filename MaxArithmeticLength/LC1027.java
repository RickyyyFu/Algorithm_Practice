package MaxArithmeticLength;

import java.util.*;

//	先全加进去， 再找最长

public class LC1027 {
	public static int longestArithSeqLength(int[] a, int[] b) {
		int[] A = new int[a.length + b.length];
		int k = 0;
		for(int a_n : a) A[k++] = a_n;
		for(int b_n : b) A[k++] = b_n;
		
        int res = 2, n = A.length;
        System.out.println(n);
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
    	int[] a = {0,4,8,20};
    	int[] b = {5,7,12,16,22};
    	
    	System.out.println(longestArithSeqLength(a, b));
    }
}
