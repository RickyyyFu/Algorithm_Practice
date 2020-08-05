package BuyBooks_01Bag;

public class BuyBooks_2D {
	public static int buy_books(int[] sizes, int[] costs, int budget) {
		int n = sizes.length;
		int dp[][] = new int[n+1][budget+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= budget; j++) {
				// note the index of dp and sizes/costs
				if(costs[i-1] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i-1]] + sizes[i-1]);
			}
		}
		return dp[n][budget];
	}
	
	public static void main(String[] args) {
		int[] sizes = {60, 100, 120};
		int[] costs = {10, 20, 30};
		int budget = 50;
		System.out.println(buy_books(sizes, costs, budget));
	}
}
