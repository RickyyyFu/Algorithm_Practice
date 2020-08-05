package BuyBooks_01Bag;

public class BuyBooks_1D {
	public static int buy_books1(int[] sizes, int[] costs, int budget) {
		int n = sizes.length;
		int dp[] = new int[budget+1];
		for(int i = 1; i <= n; i++) {
			for(int j = budget; j >= costs[i-1]; j--) {
				// note the index of dp and sizes/costs
				dp[j] = Math.max(dp[j], dp[j-costs[i-1]] + sizes[i-1]);
			}
		}
		return dp[budget];
	}
	
	public static void main(String[] args) {
		int[] sizes = {60, 100, 120};
		int[] costs = {10, 20, 30};
		int budget = 50;
		System.out.println(buy_books1(sizes, costs, budget));
	}
}
