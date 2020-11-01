/**
 * 	compute the number of combinations that make up that amount
 * 	
 * 	DP
 */

package CoinChange;

public class CoinChange2 {
	public static int change_2D(int[] coins, int amount) {
		int[][] dp = new int[coins.length+1][amount+1];
		for(int i = 0; i <= coins.length; i++) dp[i][0] = 1; // amount = 0, 1 combination(0 coin)
		
		for(int i = 1; i <= coins.length; i++) {
			for(int j = 1; j <= amount; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-coins[i-1] >= 0) dp[i][j] += dp[i][j-coins[i-1]];
			}
		}
		
		return dp[coins.length][amount];
	}
	
	public static int change_1D(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		dp[0] = 1;
		
		for(int coin : coins) {
			for(int i = coin; i <= amount; i++) {
				dp[i] += dp[i-coin];
			}
		}
		return dp[amount];
	}
	
	public static void main(String[] args) {
		int[] c1 = {1,2,5}; 
		int a1 = 5;
		System.out.println(change_2D(c1, a1));
		System.out.println(change_1D(c1, a1));
		
		int[] c2 = {2}; 
		int a2 = 3;
		System.out.println(change_2D(c2, a2));
		System.out.println(change_1D(c2, a2));
		
		int[] c3 = {10}; 
		int a3 = 10;
		System.out.println(change_2D(c3, a3));
		System.out.println(change_1D(c3, a3));

	}
}
