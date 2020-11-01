/**
 * 	people = 8, group = 4,   result = 5. [1,1,1,5][1,1,2,4][1,1,3,3][1,2,2,3][2,2,2,2]
 * 
 * 	DP
 */

package CoinChange;

public class CoinChangeKLimit {
	public static int change_2D(int[] coins, int amount, int k) {
		int[][] dp = new int[amount+1][k+1];
//		for(int i = 0; i <= amount; i++) {
//			dp[i][0] = 1;
//		}
		dp[0][0] = 1;
		
		for(int coin: coins) { 
			for(int i = coin; i <= amount; i++) { 
				for(int j = 1; j <= k; j++) {
					dp[i][j] += dp[i-coin][j-1];
				}
			}
		}
		for(int i = 0; i <= amount; i++) {
			for(int j = 0; j <= k; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		return dp[amount][k];
	}
	
	public static void main(String[] args) {
		int[] c = {8,1,3,4,6,5,7,2};
		int amount = 8;
		int k = 4;
		System.out.println(change_2D(c, amount, k));
	}
}
