/**
 * 	the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
	You may assume that you have an infinite number of each kind of coin.
 
 *	DP
 */

package CoinChange;

import java.util.Arrays;

public class CoinChange1 {
	public static int coinChange_2D(int[] coins, int amount) {
		int[][] dp = new int[coins.length+1][amount+1];
		for(int[] arr : dp) {
			Arrays.fill(arr, amount+1);
		}
		for(int i = 0; i <= coins.length; i++) dp[i][0] = 0; // Note: the initialization
		
		for(int i = 1; i <= coins.length; i++) {
			for(int j = 1; j <= amount; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-coins[i-1] >= 0) dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i-1]]+1);
			}
		}
		
		return dp[coins.length][amount] == amount+1 ? -1 : dp[coins.length][amount];
	}
	
	public static int coinChange_1D(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		
		for(int coin : coins) {
			for(int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i-coin]+1);
			}
		}
		return dp[amount] == amount+1 ? -1 : dp[amount];
	}
	
	public static void main(String[] args) {
		int[] c1 = {1,2,5}; 
		int a1 = 11;
		System.out.println(coinChange_2D(c1, a1));
		System.out.println(coinChange_1D(c1, a1));
		
		int[] c2 = {2}; 
		int a2 = 3;
		System.out.println(coinChange_2D(c2, a2));
		System.out.println(coinChange_1D(c2, a2));
		
		int[] c3 = {1}; 
		int a3 = 0;
		System.out.println(coinChange_2D(c3, a3));
		System.out.println(coinChange_1D(c3, a3));
		
		int[] c4 = {1}; 
		int a4 = 1;
		System.out.println(coinChange_2D(c4, a4));
		System.out.println(coinChange_1D(c4, a4));
		
		int[] c5 = {1}; 
		int a5 = 2;
		System.out.println(coinChange_2D(c5, a5));
		System.out.println(coinChange_1D(c5, a5));
	}
}
